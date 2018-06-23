package com.prituladima.codeforce.contests.contest999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by prituladima on 6/23/18.
 */
public class C {

    private static class Staff {

        public Staff(char c, int i) {
            this.c = c;
            this.i = i;
        }

        char c;
        int i;

        public char getC() {
            return c;
        }

        public int getI() {
            return i;
        }
    }


    private void solve() throws IOException {

        int n = nextInt(), k = nextInt();
        String s = nextToken();


        char[] chars = s.toCharArray();

        List<Staff> list = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            list.add(new Staff(chars[i], i));
        }

        Collections.sort(list, Comparator.comparing(Staff::getC).thenComparing(Staff::getI));

        list = list.subList(k, n);

        Collections.sort(list, Comparator.comparing(Staff::getI));


        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            SB.append(list.get(i).c);
        }


        System.out.println(SB.toString());

    }

    public static void main(String[] args) {
        new C().run();
    }

    StringTokenizer tokenizer;
    BufferedReader reader;
    PrintWriter writer;

    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            writer = new PrintWriter(System.out);
            solve();
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    int[] nextArr(int size) throws NumberFormatException, IOException {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = nextInt();
        return arr;
    }

    long[] nextArrL(int size) throws NumberFormatException, IOException {
        long[] arr = new long[size];
        for (int i = 0; i < size; i++)
            arr[i] = nextLong();
        return arr;
    }

    double[] nextArrD(int size) throws NumberFormatException, IOException {
        double[] arr = new double[size];
        for (int i = 0; i < size; i++)
            arr[i] = nextDouble();
        return arr;
    }


}
