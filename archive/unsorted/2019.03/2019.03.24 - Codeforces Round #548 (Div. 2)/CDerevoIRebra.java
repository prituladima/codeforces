package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;
import com.prituladima.yaal.numbers.IntegerUtils;

import java.util.*;

public class CDerevoIRebra {
    int t, n, k;
    long ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    long MOD = (long) 1e9 + 7;
    String YES = "Yes", NO = "No";
    int[][] tree;
    Map<Integer, Set<Integer>> g;
    Set<Integer> used = new HashSet<>();

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        k = in.nextInt();
        tree = new int[n - 1][3];
        g = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            g.put(i, new HashSet<>(1));//try 1
        }
        for (int i = 0; i < n - 1; i++) {
            tree[i][0] = in.nextInt();
            tree[i][1] = in.nextInt();
            tree[i][2] = in.nextInt();
            if (tree[i][2] == 0) {
                g.get(tree[i][0]).add(tree[i][1]);
                g.get(tree[i][1]).add(tree[i][0]);
            }
        }
        List<Integer> amounts = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
//            if (tree[i][2] == 1) {
            if (!used.contains(tree[i][0]))
                amounts.add(dfs(tree[i][0]));
            if (!used.contains(tree[i][1]))
                amounts.add(dfs(tree[i][1]));
//            }
        }

//        System.out.println(amounts);

        ans = 0;
        ans += IntegerUtils.power(n, k, MOD);

        for (Integer integer : amounts) {
            ans -= IntegerUtils.power(integer, k, MOD);
//            ans %= MOD;
            ans = IntegerUtils.trueMod(ans, MOD);
        }

        out.printLine(ans);
    }

    private int dfs(int from) {
        used.add(from);
        int am = 1;
        for (int to : g.get(from))
            if (!used.contains(to)) {
                am += dfs(to);
            }
        return am;
    }
}