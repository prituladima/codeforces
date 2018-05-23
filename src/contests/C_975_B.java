package contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class C_975_B {

    private long getMaxForI(final int i, final long[] array) {
        long[] copy = Arrays.copyOf(array, array.length);

        long remain = copy[i];

        copy[i] = 0;

        long dist = remain / 14;

        for (int j = 1; j <= 14; j++) {
            copy[(i + j) % 14] += dist;
            remain -= dist;
        }

        int j = 1;
        while (remain > 0) {
            copy[(i + j) % 14]++;
            remain--;
            j++;
        }

        long sum = 0;
        for (int k = 0; k < copy.length; k++) {
            if (copy[k] % 2 == 0) sum += copy[k];
        }
        return sum;

    }


    private void solve() throws IOException {

        long[] array = nextArrL(14);

        long max = 0;

        for (int i = 0; i < 14; i++) {
            if (array[i] > 0) {
                max = Math.max(getMaxForI(i, array), max);
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        new C_975_B().run();
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
