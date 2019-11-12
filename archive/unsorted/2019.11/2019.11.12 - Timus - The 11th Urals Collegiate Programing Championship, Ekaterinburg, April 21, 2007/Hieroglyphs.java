package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class Hieroglyphs {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        List<String> hieroglyphs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            hieroglyphs.add(in.nextToken());
        }
        String s = in.nextToken();

        hieroglyphs
                .stream()
                .filter(str -> str.startsWith(s))
                .forEach(out::println);
    }
}
