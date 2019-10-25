package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import static com.prituladima.codeforce.Geeks.save_sort;
import static com.prituladima.codeforce.Geeks.reverse;
import static com.prituladima.yaal.numbers.IntegerUtils.lcm;

public class CSaveTheNature {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int q = in.nextInt();
        while (q-- > 0) {
            int n = in.nextInt();
            int[] p = in.nextIntArray(n);
            int x = in.nextInt(), a = in.nextInt();
            int y = in.nextInt(), b = in.nextInt();
            long k = in.nextLong();

            save_sort(p);
            p = reverse(p);


            if (!isOk(p, n, x, a, y, b, k)) {
                out.println(-1);
            } else {
                int low = 1;
                int high = n;
                int ans = high;

                while (low <= high) {
                    int mid = (low + high) >>> 1;
                    boolean ok = isOk(p, mid, x, a, y, b, k);
                    if (ok) {
                        high = mid - 1;
                        ans = mid;
                    } else {
                        low = mid + 1;
                    }

                }

//                if(ans == 1650) out.printf("%d_%d\n", a, b);
//                else
                    out.println(ans);
            }
        }
    }

    private boolean isOk(int[] p, int n, int x, int a, int y, int b, long k) {


        long amountCC = n / (lcm(a , b));
        long amountA = n / a - amountCC;
        long amountB = n / b - amountCC;

//        for(int i = 1; i <= n; i ++){
//            if(i % a == 0 && i % b == 0) amountCC ++;
//            else if(i % b == 0) amountB ++;
//            else if(i % a == 0) amountA ++;
//        }

        int cc = (int)amountCC;
        int aa = (int)amountA;
        int bb = (int)amountB;


        int pointer = 0;
        long posAns = 0;

        while (cc-- > 0) posAns += p[pointer++] / 100 * (x + y);

        if (x > y) {
            while (aa-- > 0) posAns += p[pointer++] / 100 * (x);
            while (bb-- > 0) posAns += p[pointer++] / 100 * (y);
        } else {
            while (bb-- > 0) posAns += p[pointer++] / 100 * (y);
            while (aa-- > 0) posAns += p[pointer++] / 100 * (x);
        }

        return posAns >= k;
    }

}