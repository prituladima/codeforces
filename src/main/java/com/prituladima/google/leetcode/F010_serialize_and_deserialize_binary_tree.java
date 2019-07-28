package com.prituladima.google.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class F010_serialize_and_deserialize_binary_tree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        new F010_serialize_and_deserialize_binary_tree().run();
    }

    private void run() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        String serialize = serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = deserialize(serialize);

        String serialize2 = serialize(deserialize);
        System.out.println(serialize2);
    }


    // Encodes a tree to a single string.
    //"[1] [2,3] [3] [4,5]"

    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        dfs(root, stringBuilder);
        return stringBuilder.toString().trim();
    }

    private void dfs(TreeNode node, StringBuilder stringBuilder) {
        if (node == null) return;

        stringBuilder.append(node.val).append(' ');

        stringBuilder.append(node.left != null)
                .append(' ')
                .append(node.right != null).append(' ');

        dfs(node.left, stringBuilder);
        dfs(node.right, stringBuilder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] splited = data.split(" ");
        Queue<String> queue = new ArrayDeque<>();
        for (String s : splited) {
            queue.offer(s);
        }
        TreeNode superHead = new TreeNode(-1);
        superHead.left = new TreeNode(-1);
        build(superHead.left, splited, queue);
        return superHead.left;
    }

    private void build(TreeNode node, String[] arr, Queue<String> queue) {
        if (node == null) return;
        node.val = Integer.parseInt(queue.remove());
        if (Boolean.parseBoolean(queue.remove()))
            node.left = new TreeNode(-1);
        if (Boolean.parseBoolean(queue.remove()))
            node.right = new TreeNode(-1);
        build(node.left, arr, queue);
        build(node.right, arr, queue);
    }

//  [3] [true,true] [2] [true,false] [1] [false,false] [4] [false,false]
//  [3] [true,true] [2] [true,false] [1] [false,false] [4] [false,false]

}
