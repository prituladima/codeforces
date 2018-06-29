package com.prituladima.codeforce.a2oj.div2A;

import java.io.*;
import java.util.*;
import static java.util.stream.IntStream.*;

/**
 * Created by prituladima on 6/28/18.
 */
public class Pro31 {

    private void solve() throws IOException {

        int r = nextInt();
        int c = nextInt();

        char[][] mtx = new char[r][c];

        for (int i = 0; i < r; i++) {
            mtx[i] = nextToken().toCharArray();
        }


        Set<Integer> ra = new HashSet<>();
        range(0, r).forEach(ra::add);
        Set<Integer> ca = new HashSet<>();
        range(0, c).forEach(ca::add);

//        System.out.println(ra);
//        System.out.println(ca);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(mtx[i][j] == 'S'){
                    ra.remove(i);
                    ca.remove(j);
                }
            }
        }

//        System.out.println(ra);
//        System.out.println(ca);

//        System.out.println(ra.size());
//        System.out.println(ca.size());
//        System.out.println(r);
//        System.out.println(c);

        System.out.println(ra.size()*c + ca.size()*r - ra.size()*ca.size());

    }

    public static void main(String[] args) {
        new Pro31().run();
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
