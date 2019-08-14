package com.prituladima.google.leetcode;

import java.util.*;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;

        int len = heights.length;
        Set<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            treeSet.add(heights[i]);
        }
        Iterator<Integer> it = treeSet.iterator();
        while (it.hasNext()) {
            final int curH = it.next();
            int maxW = 1;
            int curW = 0;
            for (int j = 0; j < len; j++) {
                if (heights[j] >= curH) curW++;
                else curW = 0;

                maxW = Math.max(maxW, curW);
            }
            ans = Math.max(ans, maxW * curH);

        }
        return ans;

    }

    public int largestRectangleArea2(int[] heights) {
        int ans = 0;
        int len = heights.length;
        Deque<Integer> stack = new LinkedList<>();

        int localAns;
        int i = 0;
        while (i < len) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                int top = stack.poll();
                if (stack.isEmpty()) {
                    localAns = heights[top] * i;
                } else {
                    localAns = heights[top] * (i - stack.peekFirst() - 1);
                }
                ans = Math.max(localAns, ans);
            }

        }

        while (!stack.isEmpty()) {
            int top = stack.poll();
            if (stack.isEmpty()) {
                localAns = heights[top] * i;
            } else {
                localAns = heights[top] * (i - stack.peekFirst() - 1);
            }
            ans = Math.max(localAns, ans);
        }


        return ans;

    }
}
