package com.prituladima.codeforce.contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by prituladima on 6/16/18.
 */
public class C993B {


    public class Kn {
        int i;
        long p;
        long c;

        long res;

        public Kn(int i, long p, long c) {
            this.i = i;
            this.p = p;
            this.c = c;
        }
    }

    private void solve() throws IOException {

        int n = nextInt();
        int k = nextInt();
        long[] p = nextArrL(n);
        long[] c = nextArrL(n);


        List<Kn> initial = new ArrayList<>();
        List<Kn> sortedC = new ArrayList<>();
        for (int i = 0; i < p.length; i++) {
            Kn cur = new Kn(i, p[i], c[i]);
            initial.add(cur);
            sortedC.add(cur);
        }


        Collections.sort(sortedC, (x, y) -> Long.compare(x.c, y.c));
        for (int j = 0; j < n; j++) {
            int buf = k;
            for (int i = n - 1; i >= 0; i--) {
                if(buf == 0) break;
                if (initial.get(j).p > sortedC.get(i).p && initial.get(j).i != sortedC.get(i).i) {
                    initial.get(j).res += sortedC.get(i).c;
                    buf--;
                }

            }
        }


        for (int i = 0; i < initial.size(); i++) {
            System.out.print((initial.get(i).res + initial.get(i).c) + " ");
        }

    }

    public int bin(
            List<Kn> sortedArray, int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray.get(mid).p < key) {
                index = low = mid + 1;
            } else if (sortedArray.get(mid).p >= key) {
                high = mid - 1;
            }
        }
        return index;
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
