package com.prituladima.codeforce.contests.contest992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by prituladima on 6/18/18.
 */
public class C992C {
    long MOD = 1000000007;

    private void solve() throws IOException {


        long x = nextLong(), k = nextLong();

        if (x == 0) {
            System.out.println(0);
            return;
        }


        long b = fast_expo(2, k);
        long a = (b * 2) % MOD;

        long u = ((x % MOD) * a) % MOD;
        long v = (b - 1 + MOD) % MOD;
        System.out.print((u - v + MOD) % MOD);

    }

    private long fast_expo(long a, long b) {
        long res = 1L;
        a = a % MOD;
        while (b > 0) {
            if ((b & 1) != 0) {
                res = (res * a) % MOD;
            }
            b = b >> 1;
            a = (a * a) % MOD;
        }
        return res % MOD;
    }


    public static void main(String[] args) {
        new C992C().run();
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
