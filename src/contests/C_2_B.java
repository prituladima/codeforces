package contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class C_2_B {

    static int n;

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        n = in.nextInt();
        int[][] g1 = new int[n][n];
        int[][] g2 = new int[n][n];
        int zi = -1, zj = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = in.nextInt();
                if (v == 0) {
                    g1[i][j] = 1000000000;
                    g2[i][j] = 1000000000;
                    zi = i;
                    zj = j;
                    continue;
                }
                while (v % 5 == 0) {
                    g1[i][j]++;
                    v /= 5;
                }
                while (v % 2 == 0) {
                    g2[i][j]++;
                    v /= 2;
                }
            }
        }
        Solver[] ss = {new Solver(g1), new Solver(g2), new Solver(zi, zj)};
        Arrays.sort(ss, (a, b) -> a.score - b.score);
        Solver s = ss[0];
        System.out.println(s.score);
        System.out.println(s.res);
    }

    static class Solver {
        String res;
        int score;

        public Solver(int[][] g) {
            int[][] m = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m[i][j] = 1000000000;
                    if (i != 0)
                        m[i][j] = Math.min(m[i][j], m[i - 1][j]);
                    if (j != 0)
                        m[i][j] = Math.min(m[i][j], m[i][j - 1]);
                    if (i == 0 && j == 0)
                        m[i][j] = 0;
                    m[i][j] += g[i][j];
                }
            }
            score = m[n - 1][n - 1];
            int i = n - 1, j = n - 1;
            StringBuilder sb = new StringBuilder();
            while (i != 0 || j != 0) {
                int D = i > 0 ? m[i - 1][j] : 1000000000;
                int R = j > 0 ? m[i][j - 1] : 1000000000;
                if (R < D) {
                    sb.append('R');
                    j--;
                } else {
                    sb.append('D');
                    i--;
                }
            }
            res = sb.reverse().toString();
        }

        public Solver(int i, int j) {
            if (i == -1) {
                score = 1000000000;
                return;
            }
            score = 1;
            int ci = 0, cj = 0;
            StringBuilder sb = new StringBuilder();
            while (ci < i) {
                sb.append("D");
                ci++;
            }
            while (cj < j) {
                sb.append("R");
                cj++;
            }
            while (ci < n - 1) {
                sb.append("D");
                ci++;
            }
            while (cj < n - 1) {
                sb.append("R");
                cj++;
            }
            res = sb.toString();
        }
    }

    static class FastScanner {
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