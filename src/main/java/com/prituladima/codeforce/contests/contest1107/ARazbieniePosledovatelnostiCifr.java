package com.prituladima.codeforce.contests.contest1107;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class ARazbieniePosledovatelnostiCifr {
    int t, n, m, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "YES", NO = "NO";
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        t = in.nextInt();
        while (t-- > 0) {
            n = in.nextInt();
            s = in.nextToken();
            chars = s.toCharArray();

            if(n == 2 && chars[0] >= chars[1]){
                out.printLine(NO);
                continue;
            }
            out.printLine("YES");
            out.printLine(2);
            out.print(chars[0]);
            out.print(' ');
            for (int i = 1; i < n; i++) {
                out.print(chars[i]);
//                out.print(' ');

            }

            out.printLine();
        }
    }

}