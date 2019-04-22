package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class HSotovayaSvyaz {
    int t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();

        a = in.nextIntArray(n);
        b = in.nextIntArray(m);

        int r = (int) 2e9 + 1;
        int L = 0;
        int R = (int) 2e9 + 1;
        while (L <= R) {
            int mid = (L + R) >>> 1;
            if (fine(mid)) {
                r = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        out.printLine(r);
    }

    private boolean fine(int r) {
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            int city = a[i];
            ok &= r >= Math.abs(city - findClosest(b, m, city));
            if (!ok) return false;
        }
        return true;
    }

    private int findClosest(int arr[], int n, int target) {
        // Corner cases
        if (target <= arr[0])
            return arr[0];
        if (target >= arr[n - 1])
            return arr[n - 1];

        // Doing binary search
        int i = 0, j = n, mid = 0;
        while (i < j) {
            mid = (i + j) / 2;

            if (arr[mid] == target)
                return arr[mid];

        /* If target is less than array element,
            then search in left */
            if (target < arr[mid]) {

                // If target is greater than previous
                // to mid, return closest of two
                if (mid > 0 && target > arr[mid - 1])
                    return getClosest(arr[mid - 1],
                            arr[mid], target);

                /* Repeat for left half */
                j = mid;
            }

            // If target is greater than mid
            else {
                if (mid < n - 1 && target < arr[mid + 1])
                    return getClosest(arr[mid],
                            arr[mid + 1], target);
                // update i
                i = mid + 1;
            }
        }

        // Only single element left after search
        return arr[mid];
    }

    private int getClosest(int val1, int val2, int target) {
        if (target - val1 >= val2 - target)
            return val2;
        else
            return val1;
    }
}