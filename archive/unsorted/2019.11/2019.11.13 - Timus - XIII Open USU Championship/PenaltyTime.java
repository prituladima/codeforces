package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class PenaltyTime {

    private static final String no_chance = "No chance.", dirty_debug = "Dirty debug :(";

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int T1 = in.nextInt(), T2 = in.nextInt();
        int[] a = in.nextIntArray(10);

        int penalty = 0;
        for (int i : a) {
            penalty += 20 * i;
        }

        if(T1 <= T2 - penalty){
            out.println(no_chance);
        }else {
            out.println(dirty_debug);
        }

    }
}
