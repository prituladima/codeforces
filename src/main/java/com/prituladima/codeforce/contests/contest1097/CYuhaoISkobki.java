package com.prituladima.codeforce.contests.contest1097;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CYuhaoISkobki {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        int correct = 0;
        while (n-- > 0) {
            String s = in.nextToken();
            int min = 0;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '(') count++;
                else count--;
                if(count < min) min = count;
            }
            if(min == 0){
                if(count == 0){
                    correct++;
                }else {
                    pos.add(count);
                }
            }else {
                if(min == count){
                    neg.add(count);
                }
            }

        }
        int[] poss = new int[500001];
        int[] negg = new int[500001];

        for (Integer i : neg) {
            negg[-i]++;
        }
        for (Integer i :pos) {
            poss[i]++;
        }
        int ans = 0;
        for (int i = 1; i < 500001; i++) {
            ans += Math.min(negg[i], poss[i]);
        }
        ans  += correct / 2;
        out.print(ans);
    }
}