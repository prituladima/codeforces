package com.prituladima.codeforce.contests.contest992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C992D {

    final long INF = 1L << 62;
    final int INF_INT = 1 << 31 - 1;

    private void solve() throws IOException {

        int n = nextInt();
        int k = nextInt();
        int[] v = new int[n];
        int[] next = new int[n];
        for (int i = 0; i < n; ++i) {
            v[i] = nextInt();
        }
        next[n - 1] = n;
        System.out.println(n - 1 + " - " + next[n - 1]);
        for (int i = n - 2; i >= 0; --i) {
            next[i] = (v[i + 1] == 1) ? next[i + 1] : (i + 1);
            System.out.println(i + " - " + next[i]);
        }

        System.out.println(Arrays.toString(next));
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            long sum = 0, prod = 1;
            int j = i;
            while (j < n) {
                if (v[j] == 1) {
                    ans += (prod % k == 0 && prod / k - sum > 0 && (next[j] - j + sum) >= (prod / k)) ? 1 : 0;
                    sum += next[j] - j;
                    j = next[j];
                } else {
                    if (prod > INF / v[j]) {
                        break;
                    }
                    prod *= v[j];
                    sum += v[j];
                    ans += (sum * k == prod) ? 1 : 0;
                    ++j;
                }
            }
        }
        System.out.println(ans);


    }

    public static void main(String[] args) {
        new C992D().run();
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
