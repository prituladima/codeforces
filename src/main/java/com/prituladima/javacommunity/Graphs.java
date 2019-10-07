package com.prituladima.javacommunity;

import com.prituladima.codeforce.Main;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public class Graphs {
    private static final int INF = (int) 1e6;

    private Map<Integer, Set<Integer>> graph;
    private boolean[] used = new boolean[INF];

    private void solve() {

        int n = nextInt();
        graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(i, key -> new LinkedHashSet<>());
        }

        int m = nextInt();
        while (m-- > 0) {
            int from = nextInt();
            int to = nextInt();
            graph.get(from).add(to);
            graph.get(to).add(from);
        }


        bfs(nextInt());

        soutnl("-");

        Arrays.fill(used, false);
        dfs(nextInt());

        soutnl("-");

        Arrays.fill(used, false);
        dfs2(nextInt());

        soutnl("-");

        Arrays.fill(used, false);
        dfs3(nextInt());


    }

    private void bfs(int from) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(from);
        while (!deque.isEmpty()) {
            int cur = deque.removeFirst();
            used[cur] = true;
            soutnl(cur);
            for (int next : graph.get(cur))
                if (!used[next])
                    deque.addLast(next);
        }
    }

    private void dfs(int from) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(from);
        while (!deque.isEmpty()) {
            int cur = deque.removeFirst();
            used[cur] = true;
            soutnl(cur);
            for (int next : graph.get(cur))
                if (!used[next])
                    deque.addFirst(next);
        }
    }

    private void dfs2(int from) {
        used[from] = true;
        soutnl(from);
        for (int next : graph.get(from))
            if (!used[next])
                dfs2(next);
    }

    private void dfs3(int from) {
        used[from] = true;
        for (int next : graph.get(from))
            if (!used[next])
                dfs3(next);
        soutnl(from);
    }


    public static void main(String[] args) {
        new Graphs().run();
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

    private void flush() {
        writer.flush();
    }


}
