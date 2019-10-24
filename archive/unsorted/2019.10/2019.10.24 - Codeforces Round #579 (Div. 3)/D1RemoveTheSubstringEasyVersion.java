package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class D1RemoveTheSubstringEasyVersion {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        char[] s = in.nextToken().toCharArray();
        char[] t = in.nextToken().toCharArray();
        int ans = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = i; j <= s.length; j++) {
                char[] left = copyOfRange(s, 0, i);
                char[] right = copyOfRange(s, j, s.length);
                char[] posArray = (String.valueOf(left) + String.valueOf(right)).toCharArray();
                if(isSubSequence(t, posArray, t.length, posArray.length)){
                    int localAns = s.length - posArray.length;
                    ans = Math.max(ans, localAns);
                }

            }

        }

        out.println(ans);

    }

    private boolean isSubSequence(char str1[], char str2[], int m, int n) {
        int j = 0; // For index of str1 (or subsequence

        // Traverse str2 and str1, and compare current character
        // of str2 with first unmatched char of str1, if matched
        // then move ahead in str1
        for (int i = 0; i < n && j < m; i++)
            if (str1[j] == str2[i])
                j++;

        // If all characters of str1 were found in str2
        return (j == m);
    }
}