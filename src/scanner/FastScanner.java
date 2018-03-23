package scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastScanner {
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