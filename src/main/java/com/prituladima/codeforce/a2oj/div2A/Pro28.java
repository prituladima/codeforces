package com.prituladima.codeforce.a2oj.div2A;

import java.io.*;
import java.util.*;

/**
 * Created by prituladima on 6/28/18.
 */
public class Pro28 {

    private void solve() throws IOException {

        int n = nextInt(), m = nextInt();
        char[] body = new char[m];
        char[] right = new char[m];
        char[] left = new char[m];
        Arrays.fill(body, '#');
        Arrays.fill(right, '.');
        Arrays.fill(left, '.');
        right[m -1] = '#';
        left[0] = '#';

        String bodyS = new StringBuffer().append(body).toString();
        String leftS = new StringBuffer().append(left).toString();
        String rightS = new StringBuffer().append(right).toString();

        System.out.println(bodyS);

        boolean isRight = true;
        for (int i = 1; i < n; i+=2) {

            if(isRight){
                System.out.println(rightS);
            }else {
                System.out.println(leftS);
            }
            isRight = !isRight;
            System.out.println(bodyS);
        }





    }

    public static void main(String[] args) {
        new Pro28().run();
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
