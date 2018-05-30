package com.prituladima.contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by prituladima on 5/14/18.
 */
public class C_978_F {

    public static class PairS {

        public PairS(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
    }

    public static class PairP{

        public PairP(int i, int r) {
            this.i = i;
            this.r = r;
        }

        int i;
        int r;

    }

    private void solve() throws IOException {

        int n = nextInt();
        long k = nextLong();

        int[] r = nextArr(n);

        List<PairP> progers = new ArrayList<>();
        for (int i = 0; i < r.length; i++) {
            progers.add(new PairP(i, r[i]));
        }

        Collections.sort(progers, (p1, p2) -> Integer.compare(p1.r, p2.r));





        List<PairS> list = new ArrayList<>();
        for (long i = 0; i < k; i++) {
            list.add(new PairS(nextInt(), nextInt()));
        }


        for (int i = 0; i < r.length; i++) {
            int level = r[i];
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < list.size(); j++) {
                PairS pairS = list.get(j);
                if(pairS.x == level) set.add(pairS.y);
                if(pairS.y == level) set.add(pairS.x);
            }
        }




    }

    public static void main(String[] args) {
        new C_978_F().run();
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
