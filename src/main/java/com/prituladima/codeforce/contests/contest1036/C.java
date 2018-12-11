package com.prituladima.codeforce.contests.contest1036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.IntStream;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

//https://codeforces.com/contest/1036

public class C {

    //    long NAXI = 9223372036854775807L;
    long MAXC = 1000000000000000000L;

    private void solve() {
        pregen();

//        for (Long re : res) {
//            soutnl(re);
//        }
        IntStream.range(0, nextInt()).forEach((i) -> soutnl(Classy_Numbers(nextLong(), nextLong())));
    }


    List<Long> LIST = new ArrayList<>(20000);
    Set<Long> res = new HashSet<>();

    private void pregen() {
//        for (long i = 1; i < 1000; i++) {
//            res.add(i);
//        }

        char[] number = new char[18];
        Arrays.fill(number, '0');

        //1
        for (int i = 17; i >= 0; i--) {
            for (char j = '1'; j <= '9'; j++) {
                number[i] = j;
                long newV = Long.parseLong(new StringBuilder().append(number).toString());
//                if (newV != 0)
                res.add(newV);
                number[i] = '0';
            }
        }

        //2
        for (int i = 17; i >= 0; i--) {
            for (char j = '1'; j <= '9'; j++) {

                for (int i2 = 17; i2 >= 0; i2--) {
                    for (char j2 = '1'; j2 <= '9'; j2++) {

                        if (i > i2) {
                            number[i] = j;
                            number[i2] = j2;
                            long newV = Long.parseLong(new StringBuilder().append(number).toString());

                            res.add(newV);

                            number[i] = '0';
                            number[i2] = '0';

                        }
                    }
                }
            }
        }


        //3
        for (int i = 17; i >= 0; i--) {
            for (char j = '1'; j <= '9'; j++) {

                for (int i2 = 17; i2 >= 0; i2--) {
                    for (char j2 = '1'; j2 <= '9'; j2++) {

                        for (int i3 = 17; i3 >= 0; i3--) {
                            for (char j3 = '1'; j3 <= '9'; j3++) {

                                if (i > i2 && i2 > i3) {
                                    number[i] = j;
                                    number[i2] = j2;
                                    number[i3] = j3;

                                    long newV = Long.parseLong(new StringBuilder().append(number).toString());
                                    res.add(newV);

                                    number[i] = '0';
                                    number[i2] = '0';
                                    number[i3] = '0';
                                }
                            }
                        }
                    }
                }
            }
        }


        res.add(MAXC);
//        sout(res.size() + "--" );
        LIST = new ArrayList<>(res);
        Collections.sort(LIST);
    }


    private long Classy_Numbers(long L, long R) {
        if (L == 1)
            return Classy_Numbers(R);
        else
            return Classy_Numbers(1, R) - Classy_Numbers(1, L - 1);
    }

    private long Classy_Numbers(long R) {
        return upperBound(LIST, res.size(), R);
    }

    public static int upperBound(List<Long> array, int length, long value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value >= array.get(mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int lowerBound(List<Long> array, int length, long value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value <= array.get(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        new C().run();
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
        return parseInt(nextToken());
    }

    private long nextLong() {
        return parseLong(nextToken());
    }

    private double nextDouble() {
        return parseDouble(nextToken());
    }

    private int[] nextArr(int size) {
        return stream(new int[size]).map(c -> nextInt()).toArray();
    }

    private long[] nextArrL(int size) {
        return stream(new long[size]).map(c -> nextLong()).toArray();
    }

    private double[] nextArrD(int size) {
        return stream(new double[size]).map(c -> nextDouble()).toArray();
    }

    private char[][] nextCharMatrix(int n) {
        return range(0, n).mapToObj(i -> nextToken().toCharArray()).toArray(char[][]::new);
    }

    private int[][] nextIntMatrix(final int n, final int m) {
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

    private void souf(String format, Object... args) {
        writer.printf(format, args);
    }

    private void sout(Object o) {
        writer.print(o);
    }

    private void newLine() {
        writer.println();
    }

    private void soutnl(Object o) {
        sout(o);
        newLine();
    }

    private int max(int a, int b) {
        return Math.max(a, b);
    }

    private int min(int a, int b) {
        return Math.min(a, b);
    }


}
