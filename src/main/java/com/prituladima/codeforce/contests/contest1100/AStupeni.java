package com.prituladima.codeforce.contests.contest1100;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AStupeni {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int n = in.nextInt(), k = in.nextInt();
        String s = in.nextToken();

        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
        }

        chars = new char[set.size()];
        int g = 0;
        for (char i : set) {
            chars[g++] = i;
        }
        Arrays.sort(chars);

        int oo = 1;
//        chars[]
        for (int i = 1; i < chars.length; i++) {
            if(chars[i] - chars[oo-1] >= 2){
                chars[oo++] = chars[i];
            }
        }
        chars = Arrays.copyOf(chars, oo);

//        chars.
        if(chars.length < k){
            out.print(-1);
            return;
        }

        int minW = Integer.MAX_VALUE;
        minW = 0;
        for (int i = 0; i <= Math.min(chars.length-1, k-1); i++) {
            minW += chars[i] - 'a' + 1;
        }

//        return;
//        for (int i = 0; i < chars.length; i++) {
//            int curW = 0;
//            for (int j = i; j < chars.length - 1; j++) {
//                char ch = chars[j];
//                curW += ch - 'a' + 1;
//                for (int p = j; p < chars.length; p++) {
//                    if (chars[p] - ch >= 2) {
//                        ch = chars[p];
//                        curW += ch - 'a' + 1;
//                    }
//                }
//            }
//            minW = Math.min(minW, curW);
//        }

        out.print(minW);
    }
}
