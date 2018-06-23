package com.prituladima.codeforce.contests.contest839;

import com.prituladima.codeforce.Template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by prituladima on 6/20/18.
 */
public class B {

    private void solve() throws IOException {

        int n = nextInt(), p = nextInt();
        String s = nextToken();

        if (n == p) {
            System.out.println(s.replace(".", "0"));
            return;
        }

        char[] cs = s.toCharArray();

        int firstP = 0;
        for (int i = 0; i < n; i++) {
            if (cs[i] == '.') firstP = i;
        }


        for (int i = 0; i < p - 1; i++) {

            char[] cs_copy = Arrays.copyOf(cs, cs.length);
            for (int j = 0; j < p - 1; j++) {
                int cur = (p - 1 + j) % p;
                Set<Character> set = new HashSet<>();
                while (cur <= n - 1) {
                    set.add(cs[cur]);
                    cur += p;
                }
                set.remove('.');
                if (set.size() == 1) {
                    cur = (p - 1 + j) % p;
                    char newC = set.iterator().next();
                    while (cur <= n - 1) {
                        cs_copy[cur] = newC;
                        cur += p;
                    }
                }

            }
            if (!new StringBuilder().append(cs_copy).toString().contains(".")) {
                if (cs_copy[firstP] == '1')
                    cs_copy[firstP] = '0';
                else
                    cs_copy[firstP] = '1';

                System.out.println(new StringBuilder().append(cs_copy).toString());
                return;
            }

        }


        System.out.println("No");


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
