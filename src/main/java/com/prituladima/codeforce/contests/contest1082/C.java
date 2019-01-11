package com.prituladima.codeforce.contests.contest1082;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;


public class C implements Runnable {

    FastReader scn;
    PrintWriter out;
    String INPUT = "";

    void solve() {
        int n = scn.nextInt(), m = scn.nextInt();
        int[][] arr = new int[n][2];
        int[] count = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int x = scn.nextInt(), y = scn.nextInt();
            arr[i][0] = x;
            arr[i][1] = y;
            count[x]++;
        }

        long[][] need = new long[m + 1][];
        for (int i = 0; i <= m; i++) {
            need[i] = new long[count[i]];
        }

        for (int i = 0; i < n; i++) {
            need[arr[i][0]][--count[arr[i][0]]] = -arr[i][1];
        }

        for (int i = 0; i <= m; i++) {
            need[i] = scn.shuffle(need[i]);
            Arrays.sort(need[i]);

            for (int j = 0; j < need[i].length; j++) {
                need[i][j] *= -1;
            }

            for (int j = 1; j < need[i].length; j++) {
                need[i][j] += need[i][j - 1];
            }
        }

        long[] ans = new long[Math.max(n, m)];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < need[i].length; j++) {
                if (need[i][j] >= 0) {
                    ans[j] += need[i][j];
                }
            }
        }
        long max = 0;
        for (long z : ans) {
            max = Math.max(max, z);
        }
        out.println(max);
    }

    public void run() {
        long time = System.currentTimeMillis();
        boolean oj = true;//System.getProperty("ONLINE_JUDGE") != null;
        out = new PrintWriter(System.out);
        scn = new FastReader(oj);
        solve();
        out.flush();
        if (!oj) {
            System.out.println(Arrays.deepToString(new Object[]{System.currentTimeMillis() - time + " ms"}));
        }
    }

    public static void main(String[] args) {
        new Thread(null, new C(), "Main", 1 << 26).start();
    }

    class FastReader {
        InputStream is;

        public FastReader(boolean onlineJudge) {
            is = onlineJudge ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        }

        byte[] inbuf = new byte[1024];
        public int lenbuf = 0, ptrbuf = 0;

        int readByte() {
            if (lenbuf == -1)
                throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0)
                    return -1;
            }
            return inbuf[ptrbuf++];
        }

        boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b))
                ;
            return b;
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        char nextChar() {
            return (char) skip();
        }

        String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        String nextLine() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while ((!isSpaceChar(b) || b == ' ')) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        char[] next(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isSpaceChar(b))) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        char[][] nextMatrix(int n, int m) {
            char[][] map = new char[n][];
            for (int i = 0; i < n; i++)
                map[i] = next(m);
            return map;
        }

        int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        int[][] next2DInt(int n, int m) {
            int[][] arr = new int[n][];
            for (int i = 0; i < n; i++) {
                arr[i] = nextIntArray(m);
            }
            return arr;
        }

        long[][] next2DLong(int n, int m) {
            long[][] arr = new long[n][];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLongArray(m);
            }
            return arr;
        }

        long[] shuffle(long[] arr) {
            Random r = new Random();
            for (int i = 1, j; i < arr.length; i++) {
                j = r.nextInt(i);
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];
            }
            return arr;
        }

        int[] uniq(int[] arr) {
            Arrays.sort(arr);
            int[] rv = new int[arr.length];
            int pos = 0;
            rv[pos++] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != arr[i - 1]) {
                    rv[pos++] = arr[i];
                }
            }
            return Arrays.copyOf(rv, pos);
        }
    }

}
