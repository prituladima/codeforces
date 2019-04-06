package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class BAlenaIUzkiiHolodilnik {
    int INF = Integer.MAX_VALUE;
    int t, n, m, k, ans, h;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        h = in.nextInt();
        array = in.nextIntArray(n);
        if(n != 1) {
            List<Integer> list = new ArrayList<>();
            ans = 0;
            list.add(array[0]);
            list.add(array[1]);
            ans = 2;
            for (int i = 2; i < array.length; i++) {
                list.add(array[i]);
                list.sort(Comparator.reverseOrder());
                int HH = 0;
                for (int j = 0; j < list.size(); j+=2) {
                    HH += list.get(j);
                }
                if(HH > h) break;
                else ans++;
            }
            out.printLine(ans);
        }else {
            out.printLine(1);
        }


    }

}