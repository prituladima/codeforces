package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FRaznoobraznayaGirlyanda {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        s = in.nextToken();
        chars = s.toCharArray();

        if (n == 1) {
            out.printLine(0);
            out.printLine(s);
        } else if (n == 2) {
            if (chars[0] != chars[1]) {
                out.printLine(0);
                out.printLine(s);
            } else {
                out.printLine(1);
                out.print(chars[0]);
                out.printLine(getAnother(chars[0]));
            }
        } else {
            List<StringBuilder> blocks = new ArrayList<>();
            StringBuilder current = null;
            char lastCharacter = '_';
            for (int i = 0; i < n; i++) {
                if (lastCharacter != chars[i]) {
                    lastCharacter = chars[i];
                    if (current != null) blocks.add(current);
                    current = new StringBuilder();
                }
                current.append(chars[i]);
            }
            blocks.add(current);
            int amount = 0;
            StringBuilder ans = new StringBuilder();

            for (int i = 0; i < blocks.size() - 1; i++) {
                StringBuilder stringBuilder = blocks.get(i);
                StringBuilder next = blocks.get(i+1);
                int length = stringBuilder.length();
                if(length % 2 == 1){
                    char[] local = stringBuilder.toString().toCharArray();
                    char nc = getAnother(local[0]);
                    for (int j = 1; j < local.length; j+=2) {
                        local[j] = nc;
                        amount++;
                    }
                    ans.append(local);
                }else {
                    char[] local = stringBuilder.toString().toCharArray();
                    char nc = getAnother(local[0], next.toString().toCharArray()[0]);
                    for (int j = 1; j < local.length; j+=2) {
                        local[j] = nc;
                        amount++;
                    }
                    ans.append(local);
                }
            }
            char[] local = blocks.get(blocks.size()-1).toString().toCharArray();
            char nc = getAnother(local[0]);
            for (int j = 1; j < local.length; j+=2) {
                local[j] = nc;
                amount++;
            }
            ans.append(local);

            out.printLine(amount);
            out.printLine(ans.toString());


        }

    }

    private char getAnother(char A) {
        if (A == 'R')
            return 'G';
        else if (A == 'G')
            return 'R';
        else
            return 'R';
    }

    private char getAnother(char A, char B) {
        if (A == B) return getAnother(A);

        if (A == 'R' && B == 'G') return 'B';
        if (A == 'G' && B == 'R') return 'B';

        if (A == 'B' && B == 'G') return 'R';
        if (A == 'G' && B == 'B') return 'R';

        if (A == 'R' && B == 'B') return 'G';
        if (A == 'B' && B == 'R') return 'G';
        throw new IllegalStateException();
    }

}