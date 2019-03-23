import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author dmytro.prytula prituladima@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        ENastyaNePridumalaLegendu solver = new ENastyaNePridumalaLegendu();
        solver.solve(1, in, out);
        out.close();
    }

    static class ENastyaNePridumalaLegendu {
        int n;
        int q;
        long[] a;
        long[] b;
        long[] prefK;
        long[] k;
        String s;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.nextInt();
            a = in.nextLongArray(n);
            k = in.nextLongArray(n - 1);


            prefK = new long[n];
            b = new long[n];
            for (int i = 1; i < n; i++) {
                prefK[i] = prefK[i - 1] + k[i - 1];
            }

            for (int i = 0; i < n; i++) {
                b[i] = a[i] - prefK[i];
            }

            ENastyaNePridumalaLegendu.SegmentTreeImpl segmentTree = new ENastyaNePridumalaLegendu.SegmentTreeImpl(b);
            ENastyaNePridumalaLegendu.SegmentTreeImpl segmentTree2 = new ENastyaNePridumalaLegendu.SegmentTreeImpl(prefK);

            q = in.nextInt();
            while (q-- > 0) {
                s = in.nextToken();
                if (s.equals("+")) {
                    int pos = in.nextInt() - 1;
                    long val = in.nextLong();
                    val += segmentTree.get_sum(pos, pos);
                    int pos1 = segmentTree.lower_bound(val);
                    segmentTree.set_update(pos, pos1 - 1, val);
                } else {
                    int L = in.nextInt() - 1, R = in.nextInt() - 1;
                    out.printLine(segmentTree.get_sum(L, R) + segmentTree2.get_sum(L, R));
                }
            }

        }

        public static class SegmentTreeImpl {
            long DEFAULT = (long) -1e18;
            long[] t;
            long[] len;
            long[] sum;
            long[] add_mod;
            long[] set_mod;
            int n;

            void build(long[] a, int v, int tl, int tr) {
                if (tl == tr) {
                    t[v] = sum[v] = a[tl];
                    len[v] = 1;
                } else {
                    int tm = (tl + tr) >> 1;
                    build(a, v * 2, tl, tm);
                    build(a, v * 2 + 1, tm + 1, tr);
                    t[v] = Math.max(t[v * 2], t[v * 2 + 1]);
                    sum[v] = sum[v * 2] + sum[v * 2 + 1];
                    len[v] = (tr - tl + 1);
                }
            }

            SegmentTreeImpl(long[] a) {
                n = a.length;
                t = new long[4 * n];
                sum = new long[4 * n];
                add_mod = new long[4 * n];
                set_mod = new long[4 * n];
                Arrays.fill(set_mod, DEFAULT);
                len = new long[4 * n];
                build(a, 1, 0, n - 1);
            }

            void apply_add_mod(int v, long val) {
                if (set_mod[v] != DEFAULT) {
                    set_mod[v] += val;
                } else {
                    add_mod[v] += val;
                }
            }

            void apply_set_mod(int v, long val) {
                add_mod[v] = 0;
                set_mod[v] = val;
            }

            void push(int v) {
                assert (add_mod[v] == 0 || set_mod[v] == DEFAULT);
                if (add_mod[v] != 0) {
                    t[v] += add_mod[v];
                    sum[v] += add_mod[v] * len[v];
                    apply_add_mod(v * 2, add_mod[v]);
                    apply_add_mod(v * 2 + 1, add_mod[v]);
                    add_mod[v] = 0;
                }
                if (set_mod[v] != DEFAULT) {
                    t[v] = set_mod[v];
                    sum[v] = set_mod[v] * len[v];
                    apply_set_mod(v * 2, set_mod[v]);
                    apply_set_mod(v * 2 + 1, set_mod[v]);
                    set_mod[v] = DEFAULT;
                }
            }

            long get_sum(int v) {
                if (set_mod[v] != DEFAULT) {
                    return set_mod[v] * len[v];
                }
                if (add_mod[v] != 0) {
                    return add_mod[v] * len[v] + sum[v];
                }
                return sum[v];
            }

            long get_t(int v) {
                if (set_mod[v] != DEFAULT) {
                    return set_mod[v];
                }
                if (add_mod[v] != 0) {
                    return add_mod[v] + t[v];
                }
                return t[v];
            }

            void recalc(int v) {
                t[v] = Math.max(get_t(v * 2), get_t(v * 2 + 1));
                sum[v] = get_sum(v * 2) + get_sum(v * 2 + 1);
            }

            void set_update(int l, int r, long val, int v, int tl, int tr) {
                if (l > r) {
                    return;
                }
                if (l == tl && r == tr) {
                    apply_set_mod(v, val);
                    return;
                }
                int tm = (tl + tr) >> 1;
                push(v);
                set_update(l, Math.min(r, tm), val, v * 2, tl, tm);
                set_update(Math.max(l, tm + 1), r, val, v * 2 + 1, tm + 1, tr);
                recalc(v);
            }

            long get_sum(int l, int r, int v, int tl, int tr) {
                if (l > r) {
                    return 0;
                }
                if (l == tl && r == tr) {
                    return get_sum(v);
                }
                int tm = (tl + tr) >> 1;
                push(v);
                long res_l = get_sum(l, Math.min(r, tm), v * 2, tl, tm);
                long res_r = get_sum(Math.max(l, tm + 1), r, v * 2 + 1, tm + 1, tr);
                return res_l + res_r;
            }

            int lower_bound(long val, int v, int tl, int tr) {
                if (tl == tr) {
                    return tl;
                }
                push(v);
                int tm = (tl + tr) >> 1;
                if (get_t(v * 2) >= val) {
                    return lower_bound(val, v * 2, tl, tm);
                } else {
                    return lower_bound(val, v * 2 + 1, tm + 1, tr);
                }
            }

            void set_update(int l, int r, long val) {
                set_update(l, r, val, 1, 0, n - 1);
            }

            long get_sum(int l, int r) {
                long res = get_sum(l, r, 1, 0, n - 1);
                return res;
            }

            int lower_bound(long val) {
                if (get_t(1) < val) {
                    return n;
                } else {
                    return lower_bound(val, 1, 0, n - 1);
                }
            }

        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public long[] nextLongArray(int size) {
            long[] array = new long[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextLong();
            }
            return array;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextToken() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        private static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void close() {
            writer.close();
        }

        public void printLine(long i) {
            writer.println(i);
        }

    }
}

