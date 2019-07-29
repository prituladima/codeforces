package com.prituladima.google.leetcode;

import java.util.HashMap;
import java.util.Map;

public class F011_subarray_sum_equals_k {
    public int subarraySum(int[] nums, int k) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0] == k ? 1 : 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            //if(map.contains(sum - k))
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }


        return count;




    }
}
