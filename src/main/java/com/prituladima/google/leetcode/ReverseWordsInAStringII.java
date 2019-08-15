package com.prituladima.google.leetcode;

public class ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int len = s.length;

        int l = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0 || s[i - 1] == ' ') l = i;
            else if (i == len - 1 || s[i + 1] == ' ') rev(s, l, i);
        }

        rev(s, 0, len - 1);
    }


    private void rev(char[] arr, int l, int r) {

        for (; l < r; l++, r--) {
            char c = arr[l];
            arr[l] = arr[r];
            arr[r] = c;
        }
    }
}
