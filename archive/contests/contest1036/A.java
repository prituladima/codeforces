package com.prituladima.codeforce.contests.contest1036;

import java.io.*;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        MAin solver = new MAin();
        solver.solve(1, in, out);
        out.close();
    }

    static class MAin {
        public void solve(int testNumber, InputReader in, PrintWriter out) {

            long k = in.nextLong(), n = in.nextLong();
            out.print((n + k - 1) / k);

        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

    }
}
