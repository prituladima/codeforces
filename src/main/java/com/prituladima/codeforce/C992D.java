package com.prituladima.codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by prituladima on 6/18/18.
 */
public class C992D {

    private void solve() throws IOException {

        int n = nextInt(), k = nextInt();
        int[] a = nextArr(n);

        int ans = 0;
        for (int i = 1; i <= Math.min(n, 61); i++) {

            int left = 0;
            long p = 1;
            long s = 0;

            for (int j = 0; j < i; j++){
                p *= a[j];
                s += a[j];
            }

            if (p % s == 0 && p / s == k) {
                ans++;
            }

            for (int j = i; j < n; j++) {



                p/=a[left];
                s-=a[left];

                p *= a[j];
                s += a[j];

                if (p % s == 0 && p / s == k) {
                    ans++;
                }

                left++;
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
