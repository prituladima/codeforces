package com.prituladima.codeforce.contests;
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by prituladima on 6/16/18.
 */
public class C993B {

    public class Knight implements Comparable<Integer>{
        int index;
        int power;
        int coin;

        public Knight(int index, int power, int coin) {
            this.index = index;
            this.power = power;
            this.coin = coin;
        }

        @Override
        public int compareTo(Integer o) {
            return Integer.compare(power, o);
        }
    }

    private void solve() throws IOException {
        int n = nextInt();
        int k = nextInt();


        Knight[] a = new Knight[n];
        for (int i = 0; i < n; i++) a[i] = new Knight(i, nextInt(), 0);
        for (int i = 0; i < n; i++) a[i].coin = nextInt();
        Arrays.sort(a, (x, y) -> Long.compare(x.power, y.power));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans[] = new long[n];
        for (int i = 0; i < n; i++) {
            long sum = 0;
            ArrayList<Integer> store = new ArrayList<>();
            for (int j = 0; j < k && !pq.isEmpty(); j++) {
                int x = pq.remove();
                sum += x;
                store.add(x);
            }
            ans[a[i].index] = sum + a[i].coin;
            for (int x : store) pq.add(x);
            pq.add(a[i].coin);
        }

        for (long x : ans) System.out.printf("%d ", x);

    }

    public static void main(String[] args) {
        new C993B().run();
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
