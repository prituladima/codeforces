package com.prituladima.codeforce.virtual.contest955;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

    public static void main(String[] args) throws IOException {

        FastScanner scanner = new FastScanner(System.in);
        int hh = scanner.nextInt();
        int mm = scanner.nextInt();

        int H = scanner.nextInt();
        int D = scanner.nextInt();


        int C = scanner.nextInt();
        int N = scanner.nextInt();


        int L = 20*60-(hh*60+mm);
        double ans = Double.POSITIVE_INFINITY;
        if(hh < 20){
            ans = Math.min(ans, (H+N-1)/N*C);
        }
        ans = Math.min(ans, (H+Math.max(L, 0)*D+N-1)/N*C*0.8);

        System.out.printf("%.4f", ans);

    }


    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i));
            st = null;
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            if (st == null)
                return br.readLine();
            String line = "";
            if (st.hasMoreTokens())
                line = st.nextToken("");
            st = null;
            return line;
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }

}