package com.prituladima.codeforce.contests.contest926;

import com.prituladima.codeforce.GeekMath;
import com.prituladima.codeforce.InputReader;
import java.io.PrintWriter;
import java.util.Map;

public class BDobavlenieTochek {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] x = in.nextArr(n);

        GeekMath.save_sort(x);

        long ans = 0;

        int[] dist = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            dist[i] = x[i + 1] - x[i];
        }

        Map<Integer, Integer> ms = GeekMath.multiSet(dist);

        dist = GeekMath.toArray(ms.keySet());

        int gcd = GeekMath.gcd(dist);


        for (int i = 0; i < dist.length; i++) {
            ans += (dist[i] / gcd - 1) * ms.get(dist[i]);
        }

        out.print(ans);

    }
}
