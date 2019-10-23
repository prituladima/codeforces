package com.prituladima.codeforce;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public final class Main {

    private static final long MODULO = (int) 1e9 + 7;

    private void solve() {

        long x = nextLong();
        long n = nextLong();

        long ans = 1;

        List<LongIntPair> primeFactors = factorize(x);
        for (LongIntPair primeFactor : primeFactors) {
            long pow = 0;
            long p = primeFactor.first;
            long prime = primeFactor.first;
            for (int i = 0; i <= 63; i++) {
                long d = n / p;
                if(d <= 0) break;
                pow += d;

                long overflowCheck = p;
                p*=prime;//check for overflow
                if(p / overflowCheck != prime){
                    break;
                }
            }

            ans *= power_mod(prime, pow, MODULO);
            ans %= MODULO;

        }


        println(ans);

    }

    public static List<LongIntPair> factorize(long number) {
        List<LongIntPair> result = new ArrayList<>();
        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                int power = 0;
                do {
                    power++;
                    number /= i;
                } while (number % i == 0);
                result.add(LongIntPair.makePair(i, power));
            }
        }
        if (number != 1) {
            result.add(LongIntPair.makePair(number, 1));
        }
        return result;
    }

    public static class LongIntPair implements Comparable<LongIntPair> {
        public final long first;
        public final int second;

        public static LongIntPair makePair(long first, int second) {
            return new LongIntPair(first, second);
        }

        public LongIntPair(long first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            LongIntPair pair = (LongIntPair) o;

            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            int result = Long.hashCode(first);
            result = 31 * result + Integer.hashCode(second);
            return result;
        }


        @Override
        public String toString() {
            return "(" + first + "," + second + ")";
        }

        @SuppressWarnings({"unchecked"})
        public int compareTo(LongIntPair o) {
            int value = Long.compare(first, o.first);
            if (value != 0) {
                return value;
            }
            return Integer.compare(second, o.second);
        }
    }

    static long power_mod(long a, long pow, long mod) {
        long res = 1;
        a = a % mod;
        while (pow > 0) {
            if ((pow & 1) == 1)
                res = (res * a) % mod;
            pow = pow >> 1;
            a = (a * a) % mod;
        }
        return res;
    }


    public static void main(String[] args) {
        new Main().run();
    }

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;

    private void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out))) {
            this.reader = reader;
            this.writer = writer;
            this.tokenizer = null;
            solve();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    private int nextInt(int radix) {
        return parseInt(nextToken(), radix);
    }

    private int nextInt() {
        return parseInt(nextToken());
    }

    private long nextLong(int radix) {
        return parseLong(nextToken(), radix);
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

    private double[][] nextDoubleMatrix(final int n, final int m) {
        return range(0, n).mapToObj(i -> nextArrD(m)).toArray(double[][]::new);
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

    private void printf(String format, Object... args) {
        writer.printf(format, args);
    }

    private void print(Object o) {
        writer.print(o);
    }

    private void println() {
        writer.println();
    }

    private void println(Object o) {
        print(o);
        println();
    }

    private void flush() {
        writer.flush();
    }

}