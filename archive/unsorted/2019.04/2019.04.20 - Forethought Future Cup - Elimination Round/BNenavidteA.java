package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class BNenavidteA {
    int t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        s = in.nextToken().toCharArray();
        n = s.length;

        StringBuilder notA = new StringBuilder();
        int amountOfA = 0;
        for (int i = 0; i < n; i++) {
            notA.append(s[i] == 'a' ? "" : s[i]);
            if(s[i] == 'a') amountOfA++;
        }
        if(notA.length() == 0){
            out.printLine(String.valueOf(s));
            return;
        }


        if (notA.toString().length() % 2 == 1) {
            out.printLine(":(");
            return;
        }

        char[] notAArr = notA.toString().toCharArray();
        int nn = notAArr.length;
        boolean ok = true;
        for (int i = 0; i < nn / 2; i++) {
            ok &= notAArr[i] == notAArr[i + nn / 2];
        }
        if (!ok) {
            out.printLine(":(");
            return;
        }

        char[] half = new char[nn / 2];
        for (int i = 0; i < nn / 2; i++) {
            half[i] = notAArr[i];
        }

        StringBuilder RR = new StringBuilder();
        int last = -1;
        for (
                int i = n - 1; i >= 0; i--) {
            RR.append(s[i]);last = i;
            if (RR.length() == half.length) break;

        }

        if (!RR.reverse().toString().equals(String.valueOf(half))) {
            out.printLine(":(");
            return;
        }
        final String substring = String.valueOf(s).substring(0, last);
        for(int i = 0; i < substring.length(); i++){
            if(substring.charAt(i) == 'a') amountOfA --;
        }
        if(amountOfA != 0){
            out.printLine(":(");
        }
        else out.printLine(substring);

    }

}