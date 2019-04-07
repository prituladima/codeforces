import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.Set;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.HashSet;
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
        DSoedinit solver = new DSoedinit();
        solver.solve(1, in, out);
        out.close();
    }

    static class DSoedinit {
        int INF = Integer.MAX_VALUE;
        int n;
        int[][] M;
        char[] chars;
        int r1;
        int c1;
        int r2;
        int c2;
        boolean[] used;
        Map<Integer, Set<Integer>> graph;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.nextInt();

            r1 = in.nextInt() - 1;
            c1 = in.nextInt() - 1;
            r2 = in.nextInt() - 1;
            c2 = in.nextInt() - 1;

            M = new int[n][n];
            for (int i = 0; i < n; i++) {
                chars = in.nextToken().toCharArray();
                for (int j = 0; j < n; j++) {
                    M[i][j] = chars[j] == '1' ? 1 : 0;
                }
            }
//        M = in.nextIntMatrix(n, n);


            used = new boolean[50 * 100];
            graph = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph.computeIfAbsent(i * 50 + j, (ignore) -> new HashSet<Integer>());
                    if (M[i][j] == 0) {
                        if (i > 0 && M[i - 1][j] == 0) {
                            graph.get(i * 50 + j).add((i - 1) * 50 + j);
                        }
                        if (i < n - 1 && M[i + 1][j] == 0) {
                            graph.get(i * 50 + j).add((i + 1) * 50 + j);
                        }
                        if (j > 0 && M[i][j - 1] == 0) {
                            graph.get(i * 50 + j).add(i * 50 + j - 1);
                        }
                        if (j < n - 1 && M[i][j + 1] == 0) {
                            graph.get(i * 50 + j).add(i * 50 + j + 1);
                        }
                    }
                }
            }

            dfs(r1 * 50 + c1);

            if (used[r2 * 50 + c2]) {
                out.printLine(0);
            } else {
                Set<IntIntPair> fistCom = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (used[i * 50 + j]) {
                            fistCom.add(IntIntPair.makePair(i, j));
                        }
                    }
                }

                Arrays.fill(used, false);

                dfs(r2 * 50 + c2);

                Set<IntIntPair> secCom = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (used[i * 50 + j]) {
                            secCom.add(IntIntPair.makePair(i, j));
                        }
                    }
                }

                int min = INF;
                for (IntIntPair from : secCom) {
                    for (IntIntPair to : fistCom) {
                        min = Math.min(min, (from.first - to.first) * (from.first - to.first) + (from.second - to.second) * (from.second - to.second));
                    }
                }
                out.printLine(min);
            }
        }

        private void dfs(int from) {
            used[from] = true;
            for (int to : graph.get(from)) if (!used[to]) dfs(to);
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

    static class IntIntPair implements Comparable<IntIntPair> {
        public final int first;
        public final int second;

        public static IntIntPair makePair(int first, int second) {
            return new IntIntPair(first, second);
        }

        public IntIntPair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            IntIntPair pair = (IntIntPair) o;

            return first == pair.first && second == pair.second;
        }

        public int hashCode() {
            int result = first;
            result = 31 * result + second;
            return result;
        }

        public String toString() {
            return "(" + first + "," + second + ")";
        }

        public int compareTo(IntIntPair o) {
            int value = Integer.compare(first, o.first);
            if (value != 0) {
                return value;
            }
            return Integer.compare(second, o.second);
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

