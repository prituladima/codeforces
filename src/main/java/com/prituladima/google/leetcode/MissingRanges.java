package com.prituladima.google.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 3, 50, 75};
        System.out.println(new MissingRanges().new Solution().findMissingRanges(arr, 0, 99));
    }

    class Solution {


        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            int len = nums.length;
            lower--;
            upper++;
            List<String> list = new ArrayList<>();
            if (len == 0) {
                list.add(getRange(lower, upper));
                return list;
            }
            if (lower + 1 < nums[0]) {
                list.add(getRange(lower, nums[0]));
            }

            for (int i = 0; i < len - 1; i++) {
                if (nums[i] + 1 < nums[i + 1]) {
                    list.add(getRange(nums[i], nums[i + 1]));

                }


            }

            if (nums[len - 1] < upper) {
                list.add(getRange(nums[len - 1], upper));
            }


            return list;


        }

        private String getRange(int low, int high) {
            if (low + 1 == (high - 1)) {
                return String.valueOf(low + 1);
            } else {
                return String.valueOf((low + 1) + "->" + (high - 1));
            }

        }

    }
}
