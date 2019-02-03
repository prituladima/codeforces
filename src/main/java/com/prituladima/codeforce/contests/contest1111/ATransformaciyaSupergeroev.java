package com.prituladima.codeforce.contests.contest1111;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class ATransformaciyaSupergeroev {
    int n, m, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s, t;
    char[] chars, charsT;
    IntIntPair[] pairs, pairsAns;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        s = in.nextToken();
        chars = s.toCharArray();
        t = in.nextToken();
        charsT = t.toCharArray();

        if(s.length() != t.length()){
            out.printLine("No");return;
        }


        Set<Character> ovel = new HashSet<>();
        ovel.add('a');
        ovel.add('e');
        ovel.add('i');
        ovel.add('o');
        ovel.add('u');
        for (int i = 0; i < s.length(); i++) {
            if (ovel.contains(chars[i])) {
                chars[i] = '_';
            }else {
                chars[i] = '=';
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (ovel.contains(charsT[i])) {
                charsT[i] = '_';
            }else {
                charsT[i] = '=';
            }
        }

        if (new StringBuilder().append(chars).toString().equals(new StringBuilder().append(charsT).toString())) {
            out.printLine("Yes");return;
        }else {
            out.printLine("No");return;
        }


    }

}