package com.prituladima.geeksforgeeks.geometric_algorithms.lines;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;
import static org.apache.commons.math3.util.FastMath.abs;

public class FindIfAnyTwoSegmentsIntersect {

    final double EPS = 1E-9;

    private void solve() {
        List<DoubleSegment> segments = new ArrayList<>();




        souf("Epsilon = %.9f", EPS);








    }


    boolean doIntersect(DoubleSegment a, DoubleSegment b){
        return doIntersect(a.p1, a.p2, b.p1, b.p2);
    }

    boolean doIntersect(DoublePoint p1, DoublePoint q1, DoublePoint p2, DoublePoint q2) {
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);
        if (o1 != o2 && o3 != o4)
            return true;

        return o1 == 0 && onSegment(p1, q1, p2)
                ||
                o2 == 0 && onSegment(p1, q1, q2)
                ||
                o3 == 0 && onSegment(p2, q2, p1)
                ||
                o4 == 0 && onSegment(p2, q2, q1);

    }



    int orientation(DoublePoint p, DoublePoint q, DoublePoint r) {
        double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        return abs(val) < EPS ? 0 : val > 0 ? 1 : -1;
    }


    boolean onSegment(DoublePoint p, DoublePoint q, DoublePoint r) {
        return min(p.x, q.x) <= r.x && r.x <= max(p.x, q.x) && min(p.y, q.y) <= r.y && r.y <= max(p.y, q.y);
    }

    static class IntPoint extends SPoint<Integer> {
        IntSegment s;
        IntPoint(Integer x, Integer y) {
            super(x, y);
        }
    }

    static class DoublePoint extends SPoint<Double>{
        DoubleSegment s;
        DoublePoint(Double x, Double y) {
            super(x, y);
        }
    }

    static class SPoint<N extends Number> {
        N x;
        N y;
        boolean isLeft;

        SPoint(N x, N y) {
            this.x = x;
            this.y = y;
        }
    }

    static class IntSegment{
        IntPoint p1;
        IntPoint p2;

        IntSegment(IntPoint p1, IntPoint p2) {
            this.p1 = p1;
            this.p2 = p2;
            this.p1.s = this;
            this.p2.s = this;
        }
    }

    static class DoubleSegment{
        DoublePoint p1;
        DoublePoint p2;

        DoubleSegment(DoublePoint p1, DoublePoint p2) {
            this.p1 = p1;
            this.p2 = p2;
            this.p1.s = this;
            this.p2.s = this;
        }
    }

    public static void main(String[] args) {
        new FindIfAnyTwoSegmentsIntersect().run();
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

    private IntPoint nextIntPoint(){
        return new IntPoint(nextInt(), nextInt());
    }

    private IntSegment nextSegment(){
        return new IntSegment(nextIntPoint(), nextIntPoint());
    }

    private DoublePoint nextDoublePoint(){
        return new DoublePoint(nextDouble(), nextDouble());
    }

    private DoubleSegment nextDoubleSegment(){
        return new DoubleSegment(nextDoublePoint(), nextDoublePoint());
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

    private void soutCharArray(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            sout(arr[i]);
        }
    }

    private <T extends Number> void soutNumberArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            soutnl(arr[i]);
        }
    }
}
