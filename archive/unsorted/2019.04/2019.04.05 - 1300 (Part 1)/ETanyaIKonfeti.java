package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class ETanyaIKonfeti {
    int t, n, m, k, ans;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";

    int[] prefSumEven;
    int[] prefSumOdd;
    int[] suffSumEven;
    int[] suffSumOdd;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        if (n < 2) {
            out.printLine(1);
            return;
        }
        a = in.nextIntArray(n);
        prefSumEven = new int[n];
        prefSumOdd = new int[n];
        suffSumEven = new int[n];
        suffSumOdd = new int[n];

        prefSumOdd[0] = a[0];
        for (int i = 1; i < n; i++) {
            int i1 = i + 1;
            if (i1 % 2 == 0) {
                prefSumEven[i] = prefSumEven[i - 1] + a[i];
                prefSumOdd[i] = prefSumOdd[i - 1];
            } else {
                prefSumEven[i] = prefSumEven[i - 1];
                prefSumOdd[i] = prefSumOdd[i - 1] + a[i];
            }
        }

        if (n % 2 == 0) {
            suffSumEven[n - 1] = a[n - 1];
        } else {
            suffSumOdd[n - 1] = a[n - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            int i1 = i + 1;
            if (i1 % 2 == 0) {
                suffSumEven[i] = suffSumEven[i + 1] + a[i];
                suffSumOdd[i] = suffSumOdd[i + 1];
            } else {
                suffSumEven[i] = suffSumEven[i + 1];
                suffSumOdd[i] = suffSumOdd[i + 1] + a[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (suffSumEven[1] == suffSumOdd[1]) {
                    ans++;
                }
            } else if (i == n - 1) {
                if (prefSumEven[n - 2] == prefSumOdd[n - 2]) {
                    ans++;
                }
            } else {
                if (prefSumOdd[i - 1] + suffSumEven[i + 1] == prefSumEven[i - 1] + suffSumOdd [i + 1]) {
                    ans++;
                }
            }
        }


        out.printLine(ans);
    }

}