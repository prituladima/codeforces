import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
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
        BMaksimalniiPodpryamougolnik solver = new BMaksimalniiPodpryamougolnik();
        solver.solve(1, in, out);
        out.close();
    }

    static class BMaksimalniiPodpryamougolnik {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            long[] a = in.nextLongArray1(n);
            long[] b = in.nextLongArray1(m);

            long[] ansA = new long[n + 1];
            long[] ansB = new long[m + 1];

            long x = in.nextLong();
            a = GeekInteger.calculatePrefixSum(a);
            b = GeekInteger.calculatePrefixSum(b);

            for (int i = 1; i <= n; i++) {
                long mi = (int) 1e9 + 2;
                for (int j = 0; j <= (n - i); j++) {
                    mi = Math.min(a[j + i] - a[j], mi);
                }
                ansA[i] = mi;
            }
            //
            for (int i = 1; i <= m; i++) {
                long mi = (int) 1e9 + 2;
                for (int j = 0; j <= (m - i); j++) {
                    mi = Math.min(b[j + i] - b[j], mi);
                }
                ansB[i] = mi;
            }

            long ans = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    long z = ansA[i] * ansB[j];
                    if (z <= x) {
                        ans = Math.max(ans, i * j);
                    }
                }
            }

            out.printLine(ans);

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

        private boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        private static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public long[] nextLongArray1(int size) {
            long[] array = new long[size + 1];
            for (int i = 1; i <= size; i++) {
                array[i] = nextLong();
            }
            return array;
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

        public OutputWriter printLine(long i) {
            writer.println(i);
            return this;
        }

    }

    static class GeekInteger {
        public static long[] calculatePrefixSum(long[] a) {
            long[] pref = new long[a.length];
            pref[0] = a[0];
            for (int i = 1; i < a.length; i++) pref[i] = pref[i - 1] + a[i];
            return pref;
        }

    }
}

