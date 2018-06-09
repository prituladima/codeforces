package com.prituladima.codeforce.contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by prituladima on 5/14/18.
 */
public class C_979_B {

    private void solve() throws IOException {

        final int n = nextInt();
        final String kuro = nextToken();
        final String shiro = nextToken();
        final String katie = nextToken();

        int len = kuro.length();


        if (len <= n) {
            System.out.println("Draw");
        } else {
            char[] k_arr = kuro.toCharArray();
            char[] sh_arr = shiro.toCharArray();
            char[] ka_arr = katie.toCharArray();

            Map<Character, Integer> k_set = new HashMap<>();
            Map<Character, Integer> sh_set = new HashMap<>();
            Map<Character, Integer> ka_set = new HashMap<>();

            for (int i = 0; i < len; i++) {
                if (!k_set.containsKey(k_arr[i])) {
                    k_set.put(k_arr[i], 1);
                } else {
                    k_set.put(k_arr[i], k_set.get(k_arr[i]) + 1);
                }

                if (!sh_set.containsKey(sh_arr[i])) {
                    sh_set.put(sh_arr[i], 1);
                } else {
                    sh_set.put(sh_arr[i], sh_set.get(sh_arr[i]) + 1);
                }

                if (!ka_set.containsKey(ka_arr[i])) {
                    ka_set.put(ka_arr[i], 1);
                } else {
                    ka_set.put(ka_arr[i], ka_set.get(ka_arr[i]) + 1);
                }

            }

            int maxK = Integer.MIN_VALUE;
            for (Character character : k_set.keySet()) {
                maxK = Math.max(maxK, k_set.get(character));
            }


            int maxSh = Integer.MIN_VALUE;
            for (Character character : sh_set.keySet()) {
                maxSh = Math.max(maxSh, sh_set.get(character));
            }


            int maxKa = Integer.MIN_VALUE;
            for (Character character : ka_set.keySet()) {
                maxKa = Math.max(maxKa, ka_set.get(character));
            }


            boolean[] winners = {false, false, false};


            int steps = len - n;

            if (len - maxK == n && len - maxSh == n && len - maxKa == n) {
                System.out.println("Draw");
            } else if (len - maxK == n && len - maxSh == n && len - maxKa != n) {
                System.out.println("Draw");
            } else if (len - maxK == n && len - maxSh != n && len - maxKa == n) {
                System.out.println("Draw");
            } else if (len - maxK != n && len - maxSh == n && len - maxKa == n) {
                System.out.println("Draw");
            } else if (len - maxK == n && len - maxSh != n && len - maxKa != n) {
                System.out.println("Kuro");
            } else if (len - maxK != n && len - maxSh == n && len - maxKa != n) {
                System.out.println("Shiro");
            } else if (len - maxK != n && len - maxSh != n && len - maxKa == n) {
                System.out.println("Katie");
            } else if (steps - maxK == 1 && steps - maxSh == 1 && steps - maxKa == 1) {
                System.out.println("Draw");
            } else if (steps - maxK == 1 && steps - maxSh == 1 && steps - maxKa != 1) {
                System.out.println("Draw");
            } else if (steps - maxK == 1 && steps - maxSh != 1 && steps - maxKa == 1) {
                System.out.println("Draw");
            } else if (steps - maxK != 1 && steps - maxSh == 1 && steps - maxKa == 1) {
                System.out.println("Draw");
            } else if (steps - maxK == 1 && steps - maxSh != 1 && steps - maxKa != 1) {
                System.out.println("Kuro");
            } else if (steps - maxK != 1 && steps - maxSh == 1 && steps - maxKa != 1) {
                System.out.println("Shiro");
            } else if (steps - maxK != 1 && steps - maxSh != 1 && steps - maxKa == 1) {
                System.out.println("Katie");
            } else if ((n - (len - maxK)) % 2 == 0 && (n - (len - maxSh)) % 2 == 0 && (n - (len - maxKa)) % 2 == 0) {
                System.out.println("Draw");
            } else if ((n - (len - maxK)) % 2 == 0 && (n - (len - maxSh)) % 2 == 0 && (n - (len - maxKa)) % 2 != 0) {
                System.out.println("Draw");
            } else if ((n - (len - maxK)) % 2 == 0 && (n - (len - maxSh)) % 2 != 0 && (n - (len - maxKa)) % 2 == 0) {
                System.out.println("Draw");
            } else if ((n - (len - maxK)) % 2 != 0 && (n - (len - maxSh)) % 2 == 0 && (n - (len - maxKa)) % 2 == 0) {
                System.out.println("Draw");
            } else if ((n - (len - maxK)) % 2 == 0 && (n - (len - maxSh)) % 2 != 0 && (n - (len - maxKa)) % 2 != 0) {
                System.out.println("Kuro");
            } else if ((n - (len - maxK)) % 2 != 0 && (n - (len - maxSh)) % 2 == 0 && (n - (len - maxKa)) % 2 != 0) {
                System.out.println("Shiro");
            } else if ((n - (len - maxK)) % 2 != 0 && (n - (len - maxSh)) % 2 != 0 && (n - (len - maxKa)) % 2 == 0) {
                System.out.println("Katie");
            } else {
                if (maxK > maxSh && maxK > maxKa) {
                    System.out.println("Kuro");
                } else if (maxSh > maxK && maxSh > maxKa) {
                    System.out.println("Shiro");
                } else if(maxKa > maxSh && maxKa > maxK){
                    System.out.println("Katie");
                }
            }


        }


//        List<Character> leters = new ArrayList<>();
//        for (char c = 'A'; c <= 'Z'; c++) {
//            leters.add(c);
//        }
//        for (char c = 'a'; c <= 'z'; c++) {
//            leters.add(c);
//        }
//
//        for (Character step : leters) {
//
//        }


    }

    public static void main(String[] args) {
        new C_979_B().run();
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
