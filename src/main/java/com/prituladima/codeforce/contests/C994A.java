//package com.prituladima.codeforce.contests;//package com.prituladima.codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by prituladima on 6/16/18.
 */
public class C994A {

    public class Point {
        int x;
        int y;

        public Point nextPoint() throws IOException {
            x = nextInt();
            y = nextInt();
            return this;
        }

        public Point rotate45() {
            int buf = x;
            x = y + x;
            y = buf - y;
            return this;
        }
    }


    private void solve() throws IOException {

        Point p1 = new Point().nextPoint();
        Point p2 = new Point().nextPoint();
        Point p3 = new Point().nextPoint();
        Point p4 = new Point().nextPoint();

        Point s1 = new Point().nextPoint();
        Point s2 = new Point().nextPoint();
        Point s3 = new Point().nextPoint();
        Point s4 = new Point().nextPoint();

        int y1 = Math.max(Math.max(p1.y, p2.y), p3.y);
        int y0 = Math.min(Math.min(p1.y, p2.y), p3.y);

        int x1 = Math.max(Math.max(p1.x, p2.x), p3.x);
        int x0 = Math.min(Math.min(p1.x, p2.x), p3.x);


        int midX = (s1.x + s2.x + s3.x + s4.x)/4;
        int midY = (s1.y + s2.y + s3.y + s4.y)/4;

        String ans = "NO";
        if(x0 <= s1.x && s1.x <= x1 && y0 <= s1.y && s1.y <= y1){
            ans = "YES";
        }
        if(x0 <= s2.x && s2.x <= x1 && y0 <= s2.y && s2.y <= y1){
            ans = "YES";
        }
        if(x0 <= s3.x && s3.x <= x1 && y0 <= s3.y && s3.y <= y1){
            ans = "YES";
        }

        if(x0 <= s4.x && s4.x <= x1 && y0 <= s4.y && s4.y <= y1){
            ans = "YES";
        }

        if(x0 <= midX && midX <= x1 && y0 <= midY && midY <= y1){
            ans = "YES";
        }



        p1 = p1.rotate45();
        p2 = p2.rotate45();
        p3 = p3.rotate45();
        p4 = p4.rotate45();

        s1 = s1.rotate45();
        s2 = s2.rotate45();
        s3 = s3.rotate45();
        s4 = s4.rotate45();



        midX = (p1.x + p2.x + p3.x + p4.x)/4;
        midY = (p1.y + p2.y + p3.y + p4.y)/4;

        y1 = Math.max(Math.max(s1.y, s2.y), s3.y);
        y0 = Math.min(Math.min(s1.y, s2.y), s3.y);

        x1 = Math.max(Math.max(s1.x, s2.x), s3.x);
        x0 = Math.min(Math.min(s1.x, s2.x), s3.x);
        if(x0 <= p1.x && p1.x <= x1 && y0 <= p1.y && p1.y <= y1){
            ans = "YES";
        }
        if(x0 <= p2.x && p2.x <= x1 && y0 <= p2.y && p2.y <= y1){
            ans = "YES";
        }
        if(x0 <= p3.x && p3.x <= x1 && y0 <= p3.y && p3.y <= y1){
            ans = "YES";
        }

        if(x0 <= p4.x && p4.x <= x1 && y0 <= p4.y && p4.y <= y1){
            ans = "YES";
        }

        if(x0 <= midX && midX <= x1 && y0 <= midY && midY <= y1){
            ans = "YES";
        }

        System.out.println(ans);

    }

    public static void main(String[] args) {
        new C994A().run();
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
