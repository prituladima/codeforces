package com.prituladima.google.leetcode;

public class F009_meeting_rooms_ii {
    public int minMeetingRooms(int[][] intervals) {
        int inf = 0;
        for (int[] pair : intervals) {
            inf = Math.max(pair[1], inf);
        }
        inf += 10;
        int[] layers = new int[inf];
        for (int[] pair : intervals) {
            layers[pair[0]]++;
            layers[pair[1]]--;
        }
        int max = -inf;
        for (int i = 1; i < inf; i++) {
            layers[i] += layers[i - 1];
            max = Math.max(max, layers[i]);
        }
        return max;
    }
}
