package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class GKrasivayaGirlyanda {
    int t, n, m, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        s = in.nextToken();
        chars = s.toCharArray();
        if (chars.length == 1) {
            out.printLine(0);
            out.printLine(s);
        } else if (chars.length == 2) {
            if (chars[0] == chars[1]) {
                out.printLine(1);
                out.print(chars[0]);
                if (chars[0] == 'R') out.printLine('G');
                else if (chars[0] == 'G') out.printLine('R');
                else out.printLine('G');
            }else {
                out.printLine(0);
                out.printLine(s);
            }
        } else {
            Map<String, Integer> res = new HashMap<>();
            res.put("RGB", isok("RGB", chars));
            res.put("RBG", isok("RBG", chars));
            res.put("GRB", isok("GRB", chars));
            res.put("GBR", isok("GBR", chars));
            res.put("BRG", isok("BRG", chars));
            res.put("BGR", isok("BGR", chars));
            int min = Integer.MAX_VALUE;
            String minValue = null;
            for (String key : res.keySet()) {
                int value = res.get(key);
                if (value < min) {
                    min = value;
                    minValue = key;
                }
            }

            out.printLine(min);

            for (int i = 0; i < chars.length; i++) {
                out.print(minValue.charAt(i % 3));
            }
            out.printLine();


        }

    }

    private int isok(String s, char[] chars) {
        int ok = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] != s.charAt(i%3)) ok++;
        }

        return ok;
    }

}