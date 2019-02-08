package com.prituladima.codeforce.contests.contest1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

/**
 * Created by prituladima on 7/13/18.
 */
public class A {
    private void solve() {

        Set<Character> set = new HashSet<>(Arrays.asList('a', 'o', 'u', 'i', 'e'));

        char[] chars = nextToken().toCharArray();

        if (!set.contains(chars[chars.length - 1]) && chars[chars.length - 1] != 'n') {
            soutnl("NO");
            return;
        }

        boolean expectedGlass = false;

        for (int i = 0; i < chars.length; i++) {
            if (expectedGlass && !set.contains(chars[i])) {
                soutnl("NO");
                return;
            }

            if (!set.contains(chars[i]) && chars[i] != 'n') {
                expectedGlass = true;
            } else {
                expectedGlass = false;
            }
        }

        soutnl(expectedGlass ? "NO" : "YES");


    }

    public static void main(String[] args) {
        new A().run();
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
