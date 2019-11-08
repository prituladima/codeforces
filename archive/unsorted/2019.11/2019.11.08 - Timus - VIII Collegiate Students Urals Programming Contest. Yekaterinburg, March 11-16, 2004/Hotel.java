package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class Hotel {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[][] ans = new int[n][n];
        int pointer = 1;
        for (int i = n - 1; i >= 0; i--) {
            int curX = i;
            int curY = 0;
            while (curX < n && curY < n){
                ans[curY][curX] = pointer++;
                curX++;
                curY++;
            }
        }

        for (int j = 1; j < n; j++) {
            int curX = 0;
            int curY = j;
            while (curX < n && curY < n){
                ans[curY][curX] = pointer++;
                curX++;
                curY++;
            }
        }


        for (int i = 0; i < n; i++)
            out.println(ans[i]);
    }
}