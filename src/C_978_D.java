import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by prituladima on 5/13/18.
 */
public class C_978_D {

    private void solve() throws IOException {

        int n = nextInt();
        int[] b = nextArr(n);

        if (n <= 2) {
            System.out.println(0);
            return;
        }

        int min = Integer.MAX_VALUE;

        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int a1 = b[0] + d1;
                int a2 = b[1] + d2;
                int cnt = Math.abs(d1) + Math.abs(d2);
//                System.out.print(d1 + " " + d2 + " ");
                for (int i = 2; i < b.length; i++) {

                    int ai = a1 + i * (a2 - a1);
                    if (Math.abs(ai - b[i]) > 1) {
                        cnt = Integer.MAX_VALUE;
                        break;
                    } else if (ai - b[i] == 0) {

                    } else {
                        cnt++;
                    }
                }

                min = Math.min(cnt, min);
//                System.out.println(cnt);
            }
        }

        if (min == Integer.MAX_VALUE) min = -1;

        System.out.println(min);

    }

    public static void main(String[] args) {
        new C_978_D().run();
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
