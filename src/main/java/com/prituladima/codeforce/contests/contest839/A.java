package com.prituladima.codeforce.contests.contest839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by prituladima on 6/20/18.
 */
public class A {

    private void solve() throws IOException {

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        String[] arr = string.split("\\.");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() >= 3) {
                char[] ca = arr[i].toCharArray();
                for (int j = 0; j < ca.length - 2; j++) {
                    if (ca[j] != ca[j + 1] && ca[j + 1] != ca[j + 2] && ca[j] != ca[j + 2]) {
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }

        System.out.println("No");


    }

    public static void main(String[] args) {
        new A().run();
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
