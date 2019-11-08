package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class Penguins {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        Map<String, Integer> multiset = new HashMap<>();

        String mostNum = null;
        int count = 0;

        while (n-- > 0) {
            String s = in.readLine(true);
            multiset.merge(s, 1, Integer::sum);
            if (count < multiset.get(s)) {
                count = multiset.get(s);
                mostNum = s;
            }

        }


        out.println(mostNum);


    }
}