package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class LonesomeKnight {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int[][] steps = {
                {1, 2},
                {1, -2},
                {-1, 2},
                {-1, -2},

                {2, -1},
                {2, 1},
                {-2, -1},
                {-2, 1}
        };
        int N = in.nextInt();
        while (N-- > 0) {
            char[] ch = in.nextToken().toCharArray();
            int a = (ch[0] - 'a') + 1;
            int b = Integer.parseInt(String.valueOf(ch[1]));
//            out.printf("%d %d", a, b);
            int ans = 0;
            for(int[] step: steps){
                ans += canHit(a, b, step) ? 1 : 0;
            }
            out.println(ans);
        }
    }

    private boolean canHit(int a, int b, int[] step) {
        final int i = a + step[0];
        final int j = b + step[1];
        return 1 <= i && i <= 8 && 1 <= j && j <= 8;
    }
}
