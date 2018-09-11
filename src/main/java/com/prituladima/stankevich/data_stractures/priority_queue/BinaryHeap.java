package com.prituladima.stankevich.data_stractures.priority_queue;

import java.util.*;

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
            siftUp(actualSize - 1);
    }

    public int delete() {
        int answer = get();
        int lastInTheHeap = heap[actualSize - 1];
        heap[0] = lastInTheHeap;
        heap[actualSize - 1] = Integer.MAX_VALUE;
        actualSize--;
        siftDown(0);
        if(heapSize == ((actualSize + 1) << 1) - 1){
            decrease();
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

    private void decrease() {
        heapSize = actualSize;
        heap = Arrays.copyOf(heap, heapSize);
        Arrays.fill(heap, actualSize, heapSize, Integer.MAX_VALUE);
    }

    private void siftDown(int index) {
        while (2 * index + 1 < heapSize) {
            int leftChildren = 2 * index + 1;
            int rightChildren = 2 * index + 2;
            int j = leftChildren;
            if (rightChildren < heapSize && heap[rightChildren] < heap[leftChildren])
                j = rightChildren;
            if (heap[index] <= heap[j])
                break;

            int buf = heap[index];
            heap[index] = heap[j];
            heap[j] = buf;

            index = j;

        }

    }

    private void siftUp(int index) {
        while (heap[index] < heap[parent(index)]) {
            int buf = heap[parent(index)];
            heap[parent(index)] = heap[index];
            heap[index] = buf;
            index = parent(index);
            if(index == 0) break;
        }
    }

    private int parent(int index) {
        return (index - 1) >> 1;
    }

    /**
     * MERGE todo
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


    /**
     * FOR TEST
     */
    public int[] toArray() {
        return Arrays.copyOf(heap, actualSize);
    }

    public String toString() {
        return Arrays.toString(toArray());
    }

    /**
     * ENDPOINT
     */
    public static void main(String[] args) {}

}