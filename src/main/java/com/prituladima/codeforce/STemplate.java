package com.prituladima.codeforce;

import java.io.*;
import java.util.*;

import static java.util.stream.IntStream.range;
import static java.lang.System.out;

/**
 * Created by prituladima on 5/23/18.
 */
public class STemplate {

    private void solve() {

    }

    public static void main(String[] args) {
        new STemplate().solve();
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

    char[][] nextCharMatrix(int n){
        return range(0, n).mapToObj(i -> nextToken().toCharArray()).toArray(char[][]::new);
    }

    int[][] nextIntMatrix(int n, int m){
        return range(0, n).mapToObj(i -> nextArr(m)).toArray(int[][]::new);
    }

    double[][] nextDoubleMatrix(int n, int m){
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