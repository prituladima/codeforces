import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class C_977_B {

    private void solve() throws IOException {

        int n = nextInt();
        String s = nextToken();

        if(n == 2) {
            System.out.println(s);
            return;
        }


        Map<String, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (chars[i] == chars[j] && chars[i + 1] == chars[j + 1]) {
                    String key = chars[i] + "" + chars[i + 1];
                    int value = map.containsKey(key) ? map.get(key) + 1 : 1;
                    map.put(key, value);
                }
            }
        }

        String max = null;
        int maxInt = 0;
        for (String s1 : map.keySet()) {
            if (maxInt < map.get(s1)) {
                maxInt = map.get(s1);
                max = s1;
            }
        }

        System.out.println(max);


    }

    public static void main(String[] args) {
        new C_977_B().run();
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
