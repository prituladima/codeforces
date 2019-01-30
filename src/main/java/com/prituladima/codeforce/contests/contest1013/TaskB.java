package com.prituladima.codeforce.contests.contest1013;

import com.prituladima.codeforce.GeekInteger;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TaskB {
    int n;
    int x;
    int[] array;
    int[] arrayAns;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        x = in.nextInt();
        array = in.nextIntArray(n);
        arrayAns = new int[n];

        for (int i = 0; i < array.length; i++) {
            arrayAns[i] = (array[i] & x);
        }

        Map<Integer, Integer> ms = GeekInteger.multiSet(array);
        for (int key : ms.keySet()) {
            if (ms.get(key) > 1) {
                out.print(0);
                return;
            }
        }

        Map<Integer, Integer> ms2 = GeekInteger.multiSet(arrayAns);

//        if()


        boolean noAns = true;
        for (int i = 0; i < array.length; i++) {
            noAns &= ((array[i] & x) == array[i]);
        }
        if (noAns) {
            out.print(-1);
            return;
        }


        Set<Integer> set11 = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set11.add(array[i]);
        }
        Set<Integer> set22 = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            set11.remove(array[i]);
            if (set11.contains(array[i] & x)) {
                out.print(1);
                return;
            }
            set11.add(array[i]);
        }

        if (ms2.keySet().size() == n) out.print(-1);
        else
            out.printLine(2);

    }

}

