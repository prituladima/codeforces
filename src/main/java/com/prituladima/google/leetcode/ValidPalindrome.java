package com.prituladima.google.leetcode;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        char[] arr = s.toLowerCase().toCharArray();

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (isAlph(arr[l]) && isAlph(arr[r])) {
                if (arr[l] != arr[r]) return false;
                else {
                    l++;
                    r--;
                }
            } else if (isAlph(arr[l]) && !isAlph(arr[r])) {
                r--;
            } else if (!isAlph(arr[l]) && isAlph(arr[r])) {
                l++;
            } else {
                l++;
                r--;
            }
        }

        return true;
    }

    boolean isAlph(char c) {
        return (c <= 'z' && c >= 'a') || (c <= '9' && c >= '0');
    }
}
