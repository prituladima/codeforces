package com.prituladima.codeforce.a2oj.div2A;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

public class Pro95 {

    private void solve() {


        int[][] xy = new int[3][2];

        for (int i = 0; i < 3; i++) {
            xy[i][0] = nextInt();
            xy[i][1] = nextInt();
        }

        int s1p2 = (xy[0][0] - xy[1][0]) * (xy[0][0] - xy[1][0]) + (xy[0][1] - xy[1][1]) * (xy[0][1] - xy[1][1]);
        int s2p2 = (xy[1][0] - xy[2][0]) * (xy[1][0] - xy[2][0]) + (xy[1][1] - xy[2][1]) * (xy[1][1] - xy[2][1]);
        int s3p2 = (xy[0][0] - xy[2][0]) * (xy[0][0] - xy[2][0]) + (xy[0][1] - xy[2][1]) * (xy[0][1] - xy[2][1]);

        if (s1p2 + s2p2 == s3p2 || s1p2 + s3p2 == s2p2 || s3p2 + s2p2 == s1p2) {
            if (s1p2 != 0 && s2p2 != 0 && s3p2 != 0) {
                sout("RIGHT");
                return;
            }
        }

        for (int k = 0; k < 3; k++) {


            xy[k][0]--;

            int s1p2k = (xy[0][0] - xy[1][0]) * (xy[0][0] - xy[1][0]) + (xy[0][1] - xy[1][1]) * (xy[0][1] - xy[1][1]);
            int s2p2k = (xy[1][0] - xy[2][0]) * (xy[1][0] - xy[2][0]) + (xy[1][1] - xy[2][1]) * (xy[1][1] - xy[2][1]);
            int s3p2k = (xy[0][0] - xy[2][0]) * (xy[0][0] - xy[2][0]) + (xy[0][1] - xy[2][1]) * (xy[0][1] - xy[2][1]);

            if (s1p2k + s2p2k == s3p2k || s1p2k + s3p2k == s2p2k || s3p2k + s2p2k == s1p2k) {
                if (s1p2k != 0 && s2p2k != 0 && s3p2k != 0) {
                    sout("ALMOST");
                    return;
                }
            }

            xy[k][0]++;

            /////////

            xy[k][0]++;

            s1p2k = (xy[0][0] - xy[1][0]) * (xy[0][0] - xy[1][0]) + (xy[0][1] - xy[1][1]) * (xy[0][1] - xy[1][1]);
            s2p2k = (xy[1][0] - xy[2][0]) * (xy[1][0] - xy[2][0]) + (xy[1][1] - xy[2][1]) * (xy[1][1] - xy[2][1]);
            s3p2k = (xy[0][0] - xy[2][0]) * (xy[0][0] - xy[2][0]) + (xy[0][1] - xy[2][1]) * (xy[0][1] - xy[2][1]);

            if (s1p2k + s2p2k == s3p2k || s1p2k + s3p2k == s2p2k || s3p2k + s2p2k == s1p2k) {
                if (s1p2k != 0 && s2p2k != 0 && s3p2k != 0) {
                    sout("ALMOST");
                    return;
                }
            }


            xy[k][0]--;

            ////////

            xy[k][1]--;


            s1p2k = (xy[0][0] - xy[1][0]) * (xy[0][0] - xy[1][0]) + (xy[0][1] - xy[1][1]) * (xy[0][1] - xy[1][1]);
            s2p2k = (xy[1][0] - xy[2][0]) * (xy[1][0] - xy[2][0]) + (xy[1][1] - xy[2][1]) * (xy[1][1] - xy[2][1]);
            s3p2k = (xy[0][0] - xy[2][0]) * (xy[0][0] - xy[2][0]) + (xy[0][1] - xy[2][1]) * (xy[0][1] - xy[2][1]);

            if (s1p2k + s2p2k == s3p2k || s1p2k + s3p2k == s2p2k || s3p2k + s2p2k == s1p2k) {
                if (s1p2k != 0 && s2p2k != 0 && s3p2k != 0) {
                    sout("ALMOST");
                    return;
                }
            }


            xy[k][1]++;

            /////////

            xy[k][1]++;


            s1p2k = (xy[0][0] - xy[1][0]) * (xy[0][0] - xy[1][0]) + (xy[0][1] - xy[1][1]) * (xy[0][1] - xy[1][1]);
            s2p2k = (xy[1][0] - xy[2][0]) * (xy[1][0] - xy[2][0]) + (xy[1][1] - xy[2][1]) * (xy[1][1] - xy[2][1]);
            s3p2k = (xy[0][0] - xy[2][0]) * (xy[0][0] - xy[2][0]) + (xy[0][1] - xy[2][1]) * (xy[0][1] - xy[2][1]);

            if (s1p2k + s2p2k == s3p2k || s1p2k + s3p2k == s2p2k || s3p2k + s2p2k == s1p2k) {
                if (s1p2k != 0 && s2p2k != 0 && s3p2k != 0) {
                    sout("ALMOST");
                    return;
                }
            }


            xy[k][1]--;

            ///////////

        }

        sout("NEITHER");

    }

    public static void main(String[] args) {
        new Pro95().run();
    }

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;

    private void run() {
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

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    private int[] nextArr(int size) {
        return Arrays.stream(new int[size]).map(c -> nextInt()).toArray();
    }

    private long[] nextArrL(int size) {
        return Arrays.stream(new long[size]).map(c -> nextLong()).toArray();
    }

    private double[] nextArrD(int size) {
        return Arrays.stream(new double[size]).map(c -> nextDouble()).toArray();
    }

    private char[][] nextCharMatrix(int n) {
        return range(0, n).mapToObj(i -> nextToken().toCharArray()).toArray(char[][]::new);
    }

    private int[][] nextIntMatrix(int n, int m) {
        return range(0, n).mapToObj(i -> nextArr(m)).toArray(int[][]::new);
    }

    private double[][] nextDoubleMatrix(int n, int m) {
        return range(0, n).mapToObj(i -> nextArr(m)).toArray(double[][]::new);
    }

    private String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    private void soutn() {
        writer.println();
    }

    private void soutn(Object o) {
        writer.println(o);
    }

    private void sout(Object o) {
        writer.print(o);
    }

    private void souf(String format, Object... args) {
        writer.printf(format, args);
    }

    private <Param> void sout(Param[] arr) {
        writer.println(Arrays.toString(arr));
    }

}
