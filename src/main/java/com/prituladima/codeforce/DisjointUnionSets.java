package com.prituladima.codeforce;

public class DisjointUnionSets {

    private int[] rank, parent;
    private int amount;

    public DisjointUnionSets(int amount) {
        this.rank = new int[amount];
        this.parent = new int[amount];
        this.amount = amount;
        for (int i = 0; i < amount; i++) {
            parent[i] = i;
        }
    }

    public boolean isInSameSet(int u, int v){
        return find(u) == find(v);
    }

    private int find(int x) {
        while (parent[x] != x) x = parent[x];
        return x;
    }

    public void union(int x, int y) {
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
        amount--;
    }

    public int getAmount() {
        return amount;
    }
}