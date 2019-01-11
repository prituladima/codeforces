package com.prituladima.codeforce.a2oj.div2A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by prituladima on 6/27/18.
 */
public class Pro16 {

    private void solve() throws IOException {

        int n = nextInt();
        int m = nextInt();

        int[] f = nextArr(m);


        Arrays.sort(f);


        if (n == m) {
            System.out.println(Math.abs(f[0] - f[f.length - 1]));

            return;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= m - n; i++) {
            min = Math.min(min, Math.abs(f[i] - f[i + n - 1]));
        }
        for (int i = m - 1; i >= n - 1; i--) {
            min = Math.min(min, Math.abs(f[i] - f[i - n + 1]));
        }

        System.out.println(min);


    }

    public static void main(String[] args) throws Throwable {
        new Pro16().run();
    }

    StringTokenizer tokenizer;
    BufferedReader reader;
    PrintWriter writer;

    public void run() throws Throwable {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = null;
        solve();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
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


}
