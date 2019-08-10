package com.prituladima.google.leetcode;


// A Java program to implement Disjoint Set Data
// Structure.

import java.util.HashMap;
import java.util.Map;

class DisjointUnionSets {
    Map<String, Integer> data;
    int[] rank, parent;
    int n;

    // Constructor
    public DisjointUnionSets(int n) {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        data = new HashMap<>();
        makeSet();
    }

    boolean isInSameSet(String s1, String s2){
        return find(data.get(s1)) == find(data.get(s2));
    }

    // Creates n sets with single item in each
    void makeSet() {
        for (int i = 0; i < n; i++) {
            // Initially, all elements are in
            // their own set.
            parent[i] = i;
        }
    }

    int find(int x) {
        while (parent[x] != x) x = parent[x];
        return x;
    }

    void union(int x, int y) {
        // Find representatives of two sets
        int xRoot = find(x), yRoot = find(y);

        // Elements are in the same set, no need
        // to unite anything.
        if (xRoot == yRoot)
            return;

        // If x's rank is less than y's rank
        if (rank[xRoot] < rank[yRoot])

            // Then move x under y so that depth
            // of tree remains less
            parent[xRoot] = yRoot;

            // Else if y's rank is less than x's rank
        else if (rank[xRoot] > rank[yRoot])

            // Then move y under x so that depth of
            // tree remains less
            parent[yRoot] = xRoot;

        else // if ranks are the same
        {
            // Then move y under x (doesn't matter
            // which one goes where)
            parent[yRoot] = xRoot;

            // And increment the the result tree's
            // rank by 1
            rank[xRoot]++;
        }
    }
}

// Driver code
class Main {
    public static void main(String[] args) {
        // Let there be 5 persons with ids as
        // 0, 1, 2, 3 and 4
        int n = 5;
        DisjointUnionSets dus =
                new DisjointUnionSets(n);

        // 0 is a friend of 2
        dus.union(0, 2);

        // 4 is a friend of 2
        dus.union(4, 2);

        // 3 is a friend of 1
        dus.union(3, 1);

        // Check if 4 is a friend of 0
        if (dus.find(4) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");

        // Check if 1 is a friend of 0
        if (dus.find(1) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}