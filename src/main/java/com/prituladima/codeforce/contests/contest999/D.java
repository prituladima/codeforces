package com.prituladima.codeforce.contests.contest999;

import java.io.*;
import java.util.*;

/**
 * Created by prituladima on 6/23/18.
 */
public class D {

    private void solve() throws IOException {

        if (false) {
            int n = 200000;
            int m = 100000;

            writer.println(n + " " + m);
            String s = 1000000000 + " ";
            for (int i = 0; i < n; i++) {
                writer.print(s);
            }

            return;
        }



        int n = nextInt(), m = nextInt();
        int[] a = nextArr(n);
        LinkedList<Integer>[] c = new LinkedList[m];

        for (int i = 0; i < c.length; i++) {
            c[i] = new LinkedList<>();
        }

        long ans = 0;new TreeMap<>();

        int n_m = n / m;

        for (int i = 0; i < n; i++) {
            c[a[i] % m].add(i);
        }

        while (true) {
            int c_index = 0;
            for (; c_index < m && c[c_index].size() >= n_m; c_index++) {}
            if (c_index >= m) {
                break;
            }

            int dist = 1;
            while (true) {
                {
                    int left_index = c_index - dist;
                    if (left_index >= 0 && c[left_index].size() > n_m) {
                        int index_a = c[left_index].pollFirst();
                        c[c_index].addFirst(index_a);
                        a[index_a] += dist;
                        ans += dist;
                        break;
                    }
                }

                {
                    int right_index = m - dist;
                    if (right_index > c_index && c[right_index].size() > n_m) {
                        int index_a = c[right_index].pollFirst();
                        c[c_index].addFirst(index_a);
                        a[index_a] += dist;
                        ans += dist;
                        break;
                    }
                }

                dist++;
            }
        }

        writer.println(ans);
        for (int i : a) {
            writer.print(i + " ");
        }
    }

    public static void main(String[] args) {
        new D().run();
    }

    StringTokenizer tokenizer;
    BufferedReader reader;
    PrintWriter writer;

    public void run() {
        try {
            reader = new BufferedReader(/*new InputStreamReader(System.in)*/ new FileReader("input.txt"));
            tokenizer = null;
            writer = new PrintWriter(/*System.out*/ new File("output.txt"));
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
