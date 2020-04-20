package com.prituladima.organize;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.URL;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class IntFinder {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        String ARCHIVE = "https://codeforces.com/problemset/page/%d";
        int pages = 51;
        for (int page = 1; page <= pages; page++)
            try {

                URL url = new URL(String.format(ARCHIVE, page));
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();

                InputStream is = url.openStream();
                String result = new BufferedReader(new InputStreamReader(is))
                        .lines().collect(Collectors.joining("\n"));
                int from = 0;
                String pref = "<a href=\"/problemset/problem";
                String suff = ">";
                int last = 0;
                while (last != -1) {
                    last = result.indexOf(pref, from);
                    from = last + 1;
                    final int endIndex = result.indexOf(suff, from) + 1;
                    String key = result.substring(last, endIndex);
                    key = key.replace("<a href=\"", "").replace("\">", "");
                    set.add(key + "?locale=en");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        System.out.println(set.size());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("links.txt"));) {
            for (String s : set) {
                writer.write(s);
                writer.write('\n');
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String base = "https://codeforces.com";
        Set<String> setInt = new TreeSet<>();
        int k = 0;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("int.txt"));) {
            for (String s : set) {
                try {

                    URL url = new URL(base + s);

                    InputStream is = url.openStream();
                    String result = new BufferedReader(new InputStreamReader(is))
                            .lines().collect(Collectors.joining("\n"));
                    k++;
                    if (result.contains("System.out.flush()") || result.contains("interactive") || result.contains("Interaction")) {
                        setInt.add(base + s);
                        writer.write(base + s);
                        writer.write('\n');
                        System.out.println("\nDetected Interactive task - " + base + s);
                    } else {
                        System.out.print("-");
                        if (k % 50 == 0) System.out.println();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(setInt.size() + " interactive!");
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("int.txt"));) {
//            for (String s : setInt) {
//                writer.write(s);
//                writer.write('\n');
//                System.out.println(s);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
