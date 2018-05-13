import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by prituladima on 5/13/18.
 */
public class C_978_C {


    private void solve() throws IOException {

        int n = nextInt(), m = nextInt();

        final long[] a = nextArrL(n), b = nextArrL(m);

        long[] sums = a.clone();
        for (int i = 1; i < sums.length; i++) {
            sums[i] += sums[i - 1];
        }


        for (int i = 0; i < b.length; i++) {
            int house = BinarySearch(sums, b[i], 1, sums.length -1) + 1;
            if(house == 0) house = 1;
            long ap;
            if(house == 1){
                ap = b[i];
            }
            else {
                ap = b[i] - sums[house - 2];
            }
//            if(apartaments == 0){
//                apartaments = a[house - 1];
//            }

            System.out.println(house + " " + ap);
        }

    }

    public long app(long[] apartments_per_house, long abs) {
        long sum = abs;
        for (long l : apartments_per_house) {
            if (sum - l < 0) return sum;
            else sum -= l;
        }
        return sum;
    }

    public int search(long[] arr, long key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= key) return i + 1;
        }
        return -1;
    }


    public int BinarySearch(
            long[] sortedArray, long key, int low, int high) {


        if (high < low) {
            return -1;
        }


        int middle = (low + high) / 2;

        if (sortedArray[middle-1] < key && key <= sortedArray[middle]) {
            return middle;
        } else if (key < sortedArray[middle]) {
            return BinarySearch(
                    sortedArray, key, low, middle - 1);
        } else {
            return BinarySearch(
                    sortedArray, key, middle + 1, high);
        }
    }

    public static void main(String[] args) {
        new C_978_C().run();
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
