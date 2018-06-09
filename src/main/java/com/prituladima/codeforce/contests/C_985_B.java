package com.prituladima.codeforce.contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C_985_B {

    private void solve() throws IOException {

        int n = nextInt(), m = nextInt();

        char[][] arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = nextToken().toCharArray();
        }

        int[] sum = new int[m];

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                sum[j] += Integer.parseInt(arr[i][j] + "");
            }
        }

//        System.out.println(Arrays.toString(sum));

        for (int i = 0; i < n; i++) {
            int[] buff = sum.clone();

            boolean allMoreThanZeroAfterSubtraction = true;
            for (int j = 0; j < m; j++) {
                buff[j] -= Integer.parseInt(arr[i][j] + "");
                allMoreThanZeroAfterSubtraction = buff[j] > 0 && allMoreThanZeroAfterSubtraction;
            }

            if(allMoreThanZeroAfterSubtraction){
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");




    }

    public static void main(String[] args) {
        new C_985_B().run();
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
