package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class ReverseRoot {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        Deque<Double> deque = new ArrayDeque<>();
        try{
            while (true){
                long n = in.nextLong();
                deque.addFirst(Math.sqrt(n));
            }
        }catch (Exception e){

        }
        for (Double ans : deque)
        out.printf("%.4f\n", ans);

    }
}