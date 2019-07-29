package com.prituladima.google.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class F012_generate_parentheses {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            System.out.println(generateParenthesis(i, 0) + "\n\n\n\n");
    }

    public static List<String> generateParenthesis(int n, int deep) {
        if(cache.containsKey(n)) return cache.get(n);
        char[] chars = new char[deep];
        Arrays.fill(chars, '\t');
        final String space = String.valueOf(chars);
        System.out.println(space + "call for " + n);
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left : generateParenthesis(c, deep + 1)) {
                    for (String right : generateParenthesis(n - 1 - c, deep + 1)) {
                        System.out.println(space + "Concatenating " + "( " + left + " ) " + right);
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache.put(n, ans);
        return ans;
    }

    static HashMap<Integer, List<String>> cache = new HashMap<>();
}
