package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class TitanRuinsHiddenEntrance {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);

        int maxAns = 0;
        int maxInd = -1;
        for(int i = 1; i < n - 1; i ++){
            int localAns = a[i-1] +a[i] + a[i+1];
            if(localAns > maxAns){
                maxAns = localAns;
                maxInd = i + 1;
            }
        }

        out.printf("%d %d", maxAns, maxInd);
    }
}
