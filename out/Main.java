import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.io.Writer;
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
        CProstiePrefiksnieSummi solver = new CProstiePrefiksnieSummi();
        solver.solve(1, in, out);
        out.close();
    }

    static class CProstiePrefiksnieSummi {
        int n;
        int[] a;
        int ones = 0;
        int twos = 0;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.nextInt();
            a = in.nextIntArray(n);

            for (int i = 0; i < n; i++) {
                if (a[i] == 1) ones++;
                else twos++;
            }


            if (n == 1) {
                out.printLine(a[0]);
            } else if (twos == 0) {
                for (int i = 0; i < n; i++) {
                    out.print(a[i]).space();
                }
                out.printLine();

            } else if (ones == 0) {
                for (int i = 0; i < n; i++) {
                    out.print(a[i]).space();
                }
                out.printLine();
            } else {

                final int[] primes = IntegerUtils.generatePrimes(15_000_010);

                List<Integer> diff = new ArrayList<>();
                diff.add(2);
                for (int i = 0; i < primes.length - 1; i++) {
                    diff.add(primes[i + 1] - primes[i]);
                }

                List<Integer> res = new ArrayList<>();
                int need = 0;
                for (final Integer val : diff) {
                    final List<Integer> cover = get12(val + need);
                    if (cover.size() == 0) {
                        need += val;
                        break;
                    } else {
                        res.addAll(cover);
                        need = 0;
                    }
                    if (ones == 0 && twos == 0) break;
                }

                if (ones == 0 || twos == 0) {
                    int local2 = twos;
                    int local1 = ones;
                    for (int i = 0; i < local2; i++) {
                        res.add(2);
                        twos--;
                    }
                    for (int i = 0; i < local1; i++) {
                        res.add(1);
                        ones--;
                    }
                }
                for (Integer re : res) {
                    out.print(re).space();
                }
                out.printLine();
            }
        }

        private List<Integer> get12(int diff) {
            List<Integer> res = new ArrayList<>();
            if (diff == 2) {
                if (twos > 0) {
                    res.add(2);
                    twos--;
                } else if (ones > 1) {
                    res.add(1);
                    res.add(1);
                    ones -= 2;
                } else {
                    res.add(1);
                    ones--;
                }
            } else if (diff == 1) {
                if (ones > 0) {
                    res.add(1);
                    ones--;
                }
            } else {
                if (2 * twos >= diff) {
                    for (int i = 0; i < diff / 2; i++) {
                        res.add(2);
                        twos--;
                    }
                } else if (ones + 2 * twos >= diff) {
                    int local2 = twos;
                    int local1 = ones;
                    for (int i = 0; i < local2; i++) {
                        res.add(2);
                        twos--;
                    }
                    for (int i = 0; i < diff - 2 * local2; i++) {
                        res.add(1);
                        ones--;
                    }

                } else {
                    int local2 = twos;
                    int local1 = ones;
                    for (int i = 0; i < local2; i++) {
                        res.add(2);
                        twos--;
                    }
                    for (int i = 0; i < local1; i++) {
                        res.add(1);
                        ones--;
                    }
                }
            }
            return res;
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

    static interface IntStream extends Iterable<Integer>, Comparable<IntStream> {
        public IntIterator intIterator();

        default public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                private IntIterator it = intIterator();

                public boolean hasNext() {
                    return it.isValid();
                }

                public Integer next() {
                    int result = it.value();
                    it.advance();
                    return result;
                }
            };
        }

        default public int compareTo(IntStream c) {
            IntIterator it = intIterator();
            IntIterator jt = c.intIterator();
            while (it.isValid() && jt.isValid()) {
                int i = it.value();
                int j = jt.value();
                if (i < j) {
                    return -1;
                } else if (i > j) {
                    return 1;
                }
                it.advance();
                jt.advance();
            }
            if (it.isValid()) {
                return 1;
            }
            if (jt.isValid()) {
                return -1;
            }
            return 0;
        }

    }

    static interface IntList extends IntReversableCollection {
        public abstract int get(int index);

        public abstract void addAt(int index, int value);

        public abstract void removeAt(int index);

        default public IntIterator intIterator() {
            return new IntIterator() {
                private int at;
                private boolean removed;

                public int value() {
                    if (removed) {
                        throw new IllegalStateException();
                    }
                    return get(at);
                }

                public boolean advance() {
                    at++;
                    removed = false;
                    return isValid();
                }

                public boolean isValid() {
                    return !removed && at < size();
                }

                public void remove() {
                    removeAt(at);
                    at--;
                    removed = true;
                }
            };
        }

        default public void add(int value) {
            addAt(size(), value);
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

    static interface IntIterator {
        public int value() throws NoSuchElementException;

        public boolean advance();

        public boolean isValid();

    }

    static class IntArrayList extends IntAbstractStream implements IntList {
        private int size;
        private int[] data;

        public IntArrayList() {
            this(3);
        }

        public IntArrayList(int capacity) {
            data = new int[capacity];
        }

        public IntArrayList(IntCollection c) {
            this(c.size());
            addAll(c);
        }

        public IntArrayList(IntStream c) {
            this();
            if (c instanceof IntCollection) {
                ensureCapacity(((IntCollection) c).size());
            }
            addAll(c);
        }

        public IntArrayList(IntArrayList c) {
            size = c.size();
            data = c.data.clone();
        }

        public IntArrayList(int[] arr) {
            size = arr.length;
            data = arr.clone();
        }

        public int size() {
            return size;
        }

        public int get(int at) {
            if (at >= size) {
                throw new IndexOutOfBoundsException("at = " + at + ", size = " + size);
            }
            return data[at];
        }

        private void ensureCapacity(int capacity) {
            if (data.length >= capacity) {
                return;
            }
            capacity = Math.max(2 * data.length, capacity);
            data = Arrays.copyOf(data, capacity);
        }

        public void addAt(int index, int value) {
            ensureCapacity(size + 1);
            if (index > size || index < 0) {
                throw new IndexOutOfBoundsException("at = " + index + ", size = " + size);
            }
            if (index != size) {
                System.arraycopy(data, index, data, index + 1, size - index);
            }
            data[index] = value;
            size++;
        }

        public void removeAt(int index) {
            if (index >= size || index < 0) {
                throw new IndexOutOfBoundsException("at = " + index + ", size = " + size);
            }
            if (index != size - 1) {
                System.arraycopy(data, index + 1, data, index, size - index - 1);
            }
            size--;
        }

        public int[] toArray() {
            return Arrays.copyOf(data, size);
        }

    }

    static interface IntCollection extends IntStream {
        public int size();

        default public void add(int value) {
            throw new UnsupportedOperationException();
        }

        default public int[] toArray() {
            int size = size();
            int[] array = new int[size];
            int i = 0;
            for (IntIterator it = intIterator(); it.isValid(); it.advance()) {
                array[i++] = it.value();
            }
            return array;
        }

        default public IntCollection addAll(IntStream values) {
            for (IntIterator it = values.intIterator(); it.isValid(); it.advance()) {
                add(it.value());
            }
            return this;
        }

    }

    static interface IntReversableCollection extends IntCollection {
    }

    static class IntegerUtils {
        public static int[] generatePrimes(int upTo) {
            int[] isPrime = generateBitPrimalityTable(upTo);
            IntList primes = new IntArrayList();
            for (int i = 0; i < upTo; i++) {
                if ((isPrime[i >> 5] >>> (i & 31) & 1) == 1) {
                    primes.add(i);
                }
            }
            return primes.toArray();
        }

        public static int[] generateBitPrimalityTable(int upTo) {
            int[] isPrime = new int[(upTo + 31) >> 5];
            if (upTo < 2) {
                return isPrime;
            }
            Arrays.fill(isPrime, -1);
            isPrime[0] &= -4;
            for (int i = 2; i * i < upTo; i++) {
                if ((isPrime[i >> 5] >>> (i & 31) & 1) == 1) {
                    for (int j = i * i; j < upTo; j += i) {
                        isPrime[j >> 5] &= -1 - (1 << (j & 31));
                    }
                }
            }
            return isPrime;
        }

    }

    static abstract class IntAbstractStream implements IntStream {
        public String toString() {
            StringBuilder builder = new StringBuilder();
            boolean first = true;
            for (IntIterator it = intIterator(); it.isValid(); it.advance()) {
                if (first) {
                    first = false;
                } else {
                    builder.append(' ');
                }
                builder.append(it.value());
            }
            return builder.toString();
        }

        public boolean equals(Object o) {
            if (!(o instanceof IntStream)) {
                return false;
            }
            IntStream c = (IntStream) o;
            IntIterator it = intIterator();
            IntIterator jt = c.intIterator();
            while (it.isValid() && jt.isValid()) {
                if (it.value() != jt.value()) {
                    return false;
                }
                it.advance();
                jt.advance();
            }
            return !it.isValid() && !jt.isValid();
        }

        public int hashCode() {
            int result = 0;
            for (IntIterator it = intIterator(); it.isValid(); it.advance()) {
                result *= 31;
                result += it.value();
            }
            return result;
        }

    }
}

