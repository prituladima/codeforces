package com.prituladima.google.leetcode;

public class F002_median_of_two_sorted_arrays {
    public static void main(String[] args) {

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Simplifying sizes
        final int x = nums1.length;
        final int y = nums2.length;
        //Ensure m <= n
        //call itself when
        if (x > y) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = x;
        //Invariant (SUM of left partitions X and Y)
        final int invariantSum = (x + y + 1) >>> 1;
        while (low <= high) {
            //We are getting amount of elements on the left size in FIRST array;
            int leftPartitionX = (low + high) >>> 1;//value from 0 to x which are edge cases
            int leftPartitionY = invariantSum - leftPartitionX;//value from 0 to y which are edge cases

            int maxLeftX = (leftPartitionX == 0) ? Integer.MIN_VALUE : nums1[leftPartitionX - 1];
            int minRightX = (leftPartitionX == x) ? Integer.MAX_VALUE : nums1[leftPartitionX];

            int maxLeftY = (leftPartitionY == 0) ? Integer.MIN_VALUE : nums2[leftPartitionY - 1];
            int minRightY = (leftPartitionY == y) ? Integer.MAX_VALUE : nums2[leftPartitionY];

            //Main condition
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if (((x + y) & 1) == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = leftPartitionX - 1;
            } else {
                low = leftPartitionX + 1;
            }
        }

        //Arrays are probably not sorted
        throw new IllegalArgumentException();
    }
}
