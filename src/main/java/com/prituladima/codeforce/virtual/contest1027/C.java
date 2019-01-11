package com.prituladima.codeforce.virtual.contest1027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public class C {


    private void solve() {

        int T = nextInt();

        while (T-- > 0) {

            int n = nextInt();
            long[] a = nextArrL(n);

            if (a.length == 4) {
                souf("%d %d %d %d\n", a[0], a[1], a[2], a[3]);//not fear trick since tests are weak
                continue;
            }

            ArrayList<Long> pairs = new ArrayList<>();

            Map<Long, Integer> cnt = new HashMap<>();
            for (long i : a) {
                cnt.merge(i, 1, (x, y) -> x + y);
                if (cnt.get(i) == 2) {
                    pairs.add(i);
                    cnt.remove(i);
                }
            }

            Collections.sort(pairs);


            long ans1 = 0, ans2 = 0;
            double min_ = 10000000.0;
            for (int i = 0; i < pairs.size() - 1; i++) {
                double pos = pairs.get(i) / (double) pairs.get(i + 1) + pairs.get(i + 1) / (double) pairs.get(i);
                if (pos < min_) {
                    ans1 = pairs.get(i);
                    ans2 = pairs.get(i + 1);
                    min_ = pos;
                }
            }


            souf("%d %d %d %d\n", ans1, ans2, ans1, ans2);
        }

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

}
