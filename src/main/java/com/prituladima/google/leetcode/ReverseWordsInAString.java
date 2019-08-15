package com.prituladima.google.leetcode;

import java.util.Arrays;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null || s.trim().equals("")) {
            return "";
        }

        char[] chars = s.toCharArray();


        chars = removeLeadingSpaces(chars);
        int len = chars.length;

        int L = 0;
        for (int i = 0; i < len; i++) {

            if ((i == 0 && chars[i] != ' ') || (chars[i - 1] == ' ' && chars[i] != ' ')) {
                L = i;
            }

            if ((i == len - 1 && chars[i] != ' ') || (chars[i + 1] == ' ' && chars[i] != ' ')) {
                rev(chars, L, i);
            }
        }

        rev(chars, 0, len - 1);


        return String.valueOf(chars);
    }

    private char[] removeLeadingSpaces(char[] arr) {
        int p = 0;
        char last = ' ';
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ' || last != ' ') {
                last = arr[p++] = arr[i];
            }
        }
        if (last == ' ') p--;
        return Arrays.copyOf(arr, p);//semiinterval
    }

    private void rev(char[] arr, int l, int r) {

        for (; l < r; l++, r--) {
            char c = arr[l];
            arr[l] = arr[r];
            arr[r] = c;
        }
    }

}
