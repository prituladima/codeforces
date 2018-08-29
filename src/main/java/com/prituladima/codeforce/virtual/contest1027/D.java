package com.prituladima.codeforce.virtual.contest1027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public class D {
    int maxn = 200020;
    int n;
    int[] c = new int[maxn];
    int[] a = new int[maxn];
    int[] d = new int[maxn];
    int dnum;
    int[] v = new int[maxn];
    int flag;


    int ans;

    void dfs(int k) {
        if (v[k] == 2) {
            flag = 1;
            for (int i = 1; i <= dnum; i++) v[d[i]] = 2;
            return;
        }
        if (v[k] == 1) {
            int tmp = 100000;
            for (int i = dnum; i > 0; i--) {
                tmp = min(tmp, c[d[i]]);
                if (d[i] == k) break;
            }
            ans += tmp;
            for (int i = 1; i <= dnum; i++) v[d[i]] = 2;
            flag = 1;
            return;
        }
        v[k] = 1;
        dnum++;
        d[dnum] = k;
        dfs(a[k]);
    }

    private void solve() {

        n = nextInt();
        for (int i = 1; i <= n; i++) c[i] = nextInt();
        for (int i = 1; i <= n; i++) a[i] = nextInt();
        for (int i = 1; i <= n; i++) {
            if (v[i] > 0) continue;
            flag = 0;
            dnum = 0;
            dfs(i);
        }
        souf("%d", ans);
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

}