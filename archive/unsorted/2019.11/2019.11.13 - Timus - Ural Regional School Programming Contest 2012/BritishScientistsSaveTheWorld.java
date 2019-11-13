package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class BritishScientistsSaveTheWorld {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.nextInt(), k=  in.nextInt();
        int[] b = new int[n];
        int[] g = new int[n];

        int sum = k;
        int sumB = 0;


        for(int i = 0 ; i < n ; i++){
            b[i] = in.nextInt();
            sum += b[i];
            g[i] = in.nextInt();
            sumB += g[i];
        }

        int ans = sum - 2*(n+1) - sumB;
        if(ans < 0){
            out.println("Big Bang!");
        }else {
            out.println(ans);
        }




    }
}
