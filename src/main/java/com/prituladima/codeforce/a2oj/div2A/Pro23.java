package com.prituladima.codeforce.a2oj.div2A;

import java.io.*;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;

/**
 * Created by prituladima on 6/28/18.
 */
public class Pro23 {


    private class PointT {
        int x;
        int y;

        public PointT(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PointT pointT = (PointT) o;

            if (x != pointT.x) return false;
            return y == pointT.y;
        }
    }

    private void solve() throws IOException {

        final int x1 = nextInt(), y1 = nextInt(), x2 = nextInt(), y2 = nextInt();


        if (x1 != x2 && y1 != y2) {
            if (abs(x1 - x2) != abs(y1 - y2)) {
                System.out.println(-1);
            } else {
                HashSet<PointT> set = new HashSet<>();
                set.add(new PointT(x1, y1));
                set.add(new PointT(x2, y2));
                set.add(new PointT(min(x1, x2), min(y1, y2)));
                set.add(new PointT(max(x1, x2), max(y1, y2)));
                set.add(new PointT(min(x1, x2), max(y1, y2)));
                set.add(new PointT(max(x1, x2), min(y1, y2)));


                set.remove(new PointT(x1, y1));
                set.remove(new PointT(x2, y2));

                Iterator<PointT> point = set.iterator();
                PointT p3 = point.next();
                PointT p4 = point.next();
                System.out.println(p3.x + " " + p3.y + " " + p4.x + " " + p4.y);
            }
        } else if (x1 != x2) {
            int d = abs(x1 - x2);
            System.out.println(x1 + " " + (y1 + d) + " " + x2 + " " + (y2 + d));
        } else if (y1 != y2) {
            int d = abs(y1 - y2);
            System.out.println((x1 + d) + " " + (y1) + " " + (x2 + d) + " " + (y2));
        }


    }

    public static void main(String[] args) {
        new Pro23().run();
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
