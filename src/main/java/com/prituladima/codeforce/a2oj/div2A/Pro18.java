package com.prituladima.codeforce.a2oj.div2A;

import java.io.*;
import java.util.*;

/**
 * Created by prituladima on 6/27/18.
 */
public class Pro18 {

    private void solve() throws IOException {

        Scanner scanner = new Scanner(System.in);
        String input  = scanner.nextLine();
        input = input.replace('}', ' ').replace('{', ' ');

        String[] sps = input.split(",");


//        System.out.println(Arrays.toString(sps));
        Set<String> set = new HashSet<>();
        for (int i = 0; i < sps.length; i++) {
            String can = sps[i].trim();

            if(!can.isEmpty()){
                set.add(can);
            }
        }


        System.out.println(set.size());


    }

    public static void main(String[] args) {
        new Pro18().run();
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
