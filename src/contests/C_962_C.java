package contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by prituladima on 5/8/18.
 */
public class C_962_C {

    private void solve() throws IOException {

        int n = nextInt();

        List<Integer> pows = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {

            pows.add(i * i);

        }

        if (pows.contains(n)) {
            System.out.println(0);
            return;
        }

        char[] str = String.valueOf(n).toCharArray();

        List<Character> list1 = new ArrayList<>();
        for (char c : str) {
            list1.add(c);
        }


        solveP(pows, list1, 0);

        int maxLenght = -1;
        for (List<Character> characters : charsArr) {
            if (maxLenght < characters.size()) {
                maxLenght = characters.size();
            }
        }

        if (maxLenght == -1) {
            System.out.println(-1);
            return;
        }

        System.out.println(str.length - maxLenght);

    }

    Set<List<Character>> charsArr = new HashSet<>();


    private void solveP(final List<Integer> pows, final List<Character> initial, int counter) {
        for (int i = 0; i < initial.size(); i++) {
            List<Character> list2 = new ArrayList<>(initial);
            list2.remove(i);
            if (list2.size() == 0) {
                return;
            }
            int candidate = getN(list2);
            if (pows.contains(candidate)) {
//                counter++;
//                System.out.println(list2);
                charsArr.add(list2);
//                System.out.println(++counter);
            } else {
                solveP(pows, list2, ++counter);
            }
        }
    }

    private int getN(List<Character> chars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            stringBuilder.append(aChar);
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    public static void main(String[] args) {
        new C_962_C().run();
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
