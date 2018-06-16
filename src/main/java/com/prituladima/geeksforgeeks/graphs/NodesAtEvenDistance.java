package com.prituladima.geeksforgeeks.graphs;

import java.util.*;

/**
 * @see "https://practice.geeksforgeeks.org/problems/nodes-at-even-distance/0"
 */
public class NodesAtEvenDistance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int N = scanner.nextInt();
            ArrayList<LinkedList<Integer>> graph = new ArrayList<>();
            boolean[] used = new boolean[N];

            for (int i = 0; i <= N - 1; i++) {
                graph.add(new LinkedList<>());
            }

            for (int i = 0; i <= N - 2; i++) {
                int xi = scanner.nextInt(), yi = scanner.nextInt();
                graph.get(xi - 1).push(yi - 1);
                graph.get(yi - 1).push(xi - 1);
            }

            int[] d = new int[N];
            dfs(graph, 0, used, d);
            int even = 0;
            int odd = 0;

            for (int i = 0; i < d.length; i++) {
                if (d[i] % 2 == 0)  even++ ;
                else odd++;
            }

            System.out.println(nC2(even) + nC2(odd));

        }


    }

    public static void dfs(ArrayList<LinkedList<Integer>> g, int from, boolean[] used, int[] d) {
        used[from] = true;
        for (int to: g.get(from)) {
            if (!used[to]) {
                d[to]=d[from]+1;
                dfs(g, to, used, d);
            }
        }
    }

    public static int nCr(int n, int r) {
        if(r > n) return 0;
        if (n == 0 && n == r) return 1;
        r = Math.min(r, n-r);

        int ans = 1;
        for (int i = 0; i <= r - 1; i++) {
            ans *= n - i;
            ans /= i + 1;
        }
        return ans;
    }

    public static int nC2(int n){
        return n*(n-1)/2;
    }


}
