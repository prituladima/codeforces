package util;

import java.io.*;
import java.util.*;

/**
 * Created by prituladima on 5/27/18.
 */
public class Pre2 {


    public static final boolean DEBUG_PRINTS = false;

    public static void main(String[] args) {
        Solver solver = new Solver();
    }

    static class Solver {
        IO io;

        public Solver() {
            this.io = new IO();
            try {
                solve();
            } catch (RuntimeException e) {
                if (!e.getMessage().equals("Clean exit")) {
                    throw e;
                }
            } finally {
                io.close();
            }
        }

        /****************************** START READING HERE ********************************/

        void solve() {
            int n = io.nextInt();
            int max_d = io.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = io.nextInt();
            }
            Arrays.sort(a);

            int min_to_remove = 100;
            for (int end = n - 1; end >= 0; end--) {
                for (int start = 0; start <= end; start++) {
                    int d = a[end] - a[start];
                    if (d <= max_d) {
                        int to_remove = start + (n - 1 - end);
                        min_to_remove = Math.min(min_to_remove, to_remove);
                    }
                }
            }

            io.println(min_to_remove);
        }

        /************************** UTILITY CODE BELOW THIS LINE **************************/

        long MOD = (long) 1e9 + 7;

        List<Integer>[] toGraph(IO io, int n) {
            List<Integer>[] g = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
            for (int i = 1; i <= n - 1; i++) {
                int a = io.nextInt();
                int b = io.nextInt();
                g[a].add(b);
                g[b].add(a);
            }
            return g;
        }

        class Point {
            int y;
            int x;

            public Point(int y, int x) {
                this.y = y;
                this.x = x;
            }
        }

        class IDval implements Comparable<IDval> {
            int id;
            long val;

            public IDval(int id, long val) {
                this.val = val;
                this.id = id;
            }

            @Override
            public int compareTo(IDval o) {
                if (this.val < o.val) return -1;
                if (this.val > o.val) return 1;
                return this.id - o.id;
            }
        }

        long pow(long base, int exp) {
            if (exp == 0) return 1L;
            long x = pow(base, exp / 2);
            long ans = x * x;
            if (exp % 2 != 0) ans *= base;
            return ans;
        }

        long gcd(long... v) {
            /** Chained calls to Euclidean algorithm. */
            if (v.length == 1) return v[0];
            long ans = gcd(v[1], v[0]);
            for (int i = 2; i < v.length; i++) {
                ans = gcd(ans, v[i]);
            }
            return ans;
        }

        long gcd(long a, long b) {
            /** Euclidean algorithm. */
            if (b == 0) return a;
            return gcd(b, a % b);
        }

        int[] generatePrimesUpTo(int last) {
            /* Sieve of Eratosthenes. Practically O(n). Values of 0 indicate primes. */
            int[] div = new int[last + 1];
            for (int x = 2; x <= last; x++) {
                if (div[x] > 0) continue;
                for (int u = 2 * x; u <= last; u += x) {
                    div[u] = x;
                }
            }
            return div;
        }

        long lcm(long a, long b) {
            /** Least common multiple */
            return a * b / gcd(a, b);
        }

        private class ElementCounter {
            private HashMap<Long, Integer> elements;

            public ElementCounter() {
                elements = new HashMap<>();
            }

            public void add(long element) {
                int count = 1;
                if (elements.containsKey(element)) count += elements.get(element);
                elements.put(element, count);
            }

            public void remove(long element) {
                int count = elements.get(element);
                count--;
                if (count == 0) elements.remove(element);
                else elements.put(element, count);
            }

            public int get(long element) {
                if (!elements.containsKey(element)) return 0;
                return elements.get(element);
            }

            public int size() {
                return elements.size();
            }
        }

        class StringCounter {
            HashMap<String, Long> elements;

            public StringCounter() {
                elements = new HashMap<>();
            }

            public void add(String identifier) {
                long count = 1;
                if (elements.containsKey(identifier)) count += elements.get(identifier);
                elements.put(identifier, count);
            }

            public void remove(String identifier) {
                long count = elements.get(identifier);
                count--;
                if (count == 0) elements.remove(identifier);
                else elements.put(identifier, count);
            }

            public long get(String identifier) {
                if (!elements.containsKey(identifier)) return 0;
                return elements.get(identifier);
            }

            public int size() {
                return elements.size();
            }
        }

        class DisjointSet {
            /**
             * Union Find / Disjoint Set data structure.
             */
            int[] size;
            int[] parent;
            int componentCount;

            public DisjointSet(int n) {
                componentCount = n;
                size = new int[n];
                parent = new int[n];
                for (int i = 0; i < n; i++) parent[i] = i;
                for (int i = 0; i < n; i++) size[i] = 1;
            }

            public void join(int a, int b) {
                /* Find roots */
                int rootA = parent[a];
                int rootB = parent[b];
                while (rootA != parent[rootA]) rootA = parent[rootA];
                while (rootB != parent[rootB]) rootB = parent[rootB];

                if (rootA == rootB) {
                    /* Already in the same set */
                    return;
                }

                /* Merge smaller set into larger set. */
                if (size[rootA] > size[rootB]) {
                    size[rootA] += size[rootB];
                    parent[rootB] = rootA;
                } else {
                    size[rootB] += size[rootA];
                    parent[rootA] = rootB;
                }
                componentCount--;
            }

        }

        class LCAFinder {

            /* O(n log n) Initialize: new LCAFinder(graph)
             * O(log n) Queries: find(a,b) returns lowest common ancestor for nodes a and b */

            int[] nodes;
            int[] depths;
            int[] entries;
            int pointer;
            FenwickMin fenwick;

            public LCAFinder(List<Integer>[] graph) {
                this.nodes = new int[(int) 10e6];
                this.depths = new int[(int) 10e6];
                this.entries = new int[graph.length];
                this.pointer = 1;
                boolean[] visited = new boolean[graph.length + 1];
                dfs(1, 0, graph, visited);
                fenwick = new FenwickMin(pointer - 1);
                for (int i = 1; i < pointer; i++) {
                    fenwick.set(i, depths[i] * 1000000L + i);
                }
            }

            private void dfs(int node, int depth, List<Integer>[] graph, boolean[] visited) {
                visited[node] = true;
                entries[node] = pointer;
                nodes[pointer] = node;
                depths[pointer] = depth;
                pointer++;
                for (int neighbor : graph[node]) {
                    if (visited[neighbor]) continue;
                    dfs(neighbor, depth + 1, graph, visited);
                    nodes[pointer] = node;
                    depths[pointer] = depth;
                    pointer++;
                }
            }

            public int find(int a, int b) {
                int left = entries[a];
                int right = entries[b];
                if (left > right) {
                    int temp = left;
                    left = right;
                    right = temp;
                }
                long mixedBag = fenwick.getMin(left, right);
                int index = (int) (mixedBag % 1000000L);
                return nodes[index];
            }
        }

        class FenwickMin {
            long n;
            long[] original;
            long[] bottomUp;
            long[] topDown;

            public FenwickMin(int n) {
                this.n = n;
                original = new long[n + 2];
                bottomUp = new long[n + 2];
                topDown = new long[n + 2];
            }

            public void set(int modifiedNode, long value) {
                long replaced = original[modifiedNode];
                original[modifiedNode] = value;
                // Update left tree
                int i = modifiedNode;
                long v = value;
                while (i <= n) {
                    if (v > bottomUp[i]) {
                        if (replaced == bottomUp[i]) {
                            v = Math.min(v, original[i]);
                            for (int r = 1; ; r++) {
                                int x = (i & -i) >>> r;
                                if (x == 0) break;
                                int child = i - x;
                                v = Math.min(v, bottomUp[child]);
                            }
                        } else break;
                    }
                    if (v == bottomUp[i]) break;
                    bottomUp[i] = v;
                    i += (i & -i);
                }
                // Update right tree
                i = modifiedNode;
                v = value;
                while (i > 0) {
                    if (v > topDown[i]) {
                        if (replaced == topDown[i]) {
                            v = Math.min(v, original[i]);
                            for (int r = 1; ; r++) {
                                int x = (i & -i) >>> r;
                                if (x == 0) break;
                                int child = i + x;
                                if (child > n + 1) break;
                                v = Math.min(v, topDown[child]);
                            }
                        } else break;
                    }
                    if (v == topDown[i]) break;
                    topDown[i] = v;
                    i -= (i & -i);
                }
            }

            public long getMin(int a, int b) {
                long min = original[a];
                int prev = a;
                int curr = prev + (prev & -prev); // parent right hand side
                while (curr <= b) {
                    min = Math.min(min, topDown[prev]); // value from the other tree
                    prev = curr;
                    curr = prev + (prev & -prev);
                    ;
                }
                min = Math.min(min, original[prev]);
                prev = b;
                curr = prev - (prev & -prev); // parent left hand side
                while (curr >= a) {
                    min = Math.min(min, bottomUp[prev]); // value from the other tree
                    prev = curr;
                    curr = prev - (prev & -prev);
                }
                return min;
            }

        }

        class FenwickSum {
            public long[] d;

            public FenwickSum(int n) {
                d = new long[n + 1];
            }

            /**
             * a[0] must be unused.
             */
            public FenwickSum(long[] a) {
                d = new long[a.length];
                for (int i = 1; i < a.length; i++) {
                    modify(i, a[i]);
                }
            }

            /**
             * Do not modify i=0.
             */
            void modify(int i, long v) {
                while (i < d.length) {
                    d[i] += v;
                    // Move to next uplink on the RIGHT side of i
                    i += (i & -i);
                }
            }

            /**
             * Returns sum from a to b, *BOTH* inclusive.
             */
            long getSum(int a, int b) {
                return getSum(b) - getSum(a - 1);
            }

            private long getSum(int i) {
                long sum = 0;
                while (i > 0) {
                    sum += d[i];
                    // Move to next uplink on the LEFT side of i
                    i -= (i & -i);
                }
                return sum;
            }
        }

        class SegmentTree {
            /**
             * Query sums with log(n) modifyRange
             */
            int N;
            long[] p;

            public SegmentTree(int n) {
                /* TODO: Test that this works. */
                for (N = 2; N < n; N++) N *= 2;
                p = new long[2 * N];
            }

            public void modifyRange(int a, int b, long change) {
                muuta(a, change);
                muuta(b + 1, -change);
            }

            void muuta(int k, long muutos) {
                k += N;
                p[k] += muutos;
                for (k /= 2; k >= 1; k /= 2) {
                    p[k] = p[2 * k] + p[2 * k + 1];
                }
            }

            public long get(int k) {
                int a = N;
                int b = k + N;
                long s = 0;
                while (a <= b) {
                    if (a % 2 == 1) s += p[a++];
                    if (b % 2 == 0) s += p[b--];
                    a /= 2;
                    b /= 2;
                }
                return s;
            }

        }

        class Zalgo {

            public int pisinEsiintyma(String haku, String kohde) {
                char[] s = new char[haku.length() + 1 + kohde.length()];
                for (int i = 0; i < haku.length(); i++) {
                    s[i] = haku.charAt(i);
                }
                int j = haku.length();
                s[j++] = '#';
                for (int i = 0; i < kohde.length(); i++) {
                    s[j++] = kohde.charAt(i);
                }
                int[] z = toZarray(s);
                int max = 0;
                for (int i = haku.length(); i < z.length; i++) {
                    max = Math.max(max, z[i]);
                }
                return max;
            }

            public int[] toZarray(char[] s) {
                int n = s.length;
                int[] z = new int[n];
                int a = 0, b = 0;
                for (int i = 1; i < n; i++) {
                    if (i > b) {
                        for (int j = i; j < n && s[j - i] == s[j]; j++) z[i]++;
                    } else {
                        z[i] = z[i - a];
                        if (i + z[i - a] > b) {
                            for (int j = b + 1; j < n && s[j - i] == s[j]; j++) z[i]++;
                            a = i;
                            b = i + z[i] - 1;
                        }
                    }
                }
                return z;
            }

            public List<Integer> getStartIndexesWhereWordIsFound(String haku, String kohde) {
                // this is alternative use case
                char[] s = new char[haku.length() + 1 + kohde.length()];
                for (int i = 0; i < haku.length(); i++) {
                    s[i] = haku.charAt(i);
                }
                int j = haku.length();
                s[j++] = '#';
                for (int i = 0; i < kohde.length(); i++) {
                    s[j++] = kohde.charAt(i);
                }
                int[] z = toZarray(s);
                List<Integer> indexes = new ArrayList<>();
                for (int i = haku.length(); i < z.length; i++) {
                    if (z[i] < haku.length()) continue;
                    indexes.add(i);
                }
                return indexes;
            }

        }

        class StringHasher {

            class HashedString {
                long[] hashes;
                long[] modifiers;

                public HashedString(long[] hashes, long[] modifiers) {
                    this.hashes = hashes;
                    this.modifiers = modifiers;
                }
            }

            long P;
            long M;

            public StringHasher() {
                initializePandM();
            }

            HashedString hashString(String s) {
                int n = s.length();
                long[] hashes = new long[n];
                long[] modifiers = new long[n];
                hashes[0] = s.charAt(0);
                modifiers[0] = 1;
                for (int i = 1; i < n; i++) {
                    hashes[i] = (hashes[i - 1] * P + s.charAt(i)) % M;
                    modifiers[i] = (modifiers[i - 1] * P) % M;
                }
                return new HashedString(hashes, modifiers);
            }

            /**
             * Indices are inclusive.
             */
            long getHash(HashedString hashedString, int startIndex, int endIndex) {
                long[] hashes = hashedString.hashes;
                long[] modifiers = hashedString.modifiers;
                long result = hashes[endIndex];
                if (startIndex > 0) result -= (hashes[startIndex - 1] * modifiers[endIndex - startIndex + 1]) % M;
                if (result < 0) result += M;
                return result;
            }

            // Less interesting methods below


            /**
             * Efficient for 2 input parameter strings in particular.
             */
            HashedString[] hashString(String first, String second) {
                HashedString[] array = new HashedString[2];
                int n = first.length();
                long[] modifiers = new long[n];
                modifiers[0] = 1;

                long[] firstHashes = new long[n];
                firstHashes[0] = first.charAt(0);
                array[0] = new HashedString(firstHashes, modifiers);

                long[] secondHashes = new long[n];
                secondHashes[0] = second.charAt(0);
                array[1] = new HashedString(secondHashes, modifiers);

                for (int i = 1; i < n; i++) {
                    modifiers[i] = (modifiers[i - 1] * P) % M;
                    firstHashes[i] = (firstHashes[i - 1] * P + first.charAt(i)) % M;
                    secondHashes[i] = (secondHashes[i - 1] * P + second.charAt(i)) % M;
                }
                return array;
            }

            /**
             * Efficient for 3+ strings
             * More efficient than multiple hashString calls IF strings are same length.
             */
            HashedString[] hashString(String... strings) {
                HashedString[] array = new HashedString[strings.length];
                int n = strings[0].length();
                long[] modifiers = new long[n];
                modifiers[0] = 1;
                for (int j = 0; j < strings.length; j++) {
                    // if all strings are not same length, defer work to another method
                    if (strings[j].length() != n) {
                        for (int i = 0; i < n; i++) {
                            array[i] = hashString(strings[i]);
                        }
                        return array;
                    }

                    // otherwise initialize stuff
                    long[] hashes = new long[n];
                    hashes[0] = strings[j].charAt(0);
                    array[j] = new HashedString(hashes, modifiers);
                }
                for (int i = 1; i < n; i++) {
                    modifiers[i] = (modifiers[i - 1] * P) % M;
                    for (int j = 0; j < strings.length; j++) {
                        String s = strings[j];
                        long[] hashes = array[j].hashes;
                        hashes[i] = (hashes[i - 1] * P + s.charAt(i)) % M;
                    }
                }
                return array;
            }

            void initializePandM() {
                ArrayList<Long> modOptions = new ArrayList<>(20);
                modOptions.add(353873237L);
                modOptions.add(353875897L);
                modOptions.add(353878703L);
                modOptions.add(353882671L);
                modOptions.add(353885303L);
                modOptions.add(353888377L);
                modOptions.add(353893457L);
                P = modOptions.get(new Random().nextInt(modOptions.size()));

                modOptions.clear();
                modOptions.add(452940277L);
                modOptions.add(452947687L);
                modOptions.add(464478431L);
                modOptions.add(468098221L);
                modOptions.add(470374601L);
                modOptions.add(472879717L);
                modOptions.add(472881973L);
                M = modOptions.get(new Random().nextInt(modOptions.size()));

            }
        }

        private static class Prob {

            /** For heavy calculations on probabilities, this class
             *  provides more accuracy & efficiency than doubles.
             *  Math explained: https://en.wikipedia.org/wiki/Log_probability
             *  Quick start:
             *      - Instantiate probabilities, eg. Prob a = new Prob(0.75)
             *      - add(), multiply() return new objects, can perform on nulls & NaNs.
             *      - get() returns probability as a readable double */

            /**
             * Logarithmized probability. Note: 0% represented by logP NaN.
             */
            private double logP;

            /**
             * Construct instance with real probability.
             */
            public Prob(double real) {
                if (real > 0) this.logP = Math.log(real);
                else this.logP = Double.NaN;
            }

            /**
             * Construct instance with already logarithmized value.
             */
            static boolean dontLogAgain = true;

            public Prob(double logP, boolean anyBooleanHereToChooseThisConstructor) {
                this.logP = logP;
            }

            /**
             * Returns real probability as a double.
             */
            public double get() {
                return Math.exp(logP);
            }

            @Override
            public String toString() {
                return "" + get();
            }

            /***************** STATIC METHODS BELOW ********************/

            /**
             * Note: returns NaN only when a && b are both NaN/null.
             */
            public static Prob add(Prob a, Prob b) {
                if (nullOrNaN(a) && nullOrNaN(b)) return new Prob(Double.NaN, dontLogAgain);
                if (nullOrNaN(a)) return copy(b);
                if (nullOrNaN(b)) return copy(a);

                double x = Math.max(a.logP, b.logP);
                double y = Math.min(a.logP, b.logP);
                double sum = x + Math.log(1 + Math.exp(y - x));
                return new Prob(sum, dontLogAgain);
            }

            /**
             * Note: multiplying by null or NaN produces NaN (repping 0% real prob).
             */
            public static Prob multiply(Prob a, Prob b) {
                if (nullOrNaN(a) || nullOrNaN(b)) return new Prob(Double.NaN, dontLogAgain);
                return new Prob(a.logP + b.logP, dontLogAgain);
            }

            /**
             * Returns true if p is null or NaN.
             */
            private static boolean nullOrNaN(Prob p) {
                return (p == null || Double.isNaN(p.logP));
            }

            /**
             * Returns a new instance with the same value as original.
             */
            private static Prob copy(Prob original) {
                return new Prob(original.logP, dontLogAgain);
            }
        }

        public class StronglyConnectedComponents {

            /**
             * Kosaraju's algorithm
             */

            ArrayList<Integer>[] forw;
            ArrayList<Integer>[] bacw;

            /**
             * Use: getCount(2, new int[] {1,2}, new int[] {2,1})
             */
            public int getCount(int n, int[] mista, int[] minne) {
                forw = new ArrayList[n + 1];
                bacw = new ArrayList[n + 1];
                for (int i = 1; i <= n; i++) {
                    forw[i] = new ArrayList<Integer>();
                    bacw[i] = new ArrayList<Integer>();
                }
                for (int i = 0; i < mista.length; i++) {
                    int a = mista[i];
                    int b = minne[i];
                    forw[a].add(b);
                    bacw[b].add(a);
                }
                int count = 0;
                List<Integer> list = new ArrayList<Integer>();
                boolean[] visited = new boolean[n + 1];
                for (int i = 1; i <= n; i++) {
                    dfsForward(i, visited, list);
                }
                visited = new boolean[n + 1];
                for (int i = n - 1; i >= 0; i--) {
                    int node = list.get(i);
                    if (visited[node]) continue;
                    count++;
                    dfsBackward(node, visited);
                }
                return count;
            }

            public void dfsForward(int i, boolean[] visited, List<Integer> list) {
                if (visited[i]) return;
                visited[i] = true;
                for (int neighbor : forw[i]) {
                    dfsForward(neighbor, visited, list);
                }
                list.add(i);
            }

            public void dfsBackward(int i, boolean[] visited) {
                if (visited[i]) return;
                visited[i] = true;
                for (int neighbor : bacw[i]) {
                    dfsBackward(neighbor, visited);
                }
            }
        }

        class DrawGrid {

            void draw(boolean[][] d) {
                System.out.print("  ");
                for (int x = 0; x < d[0].length; x++) {
                    System.out.print(" " + x + " ");
                }
                System.out.println("");
                for (int y = 0; y < d.length; y++) {
                    System.out.print(y + " ");
                    for (int x = 0; x < d[0].length; x++) {
                        System.out.print((d[y][x] ? "[x]" : "[ ]"));
                    }
                    System.out.println("");
                }
            }

            void draw(int[][] d) {
                int max = 1;
                for (int y = 0; y < d.length; y++) {
                    for (int x = 0; x < d[0].length; x++) {
                        max = Math.max(max, ("" + d[y][x]).length());
                    }
                }
                System.out.print("  ");
                String format = "%" + (max + 2) + "s";
                for (int x = 0; x < d[0].length; x++) {
                    System.out.print(String.format(format, x) + " ");
                }
                format = "%" + (max) + "s";
                System.out.println("");
                for (int y = 0; y < d.length; y++) {
                    System.out.print(y + " ");
                    for (int x = 0; x < d[0].length; x++) {
                        System.out.print(" [" + String.format(format, (d[y][x])) + "]");
                    }
                    System.out.println("");
                }
            }

        }

        class BaseConverter {

            /* Palauttaa luvun esityksen kannassa base */
            public String convert(Long number, int base) {
                return Long.toString(number, base);
            }

            /* Palauttaa luvun esityksen kannassa baseTo, kun annetaan luku Stringinä kannassa baseFrom */
            public String convert(String number, int baseFrom, int baseTo) {
                return Long.toString(Long.parseLong(number, baseFrom), baseTo);
            }

            /* Tulkitsee kannassa base esitetyn luvun longiksi (kannassa 10) */
            public long longify(String number, int baseFrom) {
                return Long.parseLong(number, baseFrom);
            }
        }

        class Binary implements Comparable<Binary> {

            /**
             * Use example: Binary b = new Binary(Long.toBinaryString(53249834L));
             * <p>
             * When manipulating small binary strings, instantiate new Binary(string)
             * When just reading large binary strings, instantiate new Binary(string,true)
             * get(int i) returns a character '1' or '0', not an int.
             */

            private boolean[] d;
            private int first; // Starting from left, the first (most remarkable) '1'
            public int length;


            public Binary(String binaryString) {
                this(binaryString, false);
            }

            public Binary(String binaryString, boolean initWithMinArraySize) {
                length = binaryString.length();
                int size = Math.max(2 * length, 1);
                first = length / 4;
                if (initWithMinArraySize) {
                    first = 0;
                    size = Math.max(length, 1);
                }
                d = new boolean[size];
                for (int i = 0; i < length; i++) {
                    if (binaryString.charAt(i) == '1') d[i + first] = true;
                }
            }

            public void addFirst(char c) {
                if (first - 1 < 0) doubleArraySize();
                first--;
                d[first] = (c == '1' ? true : false);
                length++;
            }

            public void addLast(char c) {
                if (first + length >= d.length) doubleArraySize();
                d[first + length] = (c == '1' ? true : false);
                length++;
            }

            private void doubleArraySize() {
                boolean[] bigArray = new boolean[(d.length + 1) * 2];
                int newFirst = bigArray.length / 4;
                for (int i = 0; i < length; i++) {
                    bigArray[i + newFirst] = d[i + first];
                }
                first = newFirst;
                d = bigArray;
            }

            public boolean flip(int i) {
                boolean value = (this.d[first + i] ? false : true);
                this.d[first + i] = value;
                return value;
            }

            public void set(int i, char c) {
                boolean value = (c == '1' ? true : false);
                this.d[first + i] = value;
            }

            public char get(int i) {
                return (this.d[first + i] ? '1' : '0');
            }

            @Override
            public int compareTo(Binary o) {
                if (this.length != o.length) return this.length - o.length;
                int len = this.length;
                for (int i = 0; i < len; i++) {
                    int diff = this.get(i) - o.get(i);
                    if (diff != 0) return diff;
                }
                return 0;
            }

            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < length; i++) {
                    sb.append(d[i + first] ? '1' : '0');
                }
                return sb.toString();
            }


        }

        class BinomialCoefficients {
            /** Total number of K sized unique combinations from pool of size N (unordered)
             N! / ( K! (N - K)! )   */

            /**
             * For simple queries where output fits in long.
             */
            public long biCo(long n, long k) {
                long r = 1;
                if (k > n) return 0;
                for (long d = 1; d <= k; d++) {
                    r *= n--;
                    r /= d;
                }
                return r;
            }

            /**
             * For multiple queries with same n, different k.
             */
            public long[] precalcBinomialCoefficientsK(int n, int maxK) {
                long v[] = new long[maxK + 1];
                v[0] = 1; // nC0 == 1
                for (int i = 1; i <= n; i++) {
                    for (int j = Math.min(i, maxK); j > 0; j--) {
                        v[j] = v[j] + v[j - 1]; // Pascal's triangle
                    }
                }
                return v;
            }

            /**
             * When output needs % MOD.
             */
            public long[] precalcBinomialCoefficientsK(int n, int k, long M) {
                long v[] = new long[k + 1];
                v[0] = 1; // nC0 == 1
                for (int i = 1; i <= n; i++) {
                    for (int j = Math.min(i, k); j > 0; j--) {
                        v[j] = v[j] + v[j - 1]; // Pascal's triangle
                        v[j] %= M;
                    }
                }
                return v;
            }
        }

        class Trie {
            int N;
            int Z;
            int nextFreeId;
            int[][] pointers;
            boolean[] end;

            /**
             * maxLenSum = maximum possible sum of length of words
             */
            public Trie(int maxLenSum, int alphabetSize) {
                this.N = maxLenSum;
                this.Z = alphabetSize;
                this.nextFreeId = 1;
                pointers = new int[N + 1][alphabetSize];
                end = new boolean[N + 1];
            }

            public void addWord(String word) {
                int curr = 0;
                for (int j = 0; j < word.length(); j++) {
                    int c = word.charAt(j) - 'a';
                    int next = pointers[curr][c];
                    if (next == 0) {
                        next = nextFreeId++;
                        pointers[curr][c] = next;
                    }
                    curr = next;
                }
                int last = word.charAt(word.length() - 1) - 'a';
                end[last] = true;
            }

            public boolean hasWord(String word) {
                int curr = 0;
                for (int j = 0; j < word.length(); j++) {
                    int c = word.charAt(j) - 'a';
                    int next = pointers[curr][c];
                    if (next == 0) return false;
                    curr = next;
                }
                int last = word.charAt(word.length() - 1) - 'a';
                return end[last];
            }

        }

        private class IO extends PrintWriter {
            private InputStreamReader r;
            private static final int BUFSIZE = 1 << 15;
            private char[] buf;
            private int bufc;
            private int bufi;
            private StringBuilder sb;

            public IO() {
                super(new BufferedOutputStream(System.out));
                r = new InputStreamReader(System.in);

                buf = new char[BUFSIZE];
                bufc = 0;
                bufi = 0;
                sb = new StringBuilder();
            }

            /**
             * Print, flush, return nextInt.
             */
            private int queryInt(String s) {
                io.println(s);
                io.flush();
                return nextInt();
            }

            /**
             * Print, flush, return nextLong.
             */
            private long queryLong(String s) {
                io.println(s);
                io.flush();
                return nextLong();
            }

            /**
             * Print, flush, return next word.
             */
            private String queryNext(String s) {
                io.println(s);
                io.flush();
                return next();
            }

            private void fillBuf() throws IOException {
                bufi = 0;
                bufc = 0;
                while (bufc == 0) {
                    bufc = r.read(buf, 0, BUFSIZE);
                    if (bufc == -1) {
                        bufc = 0;
                        return;
                    }
                }
            }

            private boolean pumpBuf() throws IOException {
                if (bufi == bufc) {
                    fillBuf();
                }
                return bufc != 0;
            }

            private boolean isDelimiter(char c) {
                return c == ' ' || c == '\t' || c == '\n' || c == '\r' || c == '\f';
            }

            private void eatDelimiters() throws IOException {
                while (true) {
                    if (bufi == bufc) {
                        fillBuf();
                        if (bufc == 0) throw new RuntimeException("IO: Out of input.");
                    }

                    if (!isDelimiter(buf[bufi])) break;
                    ++bufi;
                }
            }

            public String next() {
                try {
                    sb.setLength(0);

                    eatDelimiters();
                    int start = bufi;

                    while (true) {
                        if (bufi == bufc) {
                            sb.append(buf, start, bufi - start);
                            fillBuf();
                            start = 0;
                            if (bufc == 0) break;
                        }

                        if (isDelimiter(buf[bufi])) break;
                        ++bufi;
                    }

                    sb.append(buf, start, bufi - start);

                    return sb.toString();
                } catch (IOException e) {
                    throw new RuntimeException("IO.next: Caught IOException.");
                }
            }

            public int nextInt() {
                try {
                    int ret = 0;

                    eatDelimiters();

                    boolean positive = true;
                    if (buf[bufi] == '-') {
                        ++bufi;
                        if (!pumpBuf()) throw new RuntimeException("IO.nextInt: Invalid int.");
                        positive = false;
                    }

                    boolean first = true;
                    while (true) {
                        if (!pumpBuf()) break;
                        if (isDelimiter(buf[bufi])) {
                            if (first) throw new RuntimeException("IO.nextInt: Invalid int.");
                            break;
                        }
                        first = false;

                        if (buf[bufi] >= '0' && buf[bufi] <= '9') {
                            if (ret < -214748364) throw new RuntimeException("IO.nextInt: Invalid int.");
                            ret *= 10;
                            ret -= (int) (buf[bufi] - '0');
                            if (ret > 0) throw new RuntimeException("IO.nextInt: Invalid int.");
                        } else {
                            throw new RuntimeException("IO.nextInt: Invalid int.");
                        }

                        ++bufi;
                    }

                    if (positive) {
                        if (ret == -2147483648) throw new RuntimeException("IO.nextInt: Invalid int.");
                        ret = -ret;
                    }

                    return ret;
                } catch (IOException e) {
                    throw new RuntimeException("IO.nextInt: Caught IOException.");
                }
            }

            public long nextLong() {
                try {
                    long ret = 0;

                    eatDelimiters();

                    boolean positive = true;
                    if (buf[bufi] == '-') {
                        ++bufi;
                        if (!pumpBuf()) throw new RuntimeException("IO.nextLong: Invalid long.");
                        positive = false;
                    }

                    boolean first = true;
                    while (true) {
                        if (!pumpBuf()) break;
                        if (isDelimiter(buf[bufi])) {
                            if (first) throw new RuntimeException("IO.nextLong: Invalid long.");
                            break;
                        }
                        first = false;

                        if (buf[bufi] >= '0' && buf[bufi] <= '9') {
                            if (ret < -922337203685477580L) throw new RuntimeException("IO.nextLong: Invalid long.");
                            ret *= 10;
                            ret -= (long) (buf[bufi] - '0');
                            if (ret > 0) throw new RuntimeException("IO.nextLong: Invalid long.");
                        } else {
                            throw new RuntimeException("IO.nextLong: Invalid long.");
                        }

                        ++bufi;
                    }

                    if (positive) {
                        if (ret == -9223372036854775808L) throw new RuntimeException("IO.nextLong: Invalid long.");
                        ret = -ret;
                    }

                    return ret;
                } catch (IOException e) {
                    throw new RuntimeException("IO.nextLong: Caught IOException.");
                }
            }

            public double nextDouble() {
                return Double.parseDouble(next());
            }

        }

        void print(Object output) {
            io.println(output);
        }

        void done(Object output) {
            print(output);
            done();
        }

        void done() {
            io.close();
            throw new RuntimeException("Clean exit");
        }

        long min(long... v) {
            long ans = v[0];
            for (int i = 1; i < v.length; i++) {
                ans = Math.min(ans, v[i]);
            }
            return ans;
        }

        double min(double... v) {
            double ans = v[0];
            for (int i = 1; i < v.length; i++) {
                ans = Math.min(ans, v[i]);
            }
            return ans;
        }

        int min(int... v) {
            int ans = v[0];
            for (int i = 1; i < v.length; i++) {
                ans = Math.min(ans, v[i]);
            }
            return ans;
        }

        long max(long... v) {
            long ans = v[0];
            for (int i = 1; i < v.length; i++) {
                ans = Math.max(ans, v[i]);
            }
            return ans;
        }

        double max(double... v) {
            double ans = v[0];
            for (int i = 1; i < v.length; i++) {
                ans = Math.max(ans, v[i]);
            }
            return ans;
        }

        int max(int... v) {
            int ans = v[0];
            for (int i = 1; i < v.length; i++) {
                ans = Math.max(ans, v[i]);
            }
            return ans;
        }

        void debug(Object output) {
            if (DEBUG_PRINTS) {
                System.out.println(output);
            }
        }
    }


}
