package com.prituladima.google.leetcode;

class Trie {

    int AL = 'z' - 'a' + 1;

    private int ind(char ch) {
        return ch - 'a';
    }

    private class TrieNode {
        TrieNode[] children;
        boolean end;

        TrieNode() {
            children = new TrieNode[AL];
        }
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] charsWord = word.toCharArray();
        int len = word.length();
        TrieNode current = root;
        for (int i = 0; i < len; i++) {
            if (current.children[ind(charsWord[i])] == null) {
                current.children[ind(charsWord[i])] = new TrieNode();
            }
            current = current.children[ind(charsWord[i])];
        }
        current.end = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] charsWord = word.toCharArray();
        int len = word.length();
        TrieNode current = root;
        for (int i = 0; i < len; i++) {
            if (current.children[ind(charsWord[i])] == null) {
                return false;
            }
            current = current.children[ind(charsWord[i])];
        }
        return current.end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] charsWord = prefix.toCharArray();
        int len = prefix.length();
        TrieNode current = root;
        for (int i = 0; i < len; i++) {
            if (current.children[ind(charsWord[i])] == null) {
                return false;
            }
            current = current.children[ind(charsWord[i])];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */