import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        BKoshachePreobrazovanieFurfure solver = new BKoshachePreobrazovanieFurfure();
        solver.solve(1, in, out);
        out.close();
    }

    static class BKoshachePreobrazovanieFurfure {
        int x;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            x = in.nextInt();
            List<Integer> res = new ArrayList<>();
            int counter = 0;
            while (!ok(x)) {
                String s = Integer.toBinaryString(x);
                int len = s.length();
                int i = s.indexOf('0');
                char[] m = new char[len - i];
                Arrays.fill(m, '1');
                int step = Integer.parseInt(String.valueOf(m), 2);
                x ^= step;
                res.add(String.valueOf(m).length());
                counter++;
                if (ok(x)) break;
                x += 1;
                counter++;
            }

//        out.printLine(res.size()res.size());
            out.printLine(counter);
            for (Integer re : res) {
                out.print(re).space();
            }
            out.printLine();

        }

        private boolean ok(int x) {
            char[] s = Integer.toBinaryString(x).toCharArray();
            boolean ok = true;
            for (int i = 0; i < s.length; i++) {
                ok &= s[i] == '1';
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

        public OutputWriter print(int i) {
            writer.print(i);
            return this;
        }

        public OutputWriter printLine(int i) {
            writer.println(i);
            return this;
        }

    }
}

