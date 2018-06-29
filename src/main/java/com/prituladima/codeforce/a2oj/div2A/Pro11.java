package com.prituladima.codeforce.a2oj.div2A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.StrictMath.abs;

/**
 * Created by prituladima on 6/27/18.
 */
public class Pro11 {

    private void solve() throws IOException {

        int n = nextInt();
        int[] a = nextArr(n);

        int ans;

        int leftMax = n - 1;


        for (int i = a.length - 2; i >= 0; i--) {
            if(a[leftMax] <= a[i]){
                leftMax = i;
            }
        }

        int rightMin = 0;

        for (int i = 1; i < a.length; i++) {
            if(a[rightMin] >= a[i]){
                rightMin = i;
            }
        }

        if(rightMin > leftMax){
            ans = abs(rightMin - n + 1) + abs(leftMax);
        }else if(rightMin < leftMax){
            ans = abs(rightMin - n + 1) + abs(leftMax) - 1;
        }else {
            ans = 0;
        }

        System.out.println(ans);


    }

    private void swap (int[] arr, int a1, int a2){
        int buff = arr[a1];
        arr[a1] = arr[a2];
        arr[a2] = buff;
    }

    public static void main(String[] args) {
        new Pro11().run();
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
