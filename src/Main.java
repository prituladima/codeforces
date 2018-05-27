import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by prituladima on 5/23/18.
 */
public class Main {

    private void solve() throws IOException {

        int n = nextInt(), d = nextInt();
        int[] x = nextArr(n);
        List<Integer> list = new ArrayList<>();
        for (int i : x) {
            list.add(i);
        }
        Collections.sort(list);

        Set<Integer> set = new HashSet<>(list);

        if (set.size() == 1) {
            System.out.println(0);
            return;
        }

        int before = list.size();

        while (list.get(list.size() - 1) - list.get(0) > d) {
            if (list.get(1) - list.get(0) > list.get(list.size() - 1) - list.get(list.size() - 2)) {
                list.remove(0);
            } else {
                list.remove(list.size() - 1);
            }
        }

        int after = list.size();
        System.out.println(before - after);


    }

    public static void main(String[] args) {
        new Main().run();
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