package com.prituladima.codeforce.a2oj.div2B;


import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

/**
 * Created by prituladima on 5/23/18.
 */
public final class Pro25 {

    private void solve() {

        int n = nextInt();
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        long sumF = 0;
        long sumS = 0;

        boolean Flast = true;
        for (int i = 0; i < n; i++) {
            int next = nextInt();
            if (next > 0) {
                sumF += next;
                first.add(next);
                Flast = true;
            } else {
                sumS -= next;
                second.add(-next);
                Flast = false;
            }
        }


        if (sumF > sumS) {
            sout("first");
            return;
        } else if (sumF < sumS) {
            sout("second");
            return;
        } else {


            if (first.size() > second.size()) {
                int diff = first.size() - second.size();
                for (int i = 0; i < diff; i++) {
                    second.add(0);
                }

            } else if (first.size() < second.size()) {
                int diff = second.size() - first.size();
                for (int i = 0; i < diff; i++) {
                    first.add(0);
                }
            }


            for (int i = 0; i < first.size(); i++) {
                if (second.get(i) > first.get(i)) {
                    sout("second");
                    return;
                } else if (second.get(i) < first.get(i)) {
                    sout("first");
                    return;
                }

            }
        }

        sout(Flast ? "first" : "second");

    }

    public static void main(String[] args) {
        new Pro25().run();
    }

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;

    private void run() {
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

    private int nextInt() {
        return parseInt(nextToken());
    }

    private long nextLong() {
        return parseLong(nextToken());
    }

    private double nextDouble() {
        return parseDouble(nextToken());
    }

    private int[] nextArr(int size) {
        return stream(new int[size]).map(c -> nextInt()).toArray();
    }

    private long[] nextArrL(int size) {
        return stream(new long[size]).map(c -> nextLong()).toArray();
    }

    private double[] nextArrD(int size) {
        return stream(new double[size]).map(c -> nextDouble()).toArray();
    }

    private char[][] nextCharMatrix(int n) {
        return range(0, n).mapToObj(i -> nextToken().toCharArray()).toArray(char[][]::new);
    }

    private int[][] nextIntMatrix(final int n, final int m) {
        return range(0, n).mapToObj(i -> nextArr(m)).toArray(int[][]::new);
    }

    private double[][] nextDoubleMatrix(int n, int m) {
        return range(0, n).mapToObj(i -> nextArr(m)).toArray(double[][]::new);
    }

    private String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    private void souf(String format, Object... args) {
        writer.printf(format, args);
    }

    private void sout(Object o) {
        writer.print(o);
    }

    private void newLine() {
        writer.println();
    }

    private void soutnl(Object o) {
        sout(o);
        newLine();
    }

    private void soutCharArray(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            sout(arr[i]);
        }
    }

    private <T extends Number> void soutNumberArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            soutnl(arr[i]);
        }
    }

}
