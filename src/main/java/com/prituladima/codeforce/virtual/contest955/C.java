//package com.prituladima.codeforce.virtual.contest955;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public final class C {

    void solve() {
        long[] all = new long[1500000];
        int p = 0;
        for (long i = 2; i <= 1000000; i++) {
            long x = 1;
            for (int e = 1; ; e++) {
                double y = (double) x * i;
                if (y > 2e18) break;
                x *= i;
                if (e >= 3 && e % 2 == 1) {
                    long sr = sqrt(x);
                    if (sr * sr != x) {
                        all[p++] = x;
                    }
                }
            }
        }
        all = Arrays.copyOf(all, p);



        HashSet<Long> set = new LinkedHashSet<>();
        for (int i = 0; i < p; i++) {
            set.add(all[i]);
        }

        long[] uniq = new long[set.size()];
        int k = 0;
        for (long cur : set) {
            uniq[k++] = cur;
        }



        all = uniq;
        Arrays.sort(all);

        for (int Q = nextInt(); Q > 0; Q--) {
            long L = nextLong(), R = nextLong();
            long ans = 0;
            long sr = sqrt(R);
            long sl = sqrt(L - 1);
            ans += sr - sl;
            int rr = Arrays.binarySearch(all, R);
            int ll = Arrays.binarySearch(all, L - 1);
            if (rr < 0) rr = -rr - 2;
            if (ll < 0) ll = -ll - 2;
            ans += rr - ll;
            soutnl(ans);
        }
    }

    public static long[] uniq(long[] a) {
        int n = a.length;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || a[i] != a[i - 1]) a[p++] = a[i];
        }
        return Arrays.copyOf(a, p);
    }


    public static long sqrt(long n) {
        long i = Math.max(0, (long) Math.sqrt(n) - 2);
        while (i * i <= n) i++;
        return i - 1;

    }

    public static void main(String[] args) {
        new C().run();
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

    private int max(int a, int b) {
        return Math.max(a, b);
    }

    private int min(int a, int b) {
        return Math.min(a, b);
    }

}