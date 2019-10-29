package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class DVusTheCossackAndNumbers {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        double[] a = in.nextDoubleArray(n);
        int[] b = new int[n];
        int sum = 0;
        Set<Integer> ints = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if ((int) a[i] != a[i])
                b[i] = (int) (a[i] >= 0 ? a[i] : a[i] - 1);//???
            else {
                b[i] = (int) a[i];
                ints.add(i);
            }
            sum += b[i];
        }

        sum = -sum;
        for (int i = 0; i < sum; i++) {
            if(ints.contains(i)) sum++;
            else b[i]++;
        }

        for (int j : b) out.println(j);
    }

}