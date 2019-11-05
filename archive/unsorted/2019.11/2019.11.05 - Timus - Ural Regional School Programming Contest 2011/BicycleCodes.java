package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BicycleCodes {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        List<String> codes = new ArrayList<>();
        try {
            while (true) codes.add(in.nextToken());
        }catch (Exception e){}

        for (int i = 0; i < 10000; i++) {
            if(codes.get(i % codes.size()).equals(String.format("%04d", i ))){
                out.println("yes");
                return;
            }
        }

        out.println("no");
    }
}
