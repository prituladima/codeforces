package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

public class FinalStandings {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
//        List<IntIntPair> pairs = new ArrayList<>();
        List<Integer>[]  map = new ArrayList[102];
        for(int i = 0; i <= 100; i++) map[i] = new ArrayList<>(1);

        for (int i = 0 ; i < n ; i ++){
            IntIntPair pair = in.nextIntPair();
//            pairs.add(pair);
            map[pair.getSecond()].add(pair.getFirst());
        }

        List<IntIntPair> ans = new ArrayList<>();
        for (int second = 100; second >= 0 ; second--) {
            for(int first: map[second]){
                ans.add(new IntIntPair(first, second));
            }
        }

        //Collections.sort(pairs, Comparator.comparingInt(IntIntPair::getSecond).reversed().thenComparingInt(IntIntPair::getFirst));

        ans.forEach(out::println);
    }

}
