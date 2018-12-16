package com.prituladima.codeforce.contests.contest1082;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public final class B {

    private void solve() {

        int n = nextInt();
        String S = nextToken();

        if (!S.contains("S")) {
            sout(n);
            return;
        }

        if(!S.contains("G")){
            sout(0);
            return;
        }

        char[] chars = S.toCharArray();

        long counter_gold = S.chars().filter(c -> c == 'G').count();

        if(S.length() == 2){
            sout(counter_gold);
            return;
        }


        int[] Ri = new int[n];
        int[] Li = new int[n];
        for (int i = 0; i < chars.length; i++) {
            if(i == 0 && chars[i] == 'G'){
                Li[0] = 1;
            } else if(chars[i] == 'G') {
                Li[i] = Li[i - 1] + 1;
            } else {
                Li[i] = 0;
            }
        }

        for (int i = chars.length - 1; i >= 0; i--) {
            if(i == n - 1 && chars[i] == 'G'){
                Ri[n - 1] = 1;
            } else if(chars[i] == 'G') {
                Ri[i] = Ri[i + 1] + 1;
            } else {
                Ri[i] = 0;
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < chars.length - 1; i++) {
            int both = Li[i - 1 ] +  Ri[i + 1];
            ans = Math.max(ans, Math.min(both + 1, (int)counter_gold));
        }
        sout(ans);
    }


    static int maxSubArraySum(int a[], int size)
    {
        int max_so_far = Integer.MIN_VALUE,
                max_ending_here = 0,start = 0,
                end = 0, s = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here += a[i];

            if (max_so_far < max_ending_here)
            {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }

            if (max_ending_here < 0)
            {
                max_ending_here = 0;
                s = i + 1;
            }
        }

        return max_so_far;

    }


    public static void main(String[] args) {
        new B().run();
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