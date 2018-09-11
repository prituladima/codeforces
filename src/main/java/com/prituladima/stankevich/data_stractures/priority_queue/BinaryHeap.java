package com.prituladima.stankevich.data_stractures.priority_queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class BinaryHeap {

    /**
     * FIELDS
     */
    private int[] values;
    private int size;
    private int heapSize;


    /**
     * CONSTRUCTORS
     */
    public BinaryHeap(int[] array) {
        this.values = GeeksHeaps.heapify(array);
        this.size = array.length;
        this.heapSize = values.length;
    }

    public BinaryHeap(int bufferSize) {
        this.size = 0;
        this.heapSize = bufferSize;
        this.values = new int[bufferSize];
        Arrays.fill(values, Integer.MAX_VALUE);
    }

    /**
     * FUNCTION
     */
    public int findMin() {
        return values[0];
    }

    void insert(int value) {
        if (heapSize == size)
            grow();
        values[size++] = value;
        siftUp(size - 1);
    }

    int extractMin() {
        int min = values[0];
        int lastnTheHeap = values[size - 1];
        values[0] = lastnTheHeap;
        values[size - 1] = Integer.MAX_VALUE;
        siftDown(0);
        return min;
    }

    void deleteMin() {
        throw new UnsupportedOperationException();
    }

    void incriaseKey(int key) {
        throw new UnsupportedOperationException();
    }


    /**
     * INNER
     */
    private void grow() {
        int newHeapSize = heapSize + heapSize >> 1;
        values = Arrays.copyOf(values, newHeapSize);
    }

    private void siftDown(int index) {
        throw new UnsupportedOperationException();
    }

    private void siftUp(int index) {
        while (index < (index - 1) >> 1) {
            int buf = values[(index - 1) >> 1];
            values[(index - 1) >> 1] = values[index];
            values[index] = buf;
            index = (index - 1) >> 1;
        }
    }

    /**
     * MERGE
     */
    void merge(BinaryHeap a, BinaryHeap b) {
        throw new UnsupportedOperationException();
    }


    void meld(BinaryHeap a, BinaryHeap b) {
        throw new UnsupportedOperationException();
    }

    void split(BinaryHeap a, BinaryHeap b) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {

    }

}
