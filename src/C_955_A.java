import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class C_955_A {

    public static void main(String[] args) throws IOException {

        FastScanner scanner = new FastScanner(System.in);
        int hh = scanner.nextInt();
        int mm = scanner.nextInt();

        int H = scanner.nextInt();
        int D = scanner.nextInt();


        double C = scanner.nextDouble();
        int N = scanner.nextInt();

        double res = 0.0;
        if (hh >= 20) {
            res = (H + N - 1) / N * (C * 0.8);
        } else {
            double amount = (H + N - 1) / N;
            double now = amount * C;
            double time = ((20 - hh - 1) * 60 + (60 - mm));
            double amount2 = (time * D + H + N - 1) / N;
            double wait = (amount2 * (C * 0.8));
            res = Math.min(now, wait);
        }

        System.out.printf("%.4f", res);

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
