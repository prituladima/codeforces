package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class Chocolate2 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        if((n * m) % 2 != 0){
            out.println("[second]=:]");
        }else {
            out.println("[:=[first]");
        }
    }
}
