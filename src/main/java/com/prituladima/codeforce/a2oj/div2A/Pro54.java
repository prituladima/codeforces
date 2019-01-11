package com.prituladima.codeforce.a2oj.div2A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

/**
 * Created by prituladima on 7/4/18.
 */
public class Pro54 {

    private void solve() {

        int n = nextInt();

        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            int next = nextInt();
            if (next == 0) {
                zero.add(0);
            } else if (next > 0) {
                pos.add(next);
            } else {
                neg.add(next);
            }
        }

        if (pos.size() == 0) {
            pos.add(neg.remove(0));
            pos.add(neg.remove(0));
        }

        if (neg.size() % 2 == 0) {
            zero.add(neg.remove(0));
        }


        System.out.print(neg.size() + " ");
        for (int i = 0; i < neg.size(); i++) {
            System.out.print(neg.get(i) + " ");
        }
        System.out.println();


        System.out.print(pos.size() + " ");
        for (int i = 0; i < pos.size(); i++) {
            System.out.print(pos.get(i) + " ");
        }
        System.out.println();


        System.out.print(zero.size() + " ");
        for (int i = 0; i < zero.size(); i++) {
            System.out.print(zero.get(i) + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        new Pro54().solve();
    }

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer;

    int nextInt() {
        return Integer.parseInt(nextToken());
    }

    long nextLong() {
        return Long.parseLong(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }


    int[] nextArr(int size) {
        return Arrays.stream(new int[size]).map(c -> nextInt()).toArray();
    }

    long[] nextArrL(int size) {
        return Arrays.stream(new long[size]).map(c -> nextLong()).toArray();
    }

    double[] nextArrD(int size) {
        return Arrays.stream(new double[size]).map(c -> nextDouble()).toArray();
    }

    char[][] nextCharMatrix(int n) {
        return range(0, n).mapToObj(i -> nextToken().toCharArray()).toArray(char[][]::new);
    }

    int[][] nextIntMatrix(int n, int m) {
        return range(0, n).mapToObj(i -> nextArr(m)).toArray(int[][]::new);
    }

    double[][] nextDoubleMatrix(int n, int m) {
        return range(0, n).mapToObj(i -> nextArr(m)).toArray(double[][]::new);
    }

    String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }


}
