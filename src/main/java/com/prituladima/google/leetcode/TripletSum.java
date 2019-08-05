package com.prituladima.google.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //we sort array for ability to skip same element be in answer twice
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;//skiping
            //who pointers in range [i + 1, len - 1]
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                //answer itself
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else //symetric rule
                    if (nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                    } else {
                        k--;
                    }
            }
        }
        return res;
    }


}
