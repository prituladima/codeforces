package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class Taxi {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt(), d = in.nextInt();

        boolean driverTurn = false;
        while (a < c){
//            out.printf("%d %d\n", a, c);
            if(driverTurn){
                c = Math.max(c - d, a);
            }else {
                a = Math.min(a + b, c);
            }

            driverTurn = !driverTurn;
        }

        out.println(Math.max(a, c));
    }
}
