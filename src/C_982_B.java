import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by prituladima on 5/17/18.
 */
public class C_982_B {


    public static class Pair982
//            implements Comparable<Integer>
    {

        public Pair982(int v, int order) {
            this.v = v;
            this.order = order;
        }

        int v;
        int order;

        int p = 0;

        @Override
        public String toString() {
            return "Pair982{" +
                    "v=" + v +
                    ", order=" + order +
                    '}';
        }
    }


    private void solve() throws IOException {

        int n = nextInt();
        int[] w = nextArr(n);
        char[] chars = nextToken().toCharArray();


        List<Pair982> pairs = new ArrayList<>();

        int count = 0;
        for (int i : w) {
            pairs.add(new Pair982(i, count++));
        }

        Collections.sort(pairs, (v1, v2) -> Integer.compare(v1.v, v2.v));


        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '0') {

                boolean out = false;
                for (int j = 0; j < pairs.size(); j++) {
                    if (pairs.get(j).p < 1) {
                        pairs.get(j).p++;
                        System.out.print((pairs.get(j).order + 1) + " ");
                        out = true;
                        break;
                    }
                }

                if (out) continue;

                for (int j = 0; j < pairs.size(); j++) {
                    if (pairs.get(j).p == 1) {
                        pairs.get(j).p++;
                        System.out.print((pairs.get(j).order + 1) + " ");
                        break;
                    }
                }


            } else {
                boolean out = false;
                for (int i1 = pairs.size() - 1; i1 >= 0; i1--) {
                    if (pairs.get(i1).p == 1) {
                        pairs.get(i1).p++;
                        System.out.print((pairs.get(i1).order + 1) + " ");
                        out = true;
                        break;
                    }
                }


                if (out) continue;
                for (int i1 = pairs.size() - 1; i1 >= 0; i1--) {
                    if (pairs.get(i1).p == 0) {
                        pairs.get(i1).p++;
                        System.out.print((pairs.get(i1).order + 1) + " ");
                        break;
                    }
                }

            }


        }


    }

    public static void main(String[] args) {
        new C_982_B().run();
    }

    StringTokenizer tokenizer;
    BufferedReader reader;
    PrintWriter writer;

    public void run() {
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

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    int[] nextArr(int size) throws NumberFormatException, IOException {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = nextInt();
        return arr;
    }

    long[] nextArrL(int size) throws NumberFormatException, IOException {
        long[] arr = new long[size];
        for (int i = 0; i < size; i++)
            arr[i] = nextLong();
        return arr;
    }

    double[] nextArrD(int size) throws NumberFormatException, IOException {
        double[] arr = new double[size];
        for (int i = 0; i < size; i++)
            arr[i] = nextDouble();
        return arr;
    }

}