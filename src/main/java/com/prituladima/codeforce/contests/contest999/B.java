package com.prituladima.codeforce.contests.contest999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by prituladima on 6/23/18.
 */
public class B {

    private void solve() throws IOException {

        int n = nextInt();
        String t = nextToken();

        if (n == 1) {
            System.out.println(t);

            return;
        }

        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }

        Collections.sort(divisors, Comparator.naturalOrder());

        for (int i = 0; i < divisors.size() - 1; i++) {
            String A = t.substring(0, divisors.get(i));
            A = new StringBuilder(A).reverse().toString();
            String B = t.substring(divisors.get(i));

            t = A + B;
            //System.out.println(Data + " + " + B +  " = " + t);

        }

        System.out.println(new StringBuilder(t).reverse().toString());


    }

    public static void main(String[] args) {
        new B().run();
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
