package com.prituladima.google.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valToInd = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            if (valToInd.containsKey(target - nums[i]))
                return new int[]{valToInd.get(target - nums[i]), i};
            else
                valToInd.put(nums[i], i);

        throw new IllegalStateException();
    }
}