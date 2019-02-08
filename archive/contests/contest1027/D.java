import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public class D {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> cycles;
    int buf = -1;
    int[] price = new int[200002];
    int[] color = new int[200002];
    int[] graph = new int[200002];

    private void dfs(int from) {
        color[from] = 1;
        int to = graph[from];
        if (color[to] == 0) dfs(to);
        if (color[to] == 1) buf = to;
        if (buf != -1) cycles.add(from);
        if (from == buf) buf = -1;
        color[from] = 2;
    }

    private void solve() {
        int n = nextInt();
        for (int i = 1; i <= n; i++) {
            price[i] = nextInt();
        }
        for (int i = 1; i <= n; i++) {
            graph[i] = nextInt();
        }
        for (int from = 1; from <= n; from++) {
            if (color[from] == 0) {
                cycles = new ArrayList<>();
                dfs(from);
                ans.add(cycles);
            }
        }
        long res = 0;
        for (int i = 0; i < ans.size(); i++) {
            int min = Integer.MAX_VALUE;
            if (ans.get(i).size() != 0) {
                for (int j = 0; j < ans.get(i).size(); j++) {
                    min = Integer.min(min, price[ans.get(i).get(j)]);
                }
                res += min;
            }
        }
        soutnl(res);
    }

    public static void main(String[] args) {
        new D().run();
    }

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;

    private void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            writer = new PrintWriter(System.out);
            solve();
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private int nextInt() {
        return parseInt(nextToken());
    }

    private long nextLong() {
        return parseLong(nextToken());
    }

    private double nextDouble() {
        return parseDouble(nextToken());
    }

    private int[] nextArr(int size) {
        return stream(new int[size]).map(c -> nextInt()).toArray();
    }

    private long[] nextArrL(int size) {
        return stream(new long[size]).map(c -> nextLong()).toArray();
    }

    private double[] nextArrD(int size) {
        return stream(new double[size]).map(c -> nextDouble()).toArray();
    }

    private char[][] nextCharMatrix(int n) {
        return range(0, n).mapToObj(i -> nextToken().toCharArray()).toArray(char[][]::new);
    }

    private int[][] nextIntMatrix(final int n, final int m) {
        return range(0, n).mapToObj(i -> nextArr(m)).toArray(int[][]::new);
    }

    private double[][] nextDoubleMatrix(int n, int m) {
        return range(0, n).mapToObj(i -> nextArr(m)).toArray(double[][]::new);
    }

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

    private void souf(String format, Object... args) {
        writer.printf(format, args);
    }

    private void sout(Object o) {
        writer.print(o);
    }

    private void newLine() {
        writer.println();
    }

    private void soutnl(Object o) {
        sout(o);
        newLine();
    }
}