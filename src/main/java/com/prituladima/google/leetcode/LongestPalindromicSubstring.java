package com.prituladima.google.leetcode;

import java.util.Arrays;

public class LongestPalindromicSubstring {

    public String longestPalindromeN2(String sStr) {
        if (sStr == null || sStr.equals("")) {
            return "";
        }
        char[] s = sStr.toCharArray();
        int len = s.length;
        int[] ans = new int[]{0, 0};

        int maxAns = 1;
        //odd
        for (int i = 0; i < len; i++) {
            int localMax = 1;
            int l = i;
            int r = i;
            while (l - 1 >= 0 && r + 1 <= len - 1 && s[l - 1] == s[r + 1]) {
                localMax += 2;
                l--;
                r++;
            }
            if (localMax > maxAns) {
                maxAns = localMax;
                ans = new int[]{l, r};
            }
        }
        //even
        for (int i = 0; i < len - 1; i++) {
            if (s[i] != s[i + 1]) continue;
            int localMax = 2;
            int l = i;
            int r = i + 1;
            while (l - 1 >= 0 && r + 1 <= len - 1 && s[l - 1] == s[r + 1]) {
                localMax += 2;
                l--;
                r++;
            }
            if (localMax > maxAns) {
                maxAns = localMax;
                ans = new int[]{l, r};
            }
        }
        return String.valueOf(Arrays.copyOfRange(s, ans[0], ans[1] + 1));
    }

    public String longestPalindromeN3(String sStr) {
        if (sStr == null || sStr.equals("")) {
            return "";
        }
        char[] s = sStr.toCharArray();
        int len = s.length;
        int[] ans = new int[]{0, 0};

        for (int k = len; k >= 1; k--) {
            int[] local = findKPakidrome(k, s);
            if (local != null) {
                ans = local;
                break;
            }
        }
        return String.valueOf(Arrays.copyOfRange(s, ans[0], ans[1] + 1));
    }

    private int[] findKPakidrome(int k, char[] s) {
        int len = s.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i - j == k - 1 && ok(s, j, i)) {
                    return new int[]{j, i};
                }
            }
        }
        return null;
    }

    private boolean ok(char[] s, int l, int r) {
        for (int i = l, j = r; i < j; i++, j--) {
            if (s[i] != s[j]) return false;
        }
        return true;
    }
}
