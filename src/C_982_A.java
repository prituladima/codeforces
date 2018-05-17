import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by prituladima on 5/17/18.
 */
public class C_982_A {

    private void solve() throws IOException {

        int n = nextInt();

        char[] chars = nextToken().toCharArray();


        if (n == 1) {
            if (chars[0] == '1') {
                System.out.println("YES");
                return;
            } else {
                System.out.println("NO");
                return;
            }
        }

//        if (n == 2){
//            if(chars[0] == '0' && chars[1] == '0'){
//                System.out.println("NO");
//                return;
//            }
//        }

        if(n >= 2){
            if(chars[0] == '0' && chars[1] == '0'){
                System.out.println("NO");
                return;
            }

            if(chars[n-1] == '0' && chars[n-2] == '0'){
                System.out.println("NO");
                return;
            }
        }


        chars = new String(chars).replaceAll("000", "*").replaceAll("11", "*").toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if ('*' == chars[i]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");


    }

    public static void main(String[] args) {
        new C_982_A().run();
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
