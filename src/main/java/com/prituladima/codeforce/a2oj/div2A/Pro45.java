//package com.prituladima.codeforce.a2oj.div2A;

import java.io.*;
import java.util.*;

import static java.util.stream.IntStream.range;

/**
 * Created by prituladima on 6/30/18.
 */
public class Pro45 {

    private static class PaintS{
        int x;
        int y;

        public PaintS(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void solve() {

        int n = nextInt();

        PaintS[] paints = new PaintS[n];
        for (int i = 0; i < n; i++) {
            int x = nextInt(), y = nextInt();
            paints[i] = new PaintS(x, y);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            PaintS paint = paints[i];
            int counter = 0;
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if(paints[j].x < paint.x && paints[j].y == paint.y)set.add('L');
                if(paints[j].x > paint.x && paints[j].y == paint.y)set.add('R');
                if(paints[j].x == paint.x && paints[j].y > paint.y)set.add('U');
                if(paints[j].x == paint.x && paints[j].y < paint.y)set.add('D');
            }
            if(set.size() == 4){
                ans ++;
            }

        }


        System.out.println(ans);

    }

    public static void main(String[] args) {
        new Pro45().solve();
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
