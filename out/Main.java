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
import java.util.ArrayList;
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
        CDiametrDereva solver = new CDiametrDereva();
        solver.solve(1, in, out);
        out.close();
    }

    static class CDiametrDereva {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int tt = in.nextInt();
            while (tt-- > 0) {
                int n = in.nextInt();
                int ans = 0;
                for (int bit = 0; bit < 9; bit++) {
                    ArrayList<Integer> a = new ArrayList<>();
                    ArrayList<Integer> b = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        if ((i >> bit) % 2 == 1) {
                            a.add(i);
                        } else {
                            b.add(i);
                        }
                    }
                    if (a.isEmpty() || b.isEmpty()) {
                        continue;
                    }
                    out.print(a.size()).space().print(b.size());
                    for (int x : a) {
                        out.space().print(x + 1);
                    }
                    for (int x : b) {
                        out.space().print(x + 1);
                    }
                    out.printLine().flush();
                    int foo = in.nextInt();
                    ans = Math.max(ans, foo);
                }
                out.print(-1).space().print(ans).printLine().flush();
            }
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

        public OutputWriter printLine() {
            writer.println();
            return this;
        }

        public OutputWriter space() {
            writer.print(' ');
            return this;
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }

        public OutputWriter print(int i) {
            writer.print(i);
            return this;
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
}

