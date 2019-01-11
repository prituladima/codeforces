package com.prituladima.stankevich.data_stractures.priority_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryHeap {

    /**
     * FIELDS
     */
    private int[] heap;
    private int actualSize;
    private int heapSize;

    /**
     * CONSTRUCTORS
     */
    public BinaryHeap() {
        this(7);
    }

    public BinaryHeap(int[] array) {
        this.heap = GeeksHeaps.heapify(array);
        this.actualSize = array.length;
        this.heapSize = heap.length;
    }

    public BinaryHeap(int heapSize) {
        this.actualSize = 0;
        this.heapSize = heapSize;
        this.heap = new int[heapSize];
        Arrays.fill(heap, Integer.MAX_VALUE);
    }

    /**
     * FUNCTION
     */
    public int get() {
        if (actualSize > 0)
            return heap[0];
        else
            throw new NoSuchElementException();
    }

    public void add(int value) {
        if (heapSize == actualSize)
            grow();
        heap[actualSize++] = value;
        if (actualSize > 1)
            GeeksHeaps.siftUp(heap, actualSize - 1);
    }

    public int delete() {
        int answer = get();
        int lastInTheHeap = heap[actualSize - 1];
        heap[0] = lastInTheHeap;
        heap[actualSize - 1] = Integer.MAX_VALUE;
        actualSize--;
        GeeksHeaps.siftDown(heap, 0);
        if (heapSize == ((actualSize + 1) << 1) - 1) {
            shrink();
        }
        return answer;
    }


    /**
     * INNER
     */
    private void grow() {
        heapSize = ((heapSize + 1) << 1) - 1;
        heap = Arrays.copyOf(heap, heapSize);
        Arrays.fill(heap, actualSize, heapSize, Integer.MAX_VALUE);
    }

    private void shrink() {
        heapSize = actualSize;
        heap = Arrays.copyOf(heap, heapSize);
        Arrays.fill(heap, actualSize, heapSize, Integer.MAX_VALUE);
    }

    /**
     * MERGE todo
     */
    public static BinaryHeap meld(BinaryHeap a, BinaryHeap b) {
        int[] heapA = a.heap;
        int[] heapB = b.heap;
        int sizeA = heapA.length;
        int sizeB = heapB.length;

        int[] concatAB = new int[sizeA + sizeB];
        System.arraycopy(heapA, 0, concatAB, 0, heapA.length);
        System.arraycopy(heapB, 0, concatAB, heapA.length, heapB.length);
        return new BinaryHeap(concatAB);
    }

    /**
     * FOR TEST
     */
    public int[] toArray() {
        return Arrays.copyOf(heap, actualSize);
    }

    public int[] toHeapArray() {
        return heap;
    }

    public String toString() {
        return Arrays.toString(toArray());
    }

    public String toNiceString() {
        return getString(heap, 0, "", true);
    }

    private static String getString(int[] tree, int index, String prefix, boolean isTail) {
        StringBuilder builder = new StringBuilder();

        int value = tree[index];
        builder.append(prefix + (isTail ? "└── " : "├── ") + value + "\n");
        List<Integer> children = null;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        if (leftIndex != Integer.MIN_VALUE || rightIndex != Integer.MIN_VALUE) {
            children = new ArrayList<Integer>(2);
            if (leftIndex != Integer.MIN_VALUE && leftIndex < tree.length) {
                children.add(leftIndex);
            }
            if (rightIndex != Integer.MIN_VALUE && rightIndex < tree.length) {
                children.add(rightIndex);
            }
        }
        if (children != null) {
            for (int i = 0; i < children.size() - 1; i++) {
                builder.append(getString(tree, children.get(i), prefix + (isTail ? "    " : "│   "), false));
            }
            if (children.size() >= 1) {
                builder.append(getString(tree, children.get(children.size() - 1), prefix
                        + (isTail ? "    " : "│   "), false));
            }
        }

        return builder.toString();
    }

    /**
     * ENDPOINT
     */
    public static void main(String[] args) {
        int[] array = new int[]{4, 4, 5, 6, 12, 17, 1, 5, 12};
        System.out.println(new BinaryHeap(array).toNiceString());
    }

}