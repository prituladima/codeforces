package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class ATheDoors {
    int t, n, m, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        array = in.nextIntArray(n);

        int lastIndexL = 0;
        int lastIndexR = 0;
        for (int i = 0; i < n; i++) {
            if(array[i] == 0){
                lastIndexL = i+1;
            }else {
                lastIndexR = i+1;
            }
        }

        out.printLine(Math.min(lastIndexL, lastIndexR));

    }

}