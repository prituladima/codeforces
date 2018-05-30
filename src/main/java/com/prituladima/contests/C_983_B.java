package com.prituladima.contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by prituladima on 5/15/18.
 */
public class C_983_B {

    private void solve() throws IOException {

        int n = nextInt(), m = nextInt();

        char[][] arr = new char[n][m];


        if (n == 1 && m == 1) {
            char ch = nextToken().toCharArray()[0];
            if(Character.isDigit(ch)){
                System.out.println("NO");
            }else
            System.out.println("YES");
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = nextToken().toCharArray();
//            System.out.println(arr[i]);
        }

//        System.out.println(Arrays.toString(arr));

//        boolean Gvalid = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (Character.isDigit(arr[i][j])) {

                    boolean valid = true;
                    int bombs = 0;

                    if (i - 1 >= 0 && j - 1 >= 0) {
                        bombs += arr[i - 1][j - 1] == '*' ? 1 : 0;
                    }

                    if (i - 1 >= 0) {
                        bombs += arr[i - 1][j] == '*' ? 1 : 0;
                    }

                    if (i - 1 >= 0 && j + 1 <= m - 1) {
                        bombs += arr[i - 1][j + 1] == '*' ? 1 : 0;
                    }

                    if (j - 1 >= 0) {
                        bombs += arr[i][j - 1] == '*' ? 1 : 0;
                    }

                    if (i + 1 <= n - 1 && j - 1 >= 0) {
                        bombs += arr[i + 1][j - 1] == '*' ? 1 : 0;
                    }


                    if (i + 1 <= n - 1) {
                        bombs += arr[i + 1][j] == '*' ? 1 : 0;
                    }


                    if (i + 1 <= n - 1 && j + 1 <= m - 1) {
                        bombs += arr[i + 1][j + 1] == '*' ? 1 : 0;
                    }

                    if (j + 1 <= m - 1) {
                        bombs += arr[i][j+1] == '*' ? 1 : 0;
                    }

                    valid = Integer.parseInt(String.valueOf(arr[i][j])) == bombs;

                    if (!valid) {
                        System.out.println("NO");
                        return;
                    }

                } else if (arr[i][j] == '.') {

                    boolean valid = true;
                    int bombs = 0;

                    if (i - 1 >= 0 && j - 1 >= 0) {
                        bombs += arr[i - 1][j - 1] == '*' ? 1 : 0;
                    }

                    if (i - 1 >= 0) {
                        bombs += arr[i - 1][j] == '*' ? 1 : 0;
                    }

                    if (i - 1 >= 0 && j + 1 <= m - 1) {
                        bombs += arr[i - 1][j + 1] == '*' ? 1 : 0;
                    }

                    if (j - 1 >= 0) {
                        bombs += arr[i][j - 1] == '*' ? 1 : 0;
                    }

                    if (i + 1 <= n - 1 && j - 1 >= 0) {
                        bombs += arr[i + 1][j - 1] == '*' ? 1 : 0;
                    }


                    if (i + 1 <= n - 1) {
                        bombs += arr[i + 1][j] == '*' ? 1 : 0;
                    }


                    if (i + 1 <= n - 1 && j + 1 <= m - 1) {
                        bombs += arr[i + 1][j + 1] == '*' ? 1 : 0;
                    }

                    if (j + 1 <= m - 1) {
                        bombs += arr[i][j+1] == '*' ? 1 : 0;
                    }

                    valid = bombs == 0;

                    if (!valid) {
                        System.out.println("NO");
                        return;
                    }

                }

            }
        }

        System.out.println("YES");

    }

    public static void main(String[] args) {
        new C_983_B().run();
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
