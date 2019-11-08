package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class DonaldIsAPostman {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        Set<Character> set1 = new HashSet<>(Arrays.asList('A', 'P', 'O', 'R'));
        Set<Character> set2 = new HashSet<>(Arrays.asList('B', 'M', 'S'));
        Set<Character> set3 = new HashSet<>(Arrays.asList('D', 'G', 'J', 'K', 'T', 'W'));


        int steps = 0;
        int pos = 0;
        int t = in.nextInt();
        while (t-- > 0) {
            String name = in.nextToken();
            char i = name.charAt(0);

            if (set1.contains(i)) {
                steps += Math.abs(0 - pos);
                pos = 0;
            } else if (set2.contains(i)) {
                steps += Math.abs(1 - pos);
                pos = 1;
            } else if (set3.contains(i)) {
                steps += Math.abs(2 - pos);
                pos = 2;
            }
        }

        out.println(steps);

    }
}