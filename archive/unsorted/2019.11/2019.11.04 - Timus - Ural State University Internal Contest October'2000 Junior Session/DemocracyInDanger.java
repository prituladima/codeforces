package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class DemocracyInDanger {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int K = in.nextInt();
        int[] a = in.nextIntArray(K);
        Arrays.sort(a);

        int ans = 0;
        for(int i = 0; i < (K + 2)/2; i++){
            ans += a[i]/2 + a[i]%2;
        }

        out.println(ans);

    }
}