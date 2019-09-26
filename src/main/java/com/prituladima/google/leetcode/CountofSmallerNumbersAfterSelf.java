package com.prituladima.google.leetcode;

import java.time.LocalDate;
import java.util.*;

public class CountofSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {

        NavigableSet<Integer> tree = new TreeSet<>(
                (x, y) -> {
                    if (Objects.equals(x, y)) return 1;
                    else return Integer.compare(x, y);
                }
        );
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {

            SortedSet<Integer> subTree = tree.subSet(Integer.MIN_VALUE, nums[i]);
            list.add(subTree.size());
            tree.add(nums[i]);
        }

        Collections.reverse(list);

//        Arrays.binarySearch()

        return list;
    }

    private void start (long number, LocalDate date, short scv, String... args){
        //your logic here
    }
}
