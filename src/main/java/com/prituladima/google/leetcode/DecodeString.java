package com.prituladima.google.leetcode;

import javax.xml.stream.events.Characters;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DecodeString {

    public static void main(String[] args) {
        System.out.println(new DecodeString().new Solution().decodeString("3[a2[c]]"));
    }

    class Solution {

        public String decodeString(String s) {
            char[] chars = s.toCharArray();
            return getAnswerFor(chars, 0, s.length()).toString();
        }

        private StringBuilder getAnswerFor(char[] chars, int low, int high) {
            chars = Arrays.copyOfRange(chars, low, high);
            if (!String.valueOf(chars).contains("[")) {
                return new StringBuilder().append(chars);
            } else {
                StringBuilder sb = new StringBuilder();
                Deque<Integer> deque = new ArrayDeque<>();
                String number = "";
                for (int i = 0; i < chars.length; i++) {
                    if (deque.isEmpty()) {
                        if (Character.isDigit(chars[i])) {
                            number += chars[i] + "";
                        } else if (number.equals("")) {
                            sb.append(chars[i]);
                        }
                    }
                    if (chars[i] == '[') {
                        deque.push(i);
                    } else if (chars[i] == ']') {
                        int maybeLast = deque.poll();
                        if (deque.isEmpty()) {
                            StringBuilder inner = getAnswerFor(chars, maybeLast + 1, i);
                            for (int j = 0; j < Integer.parseInt(number); j++) {
                                sb.append(inner);
                            }
                            number = "";
                        }
                    }
                }
                return sb;
            }
        }
    }
}