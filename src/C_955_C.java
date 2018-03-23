import org.omg.CORBA.INTERNAL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by prituladima on 3/23/18.
 */
public class C_955_C {


    public static void main(String[] args) throws IOException {

        FastScanner scanner = new FastScanner(System.in);
        int Q = scanner.nextInt();

        List<Integer> Ls = new ArrayList<>();
        List<Integer> Rs = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            Ls.add(scanner.nextInt());
            Rs.add(scanner.nextInt());
        }

        for (int i = 0; i < Ls.size(); i++) {
            System.out.println(solve(Ls.get(i), Rs.get(i)));
        }


    }

    public static long solve(long L, long R) {
        long ar = 1000;
        long pr = 70;

        Set<Long> set = new HashSet<>();

        for (long a = 1; a < ar; a++) {
            for (long p = 2; p < pr; p++) {
                long current = fast_pow(a, p);
                if (L <= current && current <= R) {
                    set.add(current);
                }
            }
        }

        return set.size();
    }

    public static long fast_pow(long a, long b) {
        long result = 1;
        while (b > 0) {
            if (b % 2 != 0) {
                result *= a;
                b--;
            }
            a *= a;
            b /= 2;
        }

        return result;

    }


    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i));
            st = null;
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            if (st == null)
                return br.readLine();
            String line = "";
            if (st.hasMoreTokens())
                line = st.nextToken("");
            st = null;
            return line;
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }

}
