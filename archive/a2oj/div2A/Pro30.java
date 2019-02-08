package com.prituladima.codeforce.a2oj.div2A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by prituladima on 6/28/18.
 */
public class Pro30 {

    private static class Student {

        int index;
        int part;

        public Student(int index, int part) {
            this.index = index;
            this.part = part;
        }

        public int getIndex() {
            return index;
        }

        public int getPart() {
            return part;
        }
    }

    private void solve() throws IOException {

        int n = nextInt(), k = nextInt();
        PriorityQueue<Student> pqPart =
                new PriorityQueue<>(Comparator.comparingInt(Student::getPart)
                        .thenComparing(Student::getIndex));


        for (int i = 0; i < n; i++) {
            pqPart.add(new Student(i, nextInt()));
        }

        List<Student> ans = new ArrayList<>();
        while (!pqPart.isEmpty()) {
            Student can = pqPart.remove();
            if (can.getPart() + k <= 5) {
                ans.add(can);
            } else {
                break;
            }
        }

        System.out.println(ans.size() / 3);


    }

    public static void main(String[] args) {
        new Pro30().run();
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
