package com.prituladima.google.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76630/Evolve-from-brute-force-to-optimal-a-review-of-all-solutions
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76752/15-ms-accepted-java-soln-using-mergesort
 *
 */
// TODO: 30.08.2019  mergesort and Fenwick tree
public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {

        System.out.println(new CountOfSmallerNumbersAfterSelf().countSmaller(new int[]{5, 2, 6, 1}));

    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);
        List<Integer> index = new ArrayList<>(nums.length);

        for (int i = nums.length - 1; i >= 0; i--) {
            res.add(0);
            index.add(i);
        }

        countSmallerSub(nums, index, 1 << 31, res);

        return res;
    }

    private void countSmallerSub(int[] nums, List<Integer> index, int mask, List<Integer> res) {
        if (mask != 0 && index.size() > 1) {
            List<Integer> lowGroup = new ArrayList<>(index.size());
            List<Integer> highGroup = new ArrayList<>(index.size());

            int high = Math.max(0, mask);
            for (int ind : index) {
                if ((nums[ind] & mask) == high) {
                    res.set(ind, res.get(ind) + lowGroup.size());
                    highGroup.add(ind);
                } else {
                    lowGroup.add(ind);
                }
            }

            countSmallerSub(nums, lowGroup, mask >>> 1, res);
            countSmallerSub(nums, highGroup, mask >>> 1, res);
        }
    }
}
