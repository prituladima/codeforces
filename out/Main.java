import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.function.BiFunction;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.function.BinaryOperator;
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
        CPryamougolniki solver = new CPryamougolniki();
        solver.solve(1, in, out);
        out.close();
    }

    static class CPryamougolniki {
        int n;

        public void solve(int testNumber, InputReader in, OutputWriter out) {

            n = in.nextInt();
            if (n == 2) {
                out.printLine(in.nextInt() + " " + in.nextInt());
                return;
            }

            List<RectangleUtil.Rect> list = in.nextRectangleArray(n);

            List<RectangleUtil.Rect> pref = GreedyUtil.calculatePrefix(list, RectangleUtil::intersection);
            List<RectangleUtil.Rect> suff = GreedyUtil.calculateSuffix(list, RectangleUtil::intersection);

            if (pref.get(n - 1) == null && pref.get(n - 2) != null) {
                out.printLine(pref.get(n - 2).x1 + " " + pref.get(n - 2).y1);
                return;
            }

            if (suff.get(0) == null && suff.get(1) != null) {
                out.printLine(suff.get(1).x1 + " " + suff.get(1).y1);
                return;
            }

            for (int i = 1; i < n - 1; i++) {
                RectangleUtil.Rect res = RectangleUtil.intersection(pref.get(i - 1), suff.get(i + 1));
                if (res != null) {
                    out.printLine(res.x1 + " " + res.y1);
                    return;
                }
            }


            if (pref.get(n - 1) != null) {
                out.printLine(pref.get(n - 1).x1 + " " + pref.get(n - 1).y1);
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

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }

    static class RectangleUtil {
        public static RectangleUtil.Rect intersection(RectangleUtil.Rect a, RectangleUtil.Rect b) {
            if (a == null || b == null) {
                return null;
            }

            int x5 = Integer.max(a.x1, b.x1);
            int y5 = Integer.max(a.y1, b.y1);

            int x6 = Math.min(a.x2, b.x2);
            int y6 = Math.min(a.y2, b.y2);

            if (x5 > x6 || y5 > y6) {
                return null;
            }

            return new RectangleUtil.Rect(x5, y5, x6, y6);
        }

        public static class Rect {
            public int x1;
            public int y1;
            public int x2;
            public int y2;

            public Rect(int x1, int y1, int x2, int y2) {
                this.x1 = x1;
                this.y1 = y1;
                this.x2 = x2;
                this.y2 = y2;
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

        private boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        private static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public List<RectangleUtil.Rect> nextRectangleArray(int n) {
            List<RectangleUtil.Rect> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new RectangleUtil.Rect(nextInt(), nextInt(), nextInt(), nextInt()));
            }
            return list;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class GreedyUtil {
        public static <T> List<T> calculatePrefix(List<T> init, BinaryOperator<T> operator) {
            List<T> pref = new ArrayList<>(init);
            for (int i = 1; i < init.size(); i++) {
                pref.set(i, operator.apply(pref.get(i - 1), pref.get(i)));
            }
            return pref;
        }

        public static <T> List<T> calculateSuffix(List<T> init, BinaryOperator<T> operator) {
            List<T> suff = new ArrayList<>(init);
            for (int i = init.size() - 2; i >= 0; i--) {
                suff.set(i, operator.apply(suff.get(i + 1), suff.get(i)));
            }
            return suff;
        }

    }
}

