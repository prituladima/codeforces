import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Map;
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
        HPilkiiPotokLyubvi solver = new HPilkiiPotokLyubvi();
        solver.solve(1, in, out);
        out.close();
    }

    static class HPilkiiPotokLyubvi {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            final int n = in.nextInt();
            final char[] s = in.nextToken().toCharArray();

            Map<String, Integer> ans = new HashMap<>();
            for (int c = 0; c < 26; c++) {
                for (int i = 0; i < n; i++) {
                    int replace_ct = 0;
                    for (int j = i; j < n; ++j) {
                        if (s[j] != c) ++replace_ct;
                        int value = Math.max(ans.get(replace_ct + String.valueOf(c + 'a')), j - i + 1);
                        ans.put(replace_ct + String.valueOf(c + 'a'), value);
                    }
                }


                for (int i = 1; i < n; i++) {
                    int value = Math.max(ans.get(i + String.valueOf(c + 'a')), ans.get((i - 1) + String.valueOf(c + 'a')));
                    ans.put(i + String.valueOf(c + 'a'), value);
                }

            }


            final int q = in.nextInt();
            for (int i = 0; i < q; i++) {
                final int m = in.nextInt();
                final String c = in.nextToken();
                out.printLine(ans.get(m + c));
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

        public OutputWriter printLine(int i) {
            writer.println(i);
            return this;
        }

    }
}

