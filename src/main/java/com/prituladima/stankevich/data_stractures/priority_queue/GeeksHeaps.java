package com.prituladima.stankevich.data_stractures.priority_queue;

import java.util.Arrays;

public class GeeksHeaps {

    protected static int[] heapify(int[] array) {
        int heapSize = array.length;

        heapSize |= heapSize >> 1;
        heapSize |= heapSize >> 2;
        heapSize |= heapSize >> 4;
        heapSize |= heapSize >> 8;
        heapSize |= heapSize >> 16;

        int[] heap = new int[heapSize];

        Arrays.fill(heap, Integer.MAX_VALUE);

        for (int i = 0; i < array.length; i++) {
            heap[i] = array[i];
        }

        for (int i = heapSize / 2; i >= 0; i--)
            siftDown(heap, i);

        return heap;
    }

    protected static void siftDown(int[] heap, int index) {
        while (2 * index + 1 < heap.length) {
            int leftChildren = 2 * index + 1;
            int rightChildren = 2 * index + 2;
            int j = leftChildren;
            if (rightChildren < heap.length && heap[rightChildren] < heap[leftChildren])
                j = rightChildren;
            if (heap[index] <= heap[j])
                break;

            int buf = heap[index];
            heap[index] = heap[j];
            heap[j] = buf;

            index = j;

        }

    }

    protected static void siftUp(int[] heap, int index) {
        while (heap[index] < heap[getParent(index)]) {
            int buf = heap[getParent(index)];
            heap[getParent(index)] = heap[index];
            heap[index] = buf;
            index = getParent(index);
            if (index == 0) break;
        }
    }

    protected static int getParent(int index) {
        return (index - 1) >> 1;
    }

}
