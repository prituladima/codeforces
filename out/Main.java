import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.Set;
import java.util.InputMismatchException;
import java.util.HashMap;
import java.io.IOException;
import java.util.Random;
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
        DMentori solver = new DMentori();
        solver.solve(1, in, out);
        out.close();
    }

    static class DMentori {
        int n;
        int m;
        int[] a;
        int[] b;
        IntIntPair[] pairs;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.nextInt();
            m = in.nextInt();

            a = in.nextIntArray(n);
            final Map<Integer, Set<Integer>> integerSetMap = IntegerUtils.valueToIndexSet(a);
            b = a.clone();
            GeekInteger.save_sort(a);
            pairs = in.nextIntPairArray(m);
            int[] res = new int[n];
            Set<Integer> used = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int ind = theMostRightLess(a, i - 1, a[i]);
                int localAns = ind + 1;
                if (!used.contains(a[i])) {
                    final Set<Integer> indexes = integerSetMap.get(a[i]);
                    for (int index : indexes) {
                        res[index] = localAns;
                    }
                    used.add(a[i]);
                }
            }

            for (IntIntPair pair : pairs) {
                final int x = pair.first;
                final int y = pair.second;
                if (b[x - 1] > b[y - 1]) {
                    res[x - 1]--;
                } else if (b[x - 1] < b[y - 1]) {
                    res[y - 1]--;
                }
            }

            out.printLine(res);

        }

        private int theMostRightLess(int[] a, int last, int value) {
            int start = 0;
            int finish = last;
            int res = -1;
            while (start <= finish) {
                int middle = (start + finish) >> 1;
                if (a[middle] < value) {
                    res = middle;
                    start = middle + 1;
                } else {
                    finish = middle - 1;
                }
            }
            return res;
        }

    }

    static interface Reliable {
    }

    static class GeekInteger {
        public static void save_sort(int[] array) {
            shuffle(array);
            Arrays.sort(array);
        }

        public static int[] shuffle(int[] array) {
            int n = array.length;
            Random random = new Random();
            for (int i = 0, j; i < n; i++) {
                j = i + random.nextInt(n - i);
                int randomElement = array[j];
                array[j] = array[i];
                array[i] = randomElement;
            }
            return array;
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

        public OutputWriter print(int[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
            return this;
        }

        public OutputWriter printLine(int[] array) {
            print(array);
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

    static class IntegerUtils {
        public static Map<Integer, Set<Integer>> valueToIndexSet(int[] a) {
            Map<Integer, Set<Integer>> res = new HashMap<>();
            for (int i = 0; i < a.length; i++) {
                res.computeIfAbsent(a[i], key -> new HashSet<>());
                res.get(a[i]).add(i);
            }
            return res;
        }

    }
}

