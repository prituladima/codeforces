package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class A380 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s = in.nextToken();
        int row = Integer.parseInt(s.substring(0, s.length()-1));
        char seat = s.charAt(s.length() - 1);
        if(seat == 'A'){
            out.println("window");
            return;
        }
        if(1 <= row && row <= 2){
            if(seat == 'D'){
                out.println("window");
            }else {
                out.println("aisle");
            }
        }else if(3 <= row && row <= 20){
            if(seat == 'F'){
                out.println("window");
            }else {
                out.println("aisle");
            }
        }else if(21 <= row){
            if(seat == 'K'){
                out.println("window");
            }else if(seat == 'C' || seat == 'H' || seat == 'D' || seat == 'G'){
                out.println("aisle");
            }else {
                out.println("neither");
            }

        }


        //        for(char c = 'A'; c <= 'K'; c++)
//            out.println(c);
    }
}
