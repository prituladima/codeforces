package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class Spammer {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int N = in.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i <N ; i++)
            map.merge(in.nextToken(), 1, Integer::sum);

        for (String s : map.keySet()) {
            if(map.get(s) > 1) {
                out.println(s);
            }
        }

        
    }
}
