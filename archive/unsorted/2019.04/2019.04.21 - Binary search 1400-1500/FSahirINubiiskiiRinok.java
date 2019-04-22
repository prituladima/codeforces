package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Arrays;

public class FSahirINubiiskiiRinok {


    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        long S = in.nextInt();
        long[] a = in.nextLongArray(n);
        int l = 1;
        int r = n;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (solve(mid, a) <= S) {
                l = mid+1;
                ans = mid;
            } else {
                r = mid -1;
            }
        }



//        private int theMostRightLess(int[] a, int last, int value) {
//            int start = 0;
//            int finish = last;
//            int res = -1;
//            while (start <= finish) {
//                int middle = (start + finish) >> 1;
//                if (a[middle] < value) {
//                    res = middle;
//                    start = middle + 1;
//                } else {
//                    finish = middle - 1;
//                }
//            }
//            return res;
//        }
//
        out.printLine(ans + " " + solve(ans, a));
    }

    private long solve(int k, long[] a) {
        long[] b = new long[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i] + (i + 1) * (long) k;
        }
        Arrays.sort(b);
        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans += b[i];
        }
        return ans;
    }


}