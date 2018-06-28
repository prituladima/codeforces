package com.prituladima.codeforce.a2oj.div2A;

import java.io.*;
import java.util.*;

/**
 * Created by prituladima on 6/28/18.
 */
public class Pro26 {

    private void solve() throws IOException {

        int n = nextInt();

        ArrayList[] gs = {new ArrayList(), new ArrayList(), new ArrayList()};
        for (int i = 0; i < n; i++) {
            gs[nextInt() - 1].add(i);
        }

        int ans = Math.min(Math.min(gs[0].size(), gs[1].size()), gs[2].size());
        System.out.println(ans);

        for (int i = 0; i < ans; i++) {
            System.out.printf("%d %d %d\n", (int)gs[0].get(i) +1, (int)gs[1].get(i)+1, (int)gs[2].get(i)+1);
        }


    }

    public static void main(String[] args) {
        new Pro26().run();
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
