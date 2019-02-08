package com.prituladima.codeforce.contests.contest1051;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class AVasyaIParol {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int t = in.nextInt();
        while (t-- > 0) {

            String s = in.nextToken();
            char[] chars = s.toCharArray();

            int dig = 0;
            int small = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                small += 'a' <= c && c <= 'z' ? 1 : 0;
                dig += '0' <= c && c <= '9' ? 1 : 0;
            }
            int big = s.length() - small - dig;
            if (small != 0 && big != 0 && dig != 0) {
                out.println(s);
                continue;
            }
            if (small == 0 && big != 0 && dig != 0) {
                for (int i = 0; i < chars.length; i++) {
                    if (big > dig) {
                        if ('A' <= chars[i] && chars[i] <= 'Z') {
                            chars[i] = 'a';
                            break;
                        }
                    } else {
                        if ('0' <= chars[i] && chars[i] <= '9') {
                            chars[i] = 'a';
                            break;
                        }
                    }
                }
            }
            if (small != 0 && big == 0 && dig != 0) {
                for (int i = 0; i < chars.length; i++) {
                    if (small > dig) {
                        if ('a' <= chars[i] && chars[i] <= 'z') {
                            chars[i] = 'A';
                            break;
                        }
                    } else {
                        if ('0' <= chars[i] && chars[i] <= '9') {
                            chars[i] = 'A';
                            break;
                        }
                    }
                }
            }
            if (small != 0 && big != 0 && dig == 0) {
                for (int i = 0; i < chars.length; i++) {
                    if (big > small) {
                        if ('A' <= chars[i] && chars[i] <= 'Z') {
                            chars[i] = '1';
                            break;
                        }
                    } else {
                        if ('a' <= chars[i] && chars[i] <= 'z') {
                            chars[i] = '1';
                            break;
                        }
                    }
                }
            }
            if (small == 0 && big == 0 && dig != 0) {
                chars[0] = 'a';
                chars[1] = 'A';
            }
            if (small == 0 && big != 0 && dig == 0) {
                chars[0] = 'a';
                chars[1] = '1';
            }
            if (small != 0 && big == 0 && dig == 0) {
                chars[0] = 'A';
                chars[1] = '1';
            }

            out.println(new StringBuilder().append(chars).toString());
            continue;
        }


    }

    private static boolean all(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isAlphabetic(s.charAt(i))) sum++;
        }
        return s.length() == sum;
    }

    private static boolean cn(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isAlphabetic(s.charAt(i))) return true;
        }
        return false;
    }
}
