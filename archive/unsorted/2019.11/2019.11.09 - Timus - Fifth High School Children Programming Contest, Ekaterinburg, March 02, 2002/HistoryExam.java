package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class HistoryExam {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        int m = in.nextInt();
        int[] b = in.nextIntArray(m);

        int ans = 0;
        for (int i = 0; i < m; i++) {
            int l = -1;
            int r = n;
            while (r - l > 1) {
                int mid = l + (r - l) / 2;
                if (a[mid] >= b[i]) {
                    r = mid;
                } else {
                    l = mid;
                }
            }

            //r
            if (r < n && a[r] == b[i]) ans++;

        }
        out.println(ans);

    }
}
