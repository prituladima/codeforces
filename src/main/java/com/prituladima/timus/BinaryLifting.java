package com.prituladima.timus;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public final class BinaryLifting {

    private static class Pair {
        int to;
        int w;

        public Pair(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    Map<Integer, List<Pair>> graph;

    private void solve() {
        int vertexCount = nextInt();

        graph = new HashMap<>();
        for (int i = 1; i <= vertexCount; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < vertexCount - 1; i++) {
            final int from = nextInt() + 1;
            final int to = nextInt() + 1;
            final int w = nextInt();
            graph.get(from).add(new Pair(to, w));
            graph.get(to).add(new Pair(from, w));
        }
        dfs(1, 0);
        //WTF? Binary lifting
        for (int i = 1; (1 << i) <= vertexCount; ++i)
            for (int j = 1; j <= vertexCount; ++j)
                anc[i][j] = anc[i - 1][anc[i - 1][j]];

        int query = nextInt();

        while (query-- > 0) {
            int from = nextInt() + 1;
            int to = nextInt() + 1;

            println(sum[from] + sum[to] - 2L * sum[lca(from, to)]);
        }
    }

    int maxn = 50005;
    int maxlg = 22;

    int anc[][] = new int[maxlg][maxn], level[] = new int[maxn];
    //    vector <pair<int, int> > g[maxn];
    long sum[] = new long[maxn];

    void dfs(int node, int father) {
        level[node] = level[father] + 1;
        anc[0][node] = father;
        for (Pair it : graph.get(node))
            if (it.to != father) {
                sum[it.to] = sum[node] + it.w;
                dfs(it.to, node);
            }
    }

    int lca(int x, int y) {
        if (level[x] < level[y])
            return lca(y, x);
        int diff = level[x] - level[y];
        for (int i = 0; (1 << i) <= diff; ++i)
            if ((diff & (1 << i)) > 0)
                x = anc[i][x];
        if (x == y)
            return x;
        for (int i = maxlg - 1; i >= 0; --i)
            if (anc[i][x] != anc[i][y]) {
                x = anc[i][x];
                y = anc[i][y];
            }
        return anc[0][x];
    }

    public static void main(String[] args) {
        new BinaryLifting().run();
    }

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;

    private void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out))) {
            this.reader = reader;
            this.writer = writer;
            this.tokenizer = null;
            solve();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    private int nextInt(int radix) {
        return parseInt(nextToken(), radix);
    }

    private int nextInt() {
        return parseInt(nextToken());
    }

    private long nextLong(int radix) {
        return parseLong(nextToken(), radix);
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

    private double[][] nextDoubleMatrix(final int n, final int m) {
        return range(0, n).mapToObj(i -> nextArrD(m)).toArray(double[][]::new);
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

    private void printf(String format, Object... args) {
        writer.printf(format, args);
    }

    private void print(Object o) {
        writer.print(o);
    }

    private void println() {
        writer.println();
    }

    private void println(Object o) {
        print(o);
        println();
    }

    private void flush() {
        writer.flush();
    }

}