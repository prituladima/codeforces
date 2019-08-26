package com.prituladima.google.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        final Map.Entry<Object, Object> objectObjectEntry = new TreeMap<>().lowerEntry(null);
        System.out.println(new SplitArrayLargestSum().splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }

    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        long max = Long.MIN_VALUE;
        //put it to groups
        for(int i = 0; i < m; i++){
            max = Math.max(max, nums[i]);
        }
        //find group to merge
        for(int l = 0, r = m; r < n ; l++, r++){
            //find i way to merge array
            int merge = -1;
            long minSum = Long.MAX_VALUE;
            for(int j = l; j < r; j++){
                if(minSum > nums[j] + nums[j+1]){
                    minSum = nums[j] + nums[j+1];
                    merge = j;
                }
            }

            nums[merge+1] += nums[merge];
            if(nums[merge+1] < 0) throw new IllegalStateException();
            nums[merge] = 0;


            for(int j = merge; j > l; j--){
                nums[j] += nums[j-1];
                if(nums[j] < 0) throw new IllegalStateException();
                nums[j-1] = 0;
            }

            for(int i = l+1; i < r+1; i++){
                max = Math.max(max, nums[i]);
            }
        }
        return (int)max;
    }
}
