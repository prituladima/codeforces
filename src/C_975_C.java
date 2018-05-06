import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class C_975_C {

    private void solve() throws IOException {

        final int n = nextInt(), q = nextInt();
        final long[] warrior_powers = nextArrL(n);
        final long[] attack_limits = nextArrL(q);


        long[] warrior_powers_mut = Arrays.copyOf(warrior_powers, warrior_powers.length);

        int currentMinute = 0;
        int currentWarrior = 0;
        while (currentMinute != q) {

            long warrior_left = 0;
            long c_attack_limit = attack_limits[currentMinute];


            while (c_attack_limit > 0) {


                if (warrior_powers_mut[currentWarrior] == 0) currentWarrior++;

                warrior_powers_mut[currentWarrior]--;


                c_attack_limit--;

                if (currentWarrior + 1 == n && warrior_powers_mut[currentWarrior] == 0) {
                    warrior_powers_mut = Arrays.copyOf(warrior_powers, warrior_powers.length);
                    currentWarrior = 0;
                    break;
                }


            }

            for (long l : warrior_powers_mut) {
                warrior_left += l != 0 ? 1 : 0;
            }

//            writer.println(Arrays.toString(warrior_powers_mut));
            writer.println(warrior_left);
            currentMinute++;
        }


    }

    public static void main(String[] args) {
        new C_975_C().run();
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