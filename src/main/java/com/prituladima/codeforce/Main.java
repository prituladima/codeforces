package com.prituladima.codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by prituladima on 5/23/18.
 */
public class Main {

    private void solve() throws IOException {

        String s = nextToken();
        char[] chars = s.toCharArray();


        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.containsKey(chars[i]) ? map.get(chars[i]) + 1 : 1);
        }


        Set<Character> set = map.keySet();

        if (s.length() < 4 || set.size() > 4) {
            System.out.println("No");
            return;
        } else if (set.size() == 4) {
            System.out.println("Yes");
            return;
        }


        for (Character character : set) {

        }

        System.out.println("No");


    }

    int getSumPath(int a, int b, int pos) {
        return sumNumbers(Math.abs(pos - a)) + sumNumbers(Math.abs(pos - b));
    }

    int sumNumbers(int a) {
        int aa = a + 1;
        int bb = a;
        if (aa % 2 == 0) {
            aa /= 2;
        } else {
            bb /= 2;
        }
        return aa * bb;


    }

    public static void main(String[] args) {
        new Main().run();
    }

    StringTokenizer tokenizer;
    BufferedReader reader;
    PrintWriter writer;

    public void run() {
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

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    int[] nextArr(int size) throws NumberFormatException, IOException {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = nextInt();
        return arr;
    }

    long[] nextArrL(int size) throws NumberFormatException, IOException {
        long[] arr = new long[size];
        for (int i = 0; i < size; i++)
            arr[i] = nextLong();
        return arr;
    }

    double[] nextArrD(int size) throws NumberFormatException, IOException {
        double[] arr = new double[size];
        for (int i = 0; i < size; i++)
            arr[i] = nextDouble();
        return arr;
    }

}