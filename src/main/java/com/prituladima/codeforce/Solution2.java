package com.prituladima.codeforce;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;


import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

/**
 * Don't confuse variables in inner cycles. Don't call variable like (i j k g). Delegate methods.
 * -Xmx64m maximum heap size allocation
 * 90% errors is copy-paste, wrong indexes and TOO MUCH variables
 */
public class Solution2 {

    private static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    private static final boolean MULTI_TEST = false;

    private static final int BITS = 31;
    private static final int MODULO = (int) 1e9 + 7;
    private static final int INF = (int) 1e7 + 7;

    private static final Random rand = new Random(1278367);

    private static final String yes = "YES", no = "NO";

    private static final int MAXN = 2 * (int) 10e4 + 10;

    private boolean[] used;// = new boolean[MAXN];

    private void solveAll() {
        int t = MULTI_TEST ? nextInt() : 1;
        while (t-- > 0) {
            solve();
        }
    }

    public static int log(int x) {
        return (int) (Math.log(x) / Math.log(2)) + 1;
    }

    private void solve() {


    }

    private String nextUUID() {
        return UUID.randomUUID().toString();
    }


    private boolean inRange(int val, int fromInclusive, int toExclusive) {
        return fromInclusive <= val && val < toExclusive;
    }

    private int nextRandInt(int minInclusive, int maxExclusive) {
        return rand.nextInt(maxExclusive - minInclusive) + minInclusive;
    }


    /**
     * Graph traverses
     */
    private void dfs(int from, boolean[] used, Graph graph) {
        used[from] = true;
        for (int to : graph.get(from)) {
            if (!used[to]) {
                dfs(to, used, graph);
            }
        }
    }

    private void dfsTree(int from, int parent, Tree tree) {
        for (int to : tree.get(from)) {
            if (parent != to) {
                dfsTree(to, from, tree);
            }
        }
    }

    /**
     * Binary searches.
     */
    private int upperBound(int inclusiveLeft, int exclusiveRight, Predicate<Integer> predicate) {
        while (exclusiveRight - inclusiveLeft > 1) {
            int middle = inclusiveLeft + (exclusiveRight - inclusiveLeft) / 2;
            if (predicate.test(middle)) {
                inclusiveLeft = middle;
            } else {
                exclusiveRight = middle;
            }
        }
        return inclusiveLeft;
    }

    private int lowerBound(int exclusiveLeft, int inclusiveRight, Predicate<Integer> predicate) {
        while (inclusiveRight - exclusiveLeft > 1) {
            int middle = exclusiveLeft + (inclusiveRight - exclusiveLeft) / 2;
            if (predicate.test(middle)) {
                inclusiveRight = middle;
            } else {
                exclusiveLeft = middle;
            }
        }
        return inclusiveRight;
    }

    private int minAns(int lev) {

        char[] tabs = new char[lev];
        Arrays.fill(tabs, '\t');
        debug(new StringBuilder().append(tabs).append(" ").append(lev));

        return 0;
    }

    public static void main(String[] args) {
        new Solution2().run();
    }

    private BufferedReader reader;
    private PrintWriter writer;
    private StringTokenizer tokenizer;

    private void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            this.writer = writer;
            this.reader = reader;
            solveAll();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Base types: Strings, int, long, double
     */
    private String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }


    /**
     * Primitives 1D arrays: char, int, long, double
     */
    private char[] nextCharArray() {
        return nextToken().toCharArray();
    }

    private int[] nextIntArray(int size) {
        return stream(new int[size]).map(c -> nextInt()).toArray();
    }

    private long[] nextLongArray(int size) {
        return stream(new long[size]).map(c -> nextLong()).toArray();
    }

    private double[] nextDoubleArray(int size) {
        return stream(new double[size]).map(c -> nextDouble()).toArray();
    }

    private String[] nextStringArray(int size) {
        return range(0, size).mapToObj(i -> nextToken()).toArray(String[]::new);
    }


    /**
     * Primitives 2D arrays: char, int, long, double
     */
    private char[][] nextCharMatrix(int n) {
        return range(0, n).mapToObj(i -> nextToken().toCharArray()).toArray(char[][]::new);
    }

    private int[][] nextIntMatrix(final int n, final int m) {
        return range(0, n).mapToObj(i -> nextIntArray(m)).toArray(int[][]::new);
    }

    private long[][] nextLongMatrix(final int n, final int m) {
        return range(0, n).mapToObj(i -> nextLongArray(m)).toArray(long[][]::new);
    }

    private double[][] nextDoubleMatrix(final int n, final int m) {
        return range(0, n).mapToObj(i -> nextDoubleArray(m)).toArray(double[][]::new);
    }

    /**
     * Graphs
     */
    private static class Graph extends HashMap<Integer, Collection<Integer>> {

    }

    private static class Tree extends Graph {

    }

    private Graph nextGraph(int amountOfVertexes, int amountOfEdges, boolean isDirected) {
        Graph graph = new Graph();
        for (int i = 1; i <= amountOfVertexes; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i = 1; i <= amountOfEdges; i++) {
            int from = nextInt();
            int to = nextInt();
            graph.get(from).add(to);
            if (!isDirected) {
                graph.get(to).add(from);
            }
        }
        return graph;
    }

    private Tree nextTree(int amountOfVertexes, boolean isDirected) {
        Tree tree = new Tree();
        for (int i = 1; i <= amountOfVertexes; i++) {
            tree.put(i, new HashSet<>());
        }
        for (int i = 1; i <= amountOfVertexes - 1; i++) {
            int from = nextInt();
            int to = nextInt();
            tree.get(from).add(to);
            if (!isDirected) {
                tree.get(to).add(from);
            }
        }
        return tree;
    }

    /**
     * Output
     */
    private void printf(String format, Object... args) {
        writer.printf(format, args);
    }

    private void print(Object o) {
        writer.print(o);
    }

    private void printSpace() {
        writer.print(' ');
    }

    private void println() {
        writer.println();
    }

    private void println(Object o) {
        writer.println(o);
    }

    private void flush() {
        writer.flush();
    }

    /**
     * Utils
     */

    private boolean isValidIndex(int ind, int n) {
        return 0 <= ind && ind < n;
    }

    private void printSeparator() {
        if (ONLINE_JUDGE) return;
        println("--------------Answer-----------------");
    }

    private void debug(Object o) {
        if (ONLINE_JUDGE) return;
        println(o);
    }

    private void debug(int[] array) {
        if (ONLINE_JUDGE) return;
        for (int i = 0; i < array.length; i++) {
            print(array[i]);
            print(' ');
        }
        println();
    }

    private void debug(int[][] matrix) {
        if (ONLINE_JUDGE) return;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                print(matrix[i][j]);
                print(' ');
            }
            println();
        }
    }


    private void debug(char[][] matrix) {
        if (ONLINE_JUDGE) return;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                print(matrix[i][j]);
                print(' ');
            }
            println();
        }
    }

    public static double maxn(double req, double... opt) {
        double max = req;
        for (double value : opt) max = Math.max(max, value);
        return max;
    }

    public static double minn(double req, double... opt) {
        double min = req;
        for (double value : opt) min = Math.min(min, value);
        return min;
    }

    public static double sumn(double... a) {
        return stream(a).sum();
    }

    public static int maxn(int req, int... opt) {
        int max = req;
        for (int value : opt) max = Math.max(max, value);
        return max;
    }

    public static int minn(int req, int... opt) {
        int min = req;
        for (int value : opt) min = Math.min(min, value);
        return min;
    }

    public static int sumn(int... a) {
        return stream(a).sum();
    }

    public static long maxn(long req, long... opt) {
        long max = req;
        for (long value : opt) max = Math.max(max, value);
        return max;
    }

    public static long minn(long req, long... opt) {
        long min = req;
        for (long value : opt) min = Math.min(min, value);
        return min;
    }

    public static long sumn(long... a) {
        return stream(a).sum();
    }

    public static void sort(long[] array) {
        shuffle(array);
        Arrays.sort(array);
    }

    public static void shuffle(long[] array) {
        Random random = new Random();
        for (int i = 0, j; i < array.length; i++) {
            j = i + random.nextInt(array.length - i);
            long buf = array[j];
            array[j] = array[i];
            array[i] = buf;
        }
    }

    public static void sort(int[] array) {
        shuffle(array);
        Arrays.sort(array);
    }

    public static void shuffle(int[] array) {
        Random random = new Random();
        for (int i = 0, j; i < array.length; i++) {
            j = i + random.nextInt(array.length - i);
            int buf = array[j];
            array[j] = array[i];
            array[i] = buf;
        }
    }

    public static Map<Double, Integer> multiSet(double[] arr) {
        Map<Double, Integer> multiSet = new HashMap<>();
        for (int i = 0; i < arr.length; i++) multiSet.put(arr[i], multiSet.getOrDefault(arr[i], 0) + 1);
        return multiSet;
    }

    public static Map<Integer, Integer> multiSet(int[] arr) {
        Map<Integer, Integer> multiSet = new HashMap<>();
        for (int i = 0; i < arr.length; i++) multiSet.put(arr[i], multiSet.getOrDefault(arr[i], 0) + 1);
        return multiSet;
    }

    public static Map<Long, Integer> multiSet(long[] arr) {
        Map<Long, Integer> multiSet = new HashMap<>();
        for (int i = 0; i < arr.length; i++) multiSet.put(arr[i], multiSet.getOrDefault(arr[i], 0) + 1);
        return multiSet;
    }

    public static int[] calculatePrefixSum(int[] a) {
        int[] pref = new int[a.length];
        pref[0] = a[0];
        for (int i = 1; i < a.length; i++) pref[i] = pref[i - 1] + a[i];
        return pref;
    }

    public static int[] calculateSuffixSum(int[] a) {
        int[] suff = new int[a.length];
        suff[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) suff[i] = suff[i + 1] + a[i];
        return suff;
    }

    public static long[] calculatePrefixSum(long[] a) {
        long[] pref = new long[a.length];
        pref[0] = a[0];
        for (int i = 1; i < a.length; i++) pref[i] = pref[i - 1] + a[i];
        return pref;
    }

    public static long[] calculateSuffixSum(long[] a) {
        long[] suff = new long[a.length];
        suff[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) suff[i] = suff[i + 1] + a[i];
        return suff;
    }

    /**
     * Data-structures
     * todo Binary lifting
     * todo HL decomposition
     * todo RMQ
     */

    private class BinaryIndexedTree {
        private final long[] value;

        public BinaryIndexedTree(int size) {
            value = new long[size];
        }

        public long get(int from, int to) {
            if (from > to) {
                return 0;
            }
            return get(to) - get(from - 1);
        }

        private long get(int to) {
            long result = 0;
            while (to >= 0) {
                result += value[to];
                to = (to & (to + 1)) - 1;
            }
            return result;
        }

        public void add(int at, long value) {
            while (at < this.value.length) {
                this.value[at] += value;
                at = at | (at + 1);
            }
        }
    }

    private class DisjointUnionSets {

        private int[] rank, parent;
        private int amount;

        public DisjointUnionSets(int amount) {
            this.rank = new int[amount];
            this.parent = new int[amount];
            this.amount = amount;
            for (int i = 0; i < amount; i++) {
                parent[i] = i;
            }
        }

        public boolean isInSameSet(int u, int v) {
            return find(u) == find(v);
        }

        private int find(int v) {
            if (v == parent[v])
                return v;
            return parent[v] = find(parent[v]);
        }

        public void union(int x, int y) {
            // Find representatives of two sets
            int xRoot = find(x), yRoot = find(y);

            // Elements are in the same set, no need
            // to unite anything.
            if (xRoot == yRoot)
                return;

            // If x's rank is less than y's rank
            if (rank[xRoot] < rank[yRoot])

                // Then move x under y so that depth
                // of tree remains less
                parent[xRoot] = yRoot;

                // Else if y's rank is less than x's rank
            else if (rank[xRoot] > rank[yRoot])

                // Then move y under x so that depth of
                // tree remains less
                parent[yRoot] = xRoot;

            else // if ranks are the same
            {
                // Then move y under x (doesn't matter
                // which one goes where)
                parent[yRoot] = xRoot;

                // And increment the the result tree's
                // rank by 1
                rank[xRoot]++;
            }
            amount--;
        }

        public int getAmount() {
            return amount;
        }
    }

    private class GCDIterativeSegmentTree {
        //    int N = (int) 1e5 + 10;  // limit for array size
        int n;  // array size
        int[] t;

        public GCDIterativeSegmentTree(int n) {
            this.n = n;
            this.t = new int[2 * n];
        }

        public void build() {  // build the tree
            for (int i = n - 1; i > 0; --i) t[i] = gcd(t[i << 1], t[i << 1 | 1]);
        }

        public void modify(int p, int value) {  // set value at position p
            for (t[p += n] = value; p > 1; p >>= 1) t[p >> 1] = gcd(t[p], t[p ^ 1]);
        }

        public int query(int l, int r) {  // sum on interval [l, r)
            int res = 0;
            for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
                if ((l & 1) == 1) res = gcd(res, t[l++]);
                if ((r & 1) == 1) res = gcd(res, t[--r]);
            }
            return res;
        }

        public int gcd(int a, int b) {
            a = Math.abs(a);
            b = Math.abs(b);
            while (b != 0) {
                int temp = a % b;
                a = b;
                b = temp;
            }
            return a;
        }
    }

    /**
     * Bits
     */
    private boolean contains(int set, int bit) {
        return (set & (1 << bit)) > 0;
    }

    private int add(int set, int bit) {
        return bit | (1 << bit);
    }

    private int remove(int set, int bit) {
        return set & ~(1 << bit);
    }

    private int toggle(int set, int bit) {
        return set ^ (1 << bit);
    }


    /**
     * Math
     */
    private long powMod(long base, long exp, long mod) {
        long ans = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                ans *= base;
                ans %= mod;
            }
            base *= base;
            base %= mod;
            exp >>= 1;
        }
        return ans;
    }

    private long modularMultiplicativeInverse(long a, long mod) {
        return powMod(a, mod - 2, mod);
    }
}