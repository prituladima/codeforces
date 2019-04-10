package com.prituladima.yaal.io;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.generated.collections.pair.LongLongPair;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.*;

import static com.prituladima.yaal.geometry.RectangleUtil.Rect;

public class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public double[] nextDoubleArray(int size) {
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = readDouble();
        }
        return array;
    }

    public String[] nextStringArray(int size) {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = nextToken();
        }
        return array;
    }

    public char[] nextCharArray(int size) {
        char[] array = new char[size];
        for (int i = 0; i < size; i++) {
            array[i] = readCharacter();
        }
        return array;
    }

    public IntIntPair[] nextIntPairArray(int size) {
        IntIntPair[] result = new IntIntPair[size];
        for (int i = 0; i < size; i++) {
            result[i] = nextIntPair();
        }
        return result;
    }

    public LongLongPair[] nextLongPairArray(int size) {
        LongLongPair[] result = new LongLongPair[size];
        for (int i = 0; i < size; i++) {
            result[i] = nextLongPair();
        }
        return result;
    }

    public void readIntArrays(int[]... arrays) {
        for (int i = 0; i < arrays[0].length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                arrays[j][i] = nextInt();
            }
        }
    }

    public void readLongArrays(long[]... arrays) {
        for (int i = 0; i < arrays[0].length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                arrays[j][i] = nextLong();
            }
        }
    }

    public void readDoubleArrays(double[]... arrays) {
        for (int i = 0; i < arrays[0].length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                arrays[j][i] = readDouble();
            }
        }
    }

    public char[][] nextCharMatrix(int rowCount, int columnCount) {
        char[][] table = new char[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            table[i] = this.nextCharArray(columnCount);
        }
        return table;
    }

    public int[][] nextIntMatrix(int rowCount, int columnCount) {
        int[][] table = new int[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            table[i] = nextIntArray(columnCount);
        }
        return table;
    }

    public double[][] nextDoubleMatrix(int rowCount, int columnCount) {
        double[][] table = new double[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            table[i] = this.nextDoubleArray(columnCount);
        }
        return table;
    }

    public long[][] nextLongMatrix(int rowCount, int columnCount) {
        long[][] table = new long[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            table[i] = nextLongArray(columnCount);
        }
        return table;
    }

    public String[][] nextStringMatrix(int rowCount, int columnCount) {
        String[][] table = new String[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            table[i] = this.nextStringArray(columnCount);
        }
        return table;
    }

    private String getAll() {
        StringBuilder result = new StringBuilder();
        while (true) {
            int character = read();
            if (character == '\r') {
                continue;
            }
            if (character == -1) {
                break;
            }
            result.append((char) character);
        }
        return result.toString();
    }

    public void nextStringArray(String[]... arrays) {
        for (int i = 0; i < arrays[0].length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                arrays[j][i] = nextToken();
            }
        }
    }

    public long[] nextLongArray(int size) {
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = nextLong();
        }
        return array;
    }

    public int[] nextIntArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    public LongLongPair nextLongPair() {
        long first = nextLong();
        long second = nextLong();
        return new LongLongPair(first, second);
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

    public int peek() {
        if (numChars == -1) {
            return -1;
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                return -1;
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar];
    }

    public int peekNonWhitespace() {
        while (isWhitespace(peek())) {
            read();
        }
        return peek();
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

    public long nextLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
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

    private String readLine0() {
        StringBuilder buf = new StringBuilder();
        int c = read();
        while (c != '\n' && c != -1) {
            if (c != '\r') {
                buf.appendCodePoint(c);
            }
            c = read();
        }
        return buf.toString();
    }

    private String readLine() {
        String s = readLine0();
        while (s.trim().length() == 0) {
            s = readLine0();
        }
        return s;
    }

    public String readLine(boolean ignoreEmptyLines) {
        if (ignoreEmptyLines) {
            return readLine();
        } else {
            return readLine0();
        }
    }

    public BigInteger readBigInteger() {
        try {
            return new BigInteger(nextToken());
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }

    public char readCharacter() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        return (char) c;
    }

    public double readDouble() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E') {
                return res * Math.pow(10, nextInt());
            }
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }

    public boolean isExhausted() {
        int value;
        while (isSpaceChar(value = peek()) && value != -1) {
            read();
        }
        return value == -1;
    }

    public String next() {
        return nextToken();
    }

    public SpaceCharFilter getFilter() {
        return filter;
    }

    public void setFilter(SpaceCharFilter filter) {
        this.filter = filter;
    }

    public List<Rect> nextRectangleArray(int n) {
        List<Rect> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Rect(nextInt(), nextInt(), nextInt(), nextInt()));
        }
        return list;
    }

    public Map<Integer, Set<Integer>> readTree(int n) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int from = this.nextInt();
            int to = this.nextInt();
            graph.computeIfAbsent(from, (key) -> new HashSet<>());
            graph.computeIfAbsent(to, (key) -> new HashSet<>());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        return graph;
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}
