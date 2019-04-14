import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.Collection;
import java.util.Set;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
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
        NSortirovkaPodposledovatelnostyami solver = new NSortirovkaPodposledovatelnostyami();
        solver.solve(1, in, out);
        out.close();
    }

    static class NSortirovkaPodposledovatelnostyami {
        int n;
        int[] a;
        int[] b;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        boolean[] used;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.nextInt();
            a = in.nextIntArray(n);
            b = a.clone();
            used = new boolean[n + 20];
            Arrays.sort(b);

            Map<Integer, Integer> ValueToInd = new HashMap<>();
            for (int i = 0; i < n; i++) {
                ValueToInd.put(b[i], i);
            }

            for (int i = 0; i < n; i++) {
                int j = ValueToInd.get(a[i]);
                graph.computeIfAbsent(i + 1, key -> new HashSet<>());
                graph.computeIfAbsent(j + 1, key -> new HashSet<>());
                graph.get(j + 1).add(i + 1);
                graph.get(i + 1).add(j + 1);
            }

            ArrayList<Set<Integer>> res = new ArrayList<>();
            for (int from = 1; from <= n; from++) {
                if (!used[from]) {
                    Set<Integer> curRes = new HashSet<>();
                    dfs(from, curRes);
                    res.add(curRes);
                }
            }

            int size = res.size();
            out.printLine(size);
            for (Set<Integer> re : res) {
                out.print(re.size()).space().printListInOneLine(re).printLine();
            }
        }

        private void dfs(int from, Set<Integer> compMember) {
            compMember.add(from);
            used[from] = true;
            for (int to : graph.getOrDefault(from, new HashSet<>())) {
                if (!used[to]) dfs(to, compMember);
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

        public OutputWriter print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
            return this;
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

        public OutputWriter printListInOneLine(Collection<?> answer) {
            for (Object o : answer) this.print(o).space();
            return this;
        }

    }
}

