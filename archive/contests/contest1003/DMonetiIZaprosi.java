package com.prituladima.codeforce.contests.contest1003;

import com.prituladima.codeforce.GeekInteger;
import com.prituladima.codeforce.GeekLong;
import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class DMonetiIZaprosi {
    int t, n, q, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        q = in.nextInt();
        array = in.nextIntArray(n);
//
        Map<Integer, Integer> ms = GeekInteger.multiSet(array);

        while (q-- > 0) {
            int b = in.nextInt();
            if (b % 2 == 1) {
                out.printLine(-1);
            } else {
                char[] chars = Integer.toString(b, 2).toCharArray();
                int len = chars.length;
                int ans = 0;

                int[] sg = new int[32];
                for (int i = 0; i < chars.length; i++) {
                    int pow = len - 1 - i;
                    long mb = GeekLong.bpow(2, pow);
                    int amount = 1;
                    while (ms.get((int)mb) == null || ms.get((int)mb) < amount){
                        amount *= 2;
                        pow--;
                        mb /=2;
                        if(mb == 1) break;
                    }
                    sg[pow] += amount;
                }
                boolean ok = true;
                int sum = 0;
                for (int i = 0; i < sg.length; i++) {
                    if(sg[i] != 0){
                        int mb = (int)GeekLong.bpow(2, i);
                        ok &= ms.get(mb) != null && ms.get(mb) >= sg[i];
                    }
                    sum += sg[i];
                }
                if(ok)
                out.printLine(sum);
                else out.printLine(-1);
            }
        }

    }

}