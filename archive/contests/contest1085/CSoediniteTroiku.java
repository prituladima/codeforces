package com.prituladima.codeforce.contests.contest1085;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CSoediniteTroiku {


    private Set<Pair> set = new HashSet<>();

    private static class Pair {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Pair cpy() {
            return new Pair(x, y);
        }
    }


    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int[] A = in.nextArr(2);
        int[] B = in.nextArr(2);
        int[] C = in.nextArr(2);

        if ((A[0] - B[0]) * (A[0] - B[0]) + (B[1] - A[1]) * (B[1] - A[1]) <= (A[0] - C[0]) * (A[0] - C[0]) + (C[1] - A[1]) * (C[1] - A[1])) {
            trav(new Pair(A[0], A[1]), new Pair(B[0], B[1]));
            trav(new Pair(C[0], C[1]), new Pair(B[0], B[1]));

        } else {
            trav(new Pair(A[0], A[1]), new Pair(C[0], C[1]));
            trav(new Pair(B[0], B[1]), new Pair(C[0], C[1]));
        }

        int len = set.size();
        out.println(len);
        for (Pair pair : set) {
            out.println(pair.x + " " + pair.y);
        }
    }

    private void trav(Pair from, Pair to) {
        set.add(from.cpy());
        while (from.x != to.x) {
            if (from.x < to.x) {
                from.x++;
            } else {
                from.x--;
            }
            set.add(from.cpy());
        }
        while (from.y != to.y) {
            if (from.y < to.y) {
                from.y++;
            } else {
                from.y--;
            }
            set.add(from.cpy());
        }

        set.add(to.cpy());
    }
}