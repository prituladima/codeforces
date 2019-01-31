package com.prituladima.codeforce.contests.contest1003;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Arrays;

import static java.lang.Math.min;

public class BSostavlenieBinarnoiStroki {
    int a, b, x, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        a = in.nextInt();
        b = in.nextInt();
        x = in.nextInt();
//        a = min(a, b);
//        b = max(a, b);
        if (a > b) {
            for (int i = 0; i < min(x / 2, b); i++) {
                out.print("01");
            }
            int j = a + b - 2 * min(x / 2, b);
            for (int i = 0; i < j; i++) {
                out.print("0");
            }
        }
        if (a < b) {
            for (int i = 0; i < min(x / 2, a); i++) {
                out.print("10");
            }
            int j = a + b - 2 * min(x / 2, a);
            for (int i = 0; i < j; i++) {
                out.print("1");
            }
        }
        if (a == b) {
            String res = "";
            for (int i = 0; i < x - x % 2; i++) {
                res += (i % 2 == 0 ? "10" : "01");
            }
            char[] chars = new char[a-x];
            Arrays.fill(chars, '1');
            String s = new StringBuilder().append(chars).toString();

            char[] chars2 = new char[b-x];
            Arrays.fill(chars, '0');
            String z = new StringBuilder().append(chars).toString();

            if (x % 2 == 0) {
                out.print(res);
            }else {

            }

        }

//        int sl = a + b;


        //        while ()

//        out.printLine(ans);
//        out.printPairList(pairsAns);


    }


}