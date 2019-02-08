package com.prituladima.codeforce.a2oj.div2A;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.util.stream.IntStream.range;

public class Pro91 {

    private class Num {
        int index;
        int value = 0;
        Set<Integer> conflicts = new HashSet<>();

        public Num(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int conflicts() {
            return conflicts.size();
        }
    }


    private void solve() {


        int n = nextInt();
        ArrayList<Num> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Num(i, nextInt()));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int valuei = list.get(i).value;
                    Set<Integer> seti = list.get(i).conflicts;

                    int hi = valuei / 100;
                    int di = valuei / 10 % 10;
                    int oi = valuei % 10;


                    int valuej = list.get(j).value;
                    Set<Integer> setj = list.get(j).conflicts;

                    int hj = valuej / 100;
                    int dj = valuej / 10 % 10;
                    int oj = valuej % 10;

                    if ((hi != 0 && hj != 0) || (di != 0 && dj != 0) || (oi != 0 && oj != 0)) {
                        seti.add(j);
                        setj.add(i);
                    }
                }
            }
        }


        Collections.sort(list, Comparator.comparingInt(Num::conflicts).reversed());

        boolean[] ans = new boolean[n];
        int amountToRemove = 0;

        for (int i = 0; i < list.size(); i++) {
            Set<Integer> set = list.get(i).conflicts;
            if (set.size() != 0) {
                ans[i] = true;
                amountToRemove++;
            }

            for (Num num : list) {
                if (num.index != list.get(i).index) {
                    num.conflicts.remove(list.get(i).index);
                }
            }


        }

        soutn(n - amountToRemove);

        for (int i = 0; i < n; i++) {
            if (!ans[i]) souf("%d ", list.get(i).value);
        }

    }

    public static void main(String[] args) {
        new Pro91().run();
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
