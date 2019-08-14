package com.prituladima.google.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {
    class MedianFinder {

        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            // Add to one of the heaps
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            // Rebalance
            if (maxHeap.size() > minHeap.size() + 1) {
                while (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.add(maxHeap.poll());
                }
            } else if (minHeap.size() > maxHeap.size() + 1) {
                while (minHeap.size() > maxHeap.size() + 1) {
                    maxHeap.add(minHeap.poll());
                }
            }
            if (minHeap.size() > maxHeap.size()) maxHeap.add(minHeap.poll());
        }

        public double findMedian() {
            if (minHeap.size() == maxHeap.size())
                return (minHeap.peek() + maxHeap.peek()) * 0.5;
            else
                return maxHeap.peek();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

}
