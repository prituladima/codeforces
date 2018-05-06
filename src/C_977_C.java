import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class C_977_C {

    private void solve() throws IOException {

        int n = nextInt();
        int k = nextInt();
        int[] ar = nextArr(n);


        Arrays.sort(ar);
//        System.out.println(Arrays.toString(ar));




        if (k == 0) {
            if(ar[0] == 1) System.out.println(-1);
            else System.out.println(ar[0] - 1);
            return;
        }

        if (k == n) {
            System.out.println(ar[k - 1]);
            return;
        }


        if (ar[k - 1] == ar[k]) {
            System.out.println(-1);
        } else {
            System.out.println(ar[k - 1]);
        }


//        int max = -1;
//        int maxI = -1;
//
//        for (int i = 0; i < ar.length; i++) {
//            if(ar[k-1] <= )
//        }




    }

    public static void main(String[] args) {
        new C_977_C().run();
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
