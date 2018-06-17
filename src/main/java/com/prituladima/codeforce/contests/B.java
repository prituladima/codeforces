import java.io.*;
import java.util.*;

public class B {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt(), k = sc.nextInt();
        Knight[] a = new Knight[n];
        for (int i = 0; i < n; ++i) a[i] = new Knight(sc.nextInt(), i);
        for (int i = 0; i < n; i++) a[i].cost = sc.nextInt();
        Arrays.sort(a);

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        long ans[]  = new long[n];
        for (int i = 0; i < n; i++) {
            long sum = 0;
            ArrayList<Integer> store = new ArrayList<>();
            for (int j = 0; j < k && !pq.isEmpty(); j++) {
                int x = pq.remove();
                sum += x;
                store.add(x);
            }
            ans[a[i].idx] = sum + a[i].cost;
            for (int x : store) pq.add(x);
            pq.add(a[i].cost);
        }

        for (long x : ans) out.printf("%d ", x);
        out.println();

        out.flush();
        out.close();
    }

    static class Knight implements Comparable<Knight> {

        int power, cost, idx;

        Knight(int p, int i) {
            power = p;
            idx = i;
        }

        @Override
        public int compareTo(Knight o) {
            return power != o.power? power - o.power : idx - o.idx;
        }
    }

    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {br = new BufferedReader(new InputStreamReader(system));}
        public Scanner(String file) throws Exception {br = new BufferedReader(new FileReader(file));}
        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        public String nextLine()throws IOException{return br.readLine();}
        public int nextInt() throws IOException {return Integer.parseInt(next());}
        public double nextDouble() throws IOException {return Double.parseDouble(next());}
        public char nextChar()throws IOException{return next().charAt(0);}
        public Long nextLong()throws IOException{return Long.parseLong(next());}
        public boolean ready() throws IOException{return br.ready();}
        public void waitForInput() throws InterruptedException {Thread.sleep(3000);}
    }
}
