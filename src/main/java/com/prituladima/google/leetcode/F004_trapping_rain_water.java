package com.prituladima.google.leetcode;

import java.util.Arrays;

public class F004_trapping_rain_water {

    static int inf = (int) 1e6 + 10;
    // todo https://www.topcoder.com/community/competitive-programming/tutorials/range-minimum-query-and-lowest-common-ancestor/
    // TODO: 28.07.2019 MAKE Two pointers approach
    public static int trap(int[] height) {
        int len = height.length;
        if (len < 3) return 0;
        int ans = 0;
        for (int i = 1; i < len - 1; i++) {
            int maxLeft = Integer.MIN_VALUE;
            int maxRight = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i + 1; j < len; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.max(0, Math.min(maxLeft, maxRight) - height[i]);
        }
        return ans;
    }

    public static int trap2(int[] height) {
        int[] firtsAppearence = new int[inf];
        Arrays.fill(firtsAppearence, -1);
        int[] lastAppearence = new int[inf];
        Arrays.fill(lastAppearence, -1);
        long sumOfAll = 0;
        for (int i = 0; i < height.length; ++i) {
            sumOfAll += height[i];
        }

        for (int i = 0; i < height.length; ++i) {
            if (firtsAppearence[height[i]] == -1) {
                firtsAppearence[height[i]] = i;
            }
        }


        for (int i = height.length - 1; i >= 0; --i) {
            if (lastAppearence[height[i]] == -1) {
                lastAppearence[height[i]] = i;
            }
        }
        int index = -1;
        for (int i = lastAppearence.length - 1; i >= 0; --i) {
            if (lastAppearence[i] == -1 && index != -1) {
                lastAppearence[i] = index;
            } else if (lastAppearence[i] != -1) {
                index = lastAppearence[i];
            }

        }

        index = -1;
        for (int i = firtsAppearence.length - 1; i >= 0; --i) {
            if (firtsAppearence[i] == -1 && index != -1) {
                firtsAppearence[i] = index;
            } else if (firtsAppearence[i] != -1) {
                index = firtsAppearence[i];
            }

        }

        long sumOfLay = 0;
        for (int i = 1; i < inf; i++) {
            if (firtsAppearence[i] != -1 && lastAppearence[i] != -1) {
                sumOfLay += lastAppearence[i] - firtsAppearence[i] + 1;
            }
        }

//        Arrays.copyOf()
        return (int) (sumOfLay - sumOfAll);

    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{4, 2, 3}));
    }


}
