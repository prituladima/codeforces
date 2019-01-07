package com.prituladima.codeforce.contests.contest1084;

import com.prituladima.codeforce.GeekMath;
import com.prituladima.codeforce.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BKvasIOrehus {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long n = in.nextLong(), s = in.nextLong();
        long[] v = in.nextArrL((int)n);

        long sum = Arrays.stream(v).sum();
        if(sum < s){
            out.println(-1);
            return;
        }

        List<Long> list = Arrays.stream(v).boxed().collect(Collectors.toList());
        Collections.sort(list);

        for (long i = 0; i < n; i++) {
            v[(int)i] = list.get((int)i);
        }

//        int k = (int)n;
        long temp_sum = 0;
        long min = v[0];
        for (int i = 0; i < v.length; i++) {
            temp_sum += v[i] - min;
        }

        if (temp_sum < s){
                min-= GeekMath.ceiling(s - temp_sum, n);
//                temp_sum += n;
        }

        out.println(min);


    }
}
