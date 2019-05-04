import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Set;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Comparator;
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
        DFiguriHladni solver = new DFiguriHladni();
        solver.solve(1, in, out);
        out.close();
    }

    static class DFiguriHladni {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            final int n = in.nextInt();
            if (n == 2) {
                out.printLine("YES");
                return;
            }
            final int m = in.nextInt();

            int[] ley = new int[n + 2];

            for (int i = 0; i < m; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int min = Math.min(a, b);
                int max = Math.max(a, b);
                a = min;
                b = max;
                int h = n / 2;
                if (b - a > h) {
                    color(ley, b, ley.length - 1);
                    color(ley, 1, a + 1);
                } else if (b - a < h) {
                    color(ley, a, b + 1);
                } else
//                if (n >= 4)
                {
                    int Q1 = a + 1, Q2 = b - 1, P1 = b + 1, P2 = a - 1;
                    if (P2 == 0) {
                        P2 = n;
                        color(ley, P1, ley.length - 1);
                    } else {
                        color(ley, P1, ley.length - 1);
                        color(ley, 1, P2 + 1);
                    }


                    color(ley, Q1, Q2 + 1);


                }
            }
            for (int i = 1; i < ley.length; i++) {
                ley[i] += ley[i - 1];
            }

//        out.print(ley);
            Set<Integer> divisors = new HashSet<>();
            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    divisors.add(i);
                    divisors.add(n / i);
                }
            }

            divisors.remove(n);
            List<Integer> list = new ArrayList<>(divisors);
            list.sort(Comparator.reverseOrder());

            boolean ok = false;
            for (int div : list) {
                ok |= okWithK(ley, div);
            }
            if (ok) {
                out.printLine("Yes");
            } else {
                out.printLine("No");
            }

        }

        private void color(int[] lay, int L, int R) {
            lay[L]++;
            lay[R]--;
        }

        private boolean okWithK(int[] a, int p) {
            boolean ok = true;
            for (int i = 1; i <= p; i++) {
                int cur = a[i];
                for (int j = i + p; j <= a.length - 2; j += p) {
                    ok &= cur == a[j];
                }
            }
            return ok;
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

        public OutputWriter print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
            return this;
        }

        public OutputWriter printLine(Object... objects) {
            print(objects);
            writer.println();
            return this;
        }

        public void close() {
            writer.close();
        }

    }
}

