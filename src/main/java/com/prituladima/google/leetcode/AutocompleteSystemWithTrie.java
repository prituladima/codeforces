package com.prituladima.google.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutocompleteSystemWithTrie {


    private static class Node implements Comparable<Node> {
        int times;
        String value;

        public Node(String value, int times) {
            this.times = times;
            this.value = value;
        }

        public int compareTo(Node n) {
            if (times == n.times) {
                return value.compareTo(n.value);
            } else {
                return Integer.compare(n.times, times);
            }
        }
    }

    static int AL_SIZE = 27;

    private static class Trie {
        int time;
        Trie[] children;

        public Trie() {
            children = new Trie[AL_SIZE];
        }
    }

    final Trie root;

    int ind(char c) {
        return c == ' ' ? 26 : c - 'a';
    }

    void insert(String s, int times) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        Trie cur = root;
        for (int i = 0; i < len; i++) {
            if (cur.children[ind(chars[i])] == null)
                cur.children[ind(chars[i])] = new Trie();
            cur = cur.children[ind(chars[i])];
        }
        cur.time += times;
    }

    List<Node> lookup(String s) {
        List<Node> ans = new ArrayList<>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        Trie cur = root;
        for (int i = 0; i < len; i++) {
            if (cur.children[ind(chars[i])] == null)
                return new ArrayList<>();
            cur = cur.children[ind(chars[i])];
        }
        traverse(s, cur, ans);
        return ans;
    }

    void traverse(String s, Trie cur, List<Node> ans) {
        if (cur.time > 0) ans.add(new Node(s, cur.time));
        for (char c = 'a'; c <= 'z'; c++) {
            if (cur.children[ind(c)] != null)
                traverse(s + c, cur.children[ind(c)], ans);
        }
        if (cur.children[26] != null)
            traverse(s + ' ', cur.children[26], ans);
    }


    public AutocompleteSystemWithTrie(String[] sentences, int[] times) {
        root = new Trie();
        int len = sentences.length;
        for (int i = 0; i < len; i++) {
            insert(sentences[i], times[i]);
        }
    }

    String cur_value = "";

    public List<String> input(char c) {
        if (c == '#') {
            insert(cur_value, 1);
            cur_value = "";
            return new ArrayList<>();
        }
        cur_value += c;
        List<Node> ans = lookup(cur_value);

        Collections.sort(ans);
        List<String> f_ans = new ArrayList<>();
        for (int i = 0; i < Math.min(3, ans.size()); i++) {
            f_ans.add(ans.get(i).value);
        }

        return f_ans;
    }

    public static void main(String[] args) {
//        ["AutocompleteSystem","input","input","input","input"]
//[[["i love you","island","iroman","i love leetcode"],[5,3,2,2]],["i"],[" "],["a"],["#"]]
        AutocompleteSystemWithTrie a = new AutocompleteSystemWithTrie(
                new String[]{"i love you", "island", "iroman", "i love leetcode"},
                new int[]{5, 3, 2, 2}
        );

        System.out.println(a.input('i'));
        System.out.println(a.input(' '));
        System.out.println(a.input('a'));
        System.out.println(a.input('#'));
    }

}


