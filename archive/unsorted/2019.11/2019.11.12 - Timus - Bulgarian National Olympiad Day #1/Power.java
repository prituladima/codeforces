package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

import static com.prituladima.geeksforgeeks.math.GeeksMath.bpow;

public class Power {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long N = in.nextInt(), M = in.nextInt(), Y = in.nextInt();

        List<Long> ans = new ArrayList<>();
        for(long X = 0; X < M; X++){
            if(bpow(X, N, M) == Y) ans.add(X);
        }

        if(ans.size() != 0)ans.forEach(i -> out.printf("%d ", i));
        else out.println(-1);
    }


}
