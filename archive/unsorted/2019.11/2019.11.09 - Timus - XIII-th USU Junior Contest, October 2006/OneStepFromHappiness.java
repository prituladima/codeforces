package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class OneStepFromHappiness {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int i = in.nextInt();
        int next = i + 1;
        int prev = i - 1;

        if(happy(next) || happy(prev)){
            out.println("Yes");
        }else {
            out.println("No");
        }
    }

    private boolean happy(int n){
        String s = String.format("%06d", n);
        return (int)s.charAt(0) + (int)s.charAt(1) + (int)s.charAt(2) == (int)s.charAt(3) + (int)s.charAt(4) + (int)s.charAt(5);
    }
}
