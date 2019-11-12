package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class Scholarship {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.nextInt();
        int[] a = in.nextIntArray(n);


        boolean all5 = true;
        int sum = 0;
        for(int i = 0; i < n ; i ++) {
            if(a[i] == 3){
                out.println("None");
                return;
            }
            all5 &= a[i] == 5;
            sum += a[i];
        }

        if(all5){
            out.println("Named");
            return;
        }

        double average = 1.0 * sum / n;
        if(average >= 4.5){
            out.println("High");
            return;
        }

        out.println("Common");

    }
}
