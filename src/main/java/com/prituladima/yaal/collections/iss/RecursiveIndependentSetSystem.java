package com.prituladima.yaal.collections.iss;

import static java.util.Arrays.fill;

/**
 *
 */
public class RecursiveIndependentSetSystem implements IndependentSetSystem {
    private final int[] color;
    private final int[] rank;
    private int setCount;
    private Listener listener;

    public RecursiveIndependentSetSystem(int size) {
        color = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            color[i] = i;
        }
        setCount = size;
    }

    public void clear() {
        fill(rank, 0);
        for (int i = 0; i < color.length; i++) {
            color[i] = i;
        }
        setCount = color.length;
    }

    public RecursiveIndependentSetSystem(RecursiveIndependentSetSystem other) {
        color = other.color.clone();
        rank = other.rank.clone();
        setCount = other.setCount;
    }

    public boolean join(int first, int second) {
        first = get(first);
        second = get(second);
        if (first == second) {
            return false;
        }
        if (rank[first] < rank[second]) {
            int temp = first;
            first = second;
            second = temp;
        } else if (rank[first] == rank[second]) {
            rank[first]++;
        }
        setCount--;
        color[second] = first;
        if (listener != null) {
            listener.joined(second, first);
        }
        return true;
    }

    public int get(int index) {
        int start = index;
        while (color[index] != index) {
            index = color[index];
        }
        while (start != index) {
            int next = color[start];
            color[start] = index;
            start = next;
        }
        return index;
    }

    public int getSetCount() {
        return setCount;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
