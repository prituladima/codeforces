package com.prituladima.codeforce.a2oj.div2A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

public class Pro77 {

    private void solve() {

        final int n = nextInt();

        Map<Character, Integer> map = new HashMap<>();
        String condition;
        int value;
        String isCorrect;

        for (int i = 0; i < n; i++) {
            condition = nextToken();
            value = nextInt();
            isCorrect = nextToken();
            if (isCorrect.charAt(0) == 'N') {
                switch (condition) {
                    case ">=":
                        condition = "<";
                        break;
                    case ">":
                        condition = "<=";
                        break;
                    case "<=":
                        condition = ">";
                        break;
                    case "<":
                        condition = ">=";
                        break;
                }
            }

            switch (condition) {
                case ">=":
                    map.putIfAbsent('>', value - 1);
                    map.merge('>', value - 1, Math::max);
                    break;
                case "<=":
                    map.putIfAbsent('<', value + 1);
                    map.merge('<', value + 1, Math::min);
                    break;
                case "<":
                    map.putIfAbsent('<', value);
                    map.merge('<', value, Math::min);
                    break;
                case ">":
                    map.putIfAbsent('>', value);
                    map.merge('>', value, Math::max);
                    break;

            }

        }


        if (map.get('<') == null) {
            sout(map.get('>') + 1);
            return;
        }
        if (map.get('>') == null) {
            sout(map.get('<') - 1);
            return;
        }
        sout(map.get('>') + 1 < map.get('<') ? map.get('>') + 1 : "Impossible");


    }

    public static void main(String[] args) {
        new Pro77().run();
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
        return Integer.parseInt(nextToken());
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    private int[] nextArr(int size) {
        return Arrays.stream(new int[size]).map(c -> nextInt()).toArray();
    }

    private long[] nextArrL(int size) {
        return Arrays.stream(new long[size]).map(c -> nextLong()).toArray();
    }

    private double[] nextArrD(int size) {
        return Arrays.stream(new double[size]).map(c -> nextDouble()).toArray();
    }

    private char[][] nextCharMatrix(int n) {
        return range(0, n).mapToObj(i -> nextToken().toCharArray()).toArray(char[][]::new);
    }

    private int[][] nextIntMatrix(int n, int m) {
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

    private void soutn() {
        writer.println();
    }

    private void soutn(Object o) {
        writer.println(o);
    }

    private void sout(Object o) {
        writer.print(o);
    }

    private void souf(String format, Object... args) {
        writer.printf(format, args);
    }

    private <Param> void sout(Param[] arr) {
        writer.println(Arrays.toString(arr));
    }
}