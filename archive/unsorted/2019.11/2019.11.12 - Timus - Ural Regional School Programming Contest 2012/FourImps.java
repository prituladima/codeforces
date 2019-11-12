package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class FourImps {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt()%4;
        if(n == 0 || n == 3){
            out.println("black");
        }else {
            out.println("grimy");
        }
    }
}
