package com.prituladima.codeforce.contests.contest1007;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

/**
 * Created by prituladima on 7/13/18.
 */
public class D {

    public static class TripLL {
        int f, s, sd;

        public TripLL(int f, int s, int sd) {
            this.f = f;
            this.s = s;
            this.sd = sd;
        }

        public int getF() {
            return f;
        }

        public int getS() {
            return s;
        }

        public int getSd() {
            return sd;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TripLL tripLL = (TripLL) o;

            if (f != tripLL.f) return false;
            if (s != tripLL.s) return false;
            return sd == tripLL.sd;
        }

        @Override
        public int hashCode() {
            int result = f;
            result = 31 * result + s;
            result = 31 * result + sd;
            return result;
        }
    }


    private void solve() {

        int n = nextInt();
        while (n-- > 0) {

            int a = nextInt(), b = nextInt(), c = nextInt();
            int x = 0;

            for (int i = 1; i <= a; i++) x += a % i == 0 ? 1 : 0;

            int y = 0;
            for (int i = 1; i <= b; i++) y += b % i == 0 ? 1 : 0;

            int z = 0;
            for (int i = 1; i <= c; i++) z += c % i == 0 ? 1 : 0;

            HashSet<TripLL> set = new HashSet<>();
//            HashSet<TripLL> set1 = new HashSet<>();
//            HashSet<TripLL> set2 = new HashSet<>();


            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    for (int k = 0; k < z; k++) {
                        if (i <= j && j <= k) {

                            set.add(new TripLL(i, j, k));
                        }
                        if (j <= k && k <= i) {
                            set.add(new TripLL(j, k, i));
                        }

                        if (k <= i && i <= j) {
                            set.add(new TripLL(k, i, j));
                        }
                    }
                }
            }
            soutnl(set.size());
        }

    }

    public static void main(String[] args) {
        new D().run();
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
