package com.prituladima.stankevich.data_stractures.priority_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;
/**
 * @see "https://www.cs.usfca.edu/~galles/visualization/LeftistHeap.html"
 * @see "https://www.sanfoundry.com/java-program-implement-leftist-heap/"
 * @see "https://neerc.ifmo.ru/wiki/index.php?title=Левосторонняя_куча"
 * todo why LeftistHeap can be build from array in O(n)???
 * @see "http://web.onda.com.br/abveiga/capitulo5-ingles.pdf"
 * todo even slower
 */
public class LeftistHeap {

    public static class Node {
        public Node(int value) {
            this.value = value;
        }

        protected int value;
        protected int s;

        protected Node left;
        protected Node right;
    }

    protected Node root;

    public LeftistHeap() {
    }

    public int delete() {
        if (root == null)
            throw new NoSuchElementException();

        int value = root.value;
        root = meld(root.left, root.right);
        return value;
    }

    public int add_fast(int... values) {
        LinkedList<Node> queue = new LinkedList<>();
        for (int cur : values) {
            queue.addFirst(new Node(cur));
        }
        int amount_of_operation = 0;
        while (queue.size() > 1) {
            amount_of_operation++;
            queue.addLast(meld(queue.removeFirst(), queue.removeFirst()));
        }
        root = queue.removeLast();
        return amount_of_operation;
    }

    public void add(int... values) {
        for (int u : values) add(u);
    }

    public void add(int value) {
        root = meld(root, new Node(value));
    }

    public Node meld(Node x, Node y) {
        if (x == null) return y;
        if (y == null) return x;

        //Let's make x - root
        if (x.value > y.value) {
            Node temp = x;
            x = y;
            y = temp;
        }

        //Let's meld RIGHT side of current root and Y
        x.right = meld(x.right, y);

        if (x.left == null) {
            x.left = x.right;
            x.right = null;
        } else if (x.left.s < x.right.s) {
            Node temp = x.left;
            x.left = x.right;
            x.right = temp;
        }

        // since we know the right child has the lower s-value, we can just
        x.s = (x.right != null ? x.right.s : 0) + 1;

        return x;
    }

    @Override
    public String toString() {
        return toNiceString(root, 0, ' ');
    }

    public String toNiceString(Node current, int deep, char side) {
        if (current == null) return "";

        char[] range = new char[deep];
        Arrays.fill(range, '\t');

        return new StringBuilder()
                .append(range)
                .append(side)
                .append("[" + current.value + ":" + current.s + "]")
                .append('\n')
                .append(toNiceString(current.right, deep + 1, 'R'))
                .append(toNiceString(current.left, deep + 1, 'L')).toString();
    }

    public static void main(String[] args) {
        LeftistHeap leftistHeap = new LeftistHeap();

        int size = 10;
        int[] randomNumbers = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = r.nextInt(1000);
        }

        leftistHeap.add(randomNumbers);

        //heap property test


        System.out.println(leftistHeap);
    }

}