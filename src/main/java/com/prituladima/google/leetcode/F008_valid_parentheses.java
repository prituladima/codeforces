package com.prituladima.google.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class F008_valid_parentheses {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (deque.isEmpty()) {
                if (isClosed(c)) return false;
                else deque.addFirst(c);
            } else {
                char was = deque.getFirst();
                if (isClosed(c)) {
                    if (isMatch(was, c)) deque.removeFirst();
                    else return false;
                } else {
                    deque.addFirst(c);
                }
            }
        }
        return deque.isEmpty();
    }

    private boolean isMatch(char a, char b) {
        return (a == '(' && b == ')')
                ||
                (a == '{' && b == '}')
                ||
                (a == '[' && b == ']');
    }

    private boolean isOpened(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean isClosed(char c) {
        return c == ')' || c == '}' || c == ']';
    }
}
