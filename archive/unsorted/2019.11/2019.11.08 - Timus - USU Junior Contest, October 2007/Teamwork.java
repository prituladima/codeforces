package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class Teamwork {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);

        if(n == 1){
            out.printf("%d %d\n", 1, a[0]);
            return;
        }


        int curCounter = 1;
        int curValue = a[0];

        for(int i = 1; i < n; i ++){
            if(curValue == a[i]){
                curCounter++;
            }
            else {
                out.printf("%d %d ", curCounter, curValue);
                curCounter = 1;
                curValue = a[i];
            }
        }

        out.printf("%d %d", curCounter, curValue);



    }
}