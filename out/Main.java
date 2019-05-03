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
        GNeobichnayaIgraNaMatrice solver = new GNeobichnayaIgraNaMatrice();
        solver.solve(1, in, out);
        out.close();
    }

    static class GNeobichnayaIgraNaMatrice {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            final int n = in.nextInt();
            final int m = in.nextInt();
            final int k = in.nextInt();
            final int[][] a = in.nextIntMatrix(n, m);
            int finalAnsSum = 0;
            int toRemove = 0;
            for (int j = 0; j < m; j++) {
                int minI = -1;
                for (int i = 0; i < n; i++) {
                    if (a[i][j] == 1) {
                        minI = i;
                        break;
                    }
                }
                if (minI == -1) continue;
                int curSum = 0;
                int maxSum = 0;
                int L = 0;
//            int R = 0;
                for (int i = minI; i < Math.min(n, minI + k); i++) {
                    curSum += a[i][j];
                }
                maxSum = curSum;
                L = minI;
//            R = Math.min(n, minI + k);
                for (int i = minI + k; i < n; i++) {
                    curSum += a[i][j];
                    curSum -= a[i - k][j];
                    if (maxSum < curSum) {
                        L = i - k + 1;
                        maxSum = curSum;
//                    R = i - k + 1;
                    }
                }
                for (int i = 0; i < L; i++) {
                    if (a[i][j] == 1) toRemove++;
                }
                finalAnsSum += maxSum;
            }
            out.print(finalAnsSum).space().printLine(toRemove);

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

        public int[][] nextIntMatrix(int rowCount, int columnCount) {
            int[][] table = new int[rowCount][];
            for (int i = 0; i < rowCount; i++) {
                table[i] = nextIntArray(columnCount);
            }
            return table;
        }

        public int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextInt();
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

