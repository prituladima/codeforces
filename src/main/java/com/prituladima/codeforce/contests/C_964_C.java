package com.prituladima.codeforce.contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C_964_C {


    private void solve() throws IOException {

        long n = nextLong(), a = nextLong(), b = nextLong(), k = nextLong();

        char[] chars = nextToken().toCharArray();
        int[] ints = new int[chars.length];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = chars[i] == '+' ? 1 : -1;
        }

        long sum = 0;

        int index = 0;
        while (true) {
            sum += ints[index % ints.length] * binpow(a, n - index) * binpow(b, index);
            index++;
            if (n - index == -1) break;
        }


        long divisor = binpow(10, 9) + 9;

        long result = sum % divisor;
        result = result < 0 ? divisor + result : result;

        System.out.println(result);


    }

    private long binpow(long a, long n) {
        int res = 1;
        while (n != 0) {
            if ((n & 1) != 0)
                res *= a;
            a *= a;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        new C_964_C().run();
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
