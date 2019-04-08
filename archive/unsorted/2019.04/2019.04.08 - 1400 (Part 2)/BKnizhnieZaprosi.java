package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

public class BKnizhnieZaprosi {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        t = in.nextInt();

        ArrayDeque<Integer> booksDeque = new ArrayDeque<>();
        List<Integer> questions = new ArrayList<>();
        ArrayDeque<Character> updates = new ArrayDeque<>();

        while (t-- > 0) {
            s = in.nextToken();
            if (s.equals("?")) {
                questions.add(in.nextInt());
            } else if (s.equals("L")) {
                booksDeque.addFirst(in.nextInt());
            } else if (s.equals("R")) {
                booksDeque.addLast(in.nextInt());
            }
//            if(!s.equals("?"))
            updates.addFirst(s.toCharArray()[0]);
        }

        int[] positionInTheEndLeft = new int[200_020];
        int[] positionInTheEndRight = new int[200_020];

        int pos = 0;
        int len = booksDeque.size();
        for (int val : booksDeque) {
            positionInTheEndLeft[val] = pos;
            positionInTheEndRight[val] = len - pos - 1;
            pos++;
        }

        int posLC = 0;
        int posRC = 0;

        while (!updates.isEmpty() && updates.getFirst() != '?') {
            if (updates.getFirst() == 'L') posLC++;
            else posRC++;
            updates.removeFirst();
        }

        int[] ansss = new int[questions.size()];
        for (int i = questions.size() - 1; i >= 0; i--) {
            if (!updates.isEmpty()) updates.removeFirst();

            int Q = questions.get(i);
            if (positionInTheEndLeft[Q] - posLC < positionInTheEndRight[Q] - posRC) {
                ansss[i] = positionInTheEndLeft[Q] - posLC;
            } else {
                ansss[i] = positionInTheEndRight[Q] - posRC;
            }
            while (!updates.isEmpty() && updates.getFirst() != '?') {
                if (updates.getFirst() == 'L') posLC++;
                else posRC++;
                updates.removeFirst();
            }
        }

        for (int i : ansss) {
            out.printLine(i);
        }

//        out.print('\n');


    }

}