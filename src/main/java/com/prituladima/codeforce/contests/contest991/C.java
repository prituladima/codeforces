package com.prituladima.codeforce.contests.contest991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by prituladima on 6/23/18.
 */
public class C {

    private void solve() throws IOException {

        int n = nextInt();

//        double suum = n;
//        int d = 0;
//        while (suum > 1){
//            d++;
//            suum *= 0.9;
//        }
//
        int k  = 1;
        int n_h = n/2 + n%2;

        for(int d = 1; d < Integer.MAX_VALUE; d++){
            k = n_h / d + ((n_h % d) > 0 ? 1 : 0);

            int rest = n;
            if (rest <= 0) { break; }
            for (int i = 1; i <= d; i++) {
                rest -= k;
                rest = (rest * 9) / 10 + (((rest * 9)%10) > 0 ? 1 : 0);
            }
            if (rest + k * d == n) {
                break;
            }
        }
//
        System.out.println(k);


    }
    int binpow (int a, int n) {
        if (n == 0)
            return 1;
        if (n % 2 == 1)
            return binpow (a, n-1) * a;
        else {
            int b = binpow (a, n/2);
            return b * b;
        }
    }

    public static void main(String[] args) {
        new C().run();
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
