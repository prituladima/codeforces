package com.prituladima.codeforce.a2oj.div2A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by prituladima on 6/25/18.
 */
public class Pro6 {

    private void solve() throws IOException {
        int n = nextInt();
        int[] a = nextArr(n);
        Arrays.sort(a);


        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        int leftSum = 0;
        int coinsFromLeft = 0;
        for (int i = 0; i < a.length; i++) {
            leftSum += a[i];
            coinsFromLeft++;
            if (leftSum > sum / 2) {
                break;
            }
        }
        int rightSum = 0;
        int coinsFromRight = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            rightSum += a[i];
            coinsFromRight++;
            if (rightSum > sum / 2) {
                break;
            }
        }
        System.out.println(Math.min(coinsFromRight, coinsFromLeft));
    }

    public static void main(String[] args) {
        new Pro6().run();
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
