package com.prituladima.codeforce;

import com.prituladima.yaal.greedy.SubArraysWithGivenLenIterator;
import com.prituladima.yaal.greedy.Tuple;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class DConvenientForEverybody {

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        final int n = in.nextInt();
        final int[] a = in.nextIntArray(n);
        final int s = in.nextInt();
        final int f = in.nextInt();

        if (true) {
            final List<Tuple<Integer, Integer, Long>> allSubArrays = new SubArraysWithGivenLenIterator(a, f - s, true)
                    .stream()
                    .collect(Collectors.toList());

            final long maxLong = allSubArrays
                    .stream()
                    .mapToLong(Tuple::getZ)
                    .max()
                    .getAsLong();

            final int minTime = allSubArrays.stream()
                    .filter(tuple -> tuple.getZ() == maxLong)
                    .mapToInt(Tuple::getX)
                    .map(ans -> {
                        int local = s - ans;
                        if (local <= 0) local += n;
                        return local;
                    })
                    .min()
                    .getAsInt();

            out.printLine(minTime);
        }
        if (false) {
            final int len = f - s;

            long maxSum;
            long curSum = 0;
            for (int i = n - 1; i >= n - len; i--) {
                curSum += a[i];
            }
            maxSum = curSum;
            for (int i = n - len - 1; i >= 0; i--) {
                curSum -= a[i + len];
                curSum += a[i];
                maxSum = Math.max(maxSum, curSum);
            }
            for (int i = n - 1; i >= n - len; i--) {
                curSum -= a[(i + len) % n];
                curSum += a[i];
                maxSum = Math.max(maxSum, curSum);
            }

            ArrayList<Integer> allLefts = new ArrayList<>();
            curSum = 0;
            for (int i = n - 1; i >= n - len; i--) {
                curSum += a[i];
            }
            if (maxSum == curSum) {
                allLefts.add(n - len);
            }
            for (int i = n - len - 1; i >= 0; i--) {
                curSum -= a[i + len];
                curSum += a[i];
                if (maxSum == curSum) {
                    allLefts.add(i);
                }
            }
            for (int i = n - 1; i >= n - len; i--) {
                curSum -= a[(i + len) % n];
                curSum += a[i];
                if (maxSum == curSum) {
                    allLefts.add(i);
                }
            }
            int minAns = Integer.MAX_VALUE;
            for (int ans : allLefts) {
                int local = s - ans;
                if (local <= 0) local += n;
                minAns = Math.min(minAns, local);
            }

            out.printLine(minAns);
        }
    }



    @FunctionalInterface
    private interface TripleConsumer {
        void accept(int L, int R, long val);
    }


}