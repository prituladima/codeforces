package com.prituladima.codeforce.contests.contest1099;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class COtkritka {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.nextToken();
        int k = in.nextInt();
        String imp = "Impossible";

        int qCounter = 0;
        int zCounter = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '?') {
                qCounter++;
            }
            if (c == '*') {
                zCounter++;
            }
        }


        if (s.length() - 2 * (qCounter + zCounter) > k) {
            out.print(imp);
            return;
        }

        if (zCounter == 0 && s.length() - qCounter < k) {
            out.print(imp);
            return;
        }

        int diff = k - (s.length() - (qCounter + zCounter));
        if (diff == 0) {
            out.print(s.replaceAll("\\?", "").replaceAll("\\*", ""));
            return;
        }

        char[] chars = s.toCharArray();
        if (diff < 0) {

            int j = -diff;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length && j > 0; i++) {
                if (chars[i] == '?' || chars[i] == '*') {
                    chars[i - 1] = '-';
                    j--;
                }
            }
            for (int i = 0; i < chars.length; i++) {
                if (Character.isAlphabetic(chars[i]))
                    sb.append(chars[i]);
            }
            out.print(sb.toString());

        } else {

            char[] filled = new char[diff];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '*') {
                    Arrays.fill(filled, chars[i - 1]);
                    break;
                }
            }
            boolean used = false;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '*' && !used) {
                    sb.append(filled);
                    used = true;
                }
                if (Character.isAlphabetic(chars[i]))
                    sb.append(chars[i]);
            }
            out.print(sb.toString());
        }
    }
}