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
        DNastyaIdetVStolovuyu solver = new DNastyaIdetVStolovuyu();
        solver.solve(1, in, out);
        out.close();
    }

    static class DNastyaIdetVStolovuyu {
        int n;
        int m;
        int[] array;
        IntIntPair[] pairs;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            array = in.nextIntArray(n);
            int last = array[array.length - 1];
            pairs = in.nextIntPairArray(m);
            Set<IntIntPair> pairsSet = new HashSet<>(Arrays.asList(pairs));
            Map<Integer, Set<Integer>> optimized = new HashMap<>();
            for (IntIntPair intIntPair : pairsSet) {
                int first = intIntPair.getFirst();
                int second = intIntPair.getSecond();
                optimized.computeIfAbsent(first, k -> new HashSet<>());
                optimized.get(first).add(second);
            }

            Set<Integer> P = new HashSet<>();
            for (int i = array.length - 2; i >= 0; i--) {
                boolean acceptAll = true;
                Set<Integer> opt = optimized.get(array[i]);
                if (opt != null) {
                    for (Integer j : P) {
                        acceptAll &= opt.contains(j);
                        if (!acceptAll) break;
                    }
                    acceptAll &= opt.contains(last);
                }
                if (!acceptAll || opt == null) P.add(array[i]);
            }
            out.printLine(n - 1 - P.size());
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

        public void printLine(int i) {
            writer.println(i);
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

        public IntIntPair[] nextIntPairArray(int size) {
            IntIntPair[] result = new IntIntPair[size];
            for (int i = 0; i < size; i++) {
                result[i] = nextIntPair();
            }
            return result;
        }

        public int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        public IntIntPair nextIntPair() {
            int first = nextInt();
            int second = nextInt();
            return new IntIntPair(first, second);
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

    static class IntIntPair implements Comparable<IntIntPair> {
        public final int first;
        public final int second;

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
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
}

