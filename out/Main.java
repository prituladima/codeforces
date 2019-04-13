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
        CServalISkobochnayaPosledovatelnost solver = new CServalISkobochnayaPosledovatelnost();
        solver.solve(1, in, out);
        out.close();
    }

    static class CServalISkobochnayaPosledovatelnost {
        int n;
        String s;
        char[] chars;
        String NO_ANS = ":(";

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.nextInt();
            if (n % 2 == 1) {
                out.print(NO_ANS);
                return;
            }

            s = in.nextToken();
            chars = s.toCharArray();
            if (chars[0] == ')' || chars[n - 1] == '(') {
                out.print(NO_ANS);
                return;
            }
            chars[0] = '(';
            chars[n - 1] = ')';

            int z1 = 0;

            for (int i = 1; i < n / 2; i++) {
                int j = n - i - 1;
                if (i == 1) {
                    if (chars[i] == ')'
                            || chars[j] == '('
                    ) {
                        out.print(NO_ANS);
                        return;
                    }
                    chars[i] = '(';
                    chars[j] = ')';
                    z1 = 1;
                } else {
                    if (chars[i] == ')' && chars[j] == '(') {
                        if (z1 <= 0) {
                            out.print(NO_ANS);
                            return;
                        }
                        if (chars[i] == '(') z1++;
                        else z1--;
                        continue;
                    }
                    if (chars[i] == ')' && chars[j] == '?') {
                        if (z1 <= 0) {
                            out.print(NO_ANS);
                            return;
                        }
                        chars[i] = ')';
                        chars[j] = '(';
                        if (chars[i] == '(') z1++;
                        else z1--;
                        continue;
                    }

                    if (chars[i] == '(' && chars[j] == ')') {
                        if (chars[i] == '(') z1++;
                        else z1--;
                        continue;
                    }
                    if (chars[i] == '(' && chars[j] == '?') {
                        chars[i] = '(';
                        chars[j] = ')';
                        if (chars[i] == '(') z1++;
                        else z1--;
                        continue;

                    }


                    if (chars[i] == '?' && chars[j] == '?') {

                        chars[i] = '(';
                        chars[j] = ')';
                        if (chars[i] == '(') z1++;
                        else z1--;
                        continue;
                    }


                    if (chars[i] == '?' && chars[j] == ')') {
                        chars[i] = '(';
                        chars[j] = ')';
                        if (chars[i] == '(') z1++;
                        else z1--;
                        continue;
                    }
                    if (chars[i] == '?' && chars[j] == '(') {
                        if (z1 <= 0) {
                            out.print(NO_ANS);
                            return;

                        }
                        chars[i] = ')';
                        chars[j] = '(';
                        if (chars[i] == '(') z1++;
                        else z1--;
                        continue;
                    }

                    out.print(NO_ANS);
                    return;

                }
//            if(chars[i] == '(') z1++;
//            else z1--;
//            chars[i] == '('
            }


            out.printLine(new StringBuilder().append(chars).toString());

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
}

