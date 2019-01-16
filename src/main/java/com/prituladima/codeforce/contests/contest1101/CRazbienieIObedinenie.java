package com.prituladima.codeforce.contests.contest1101;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.sort;
import static java.util.Comparator.comparingInt;

public class CRazbienieIObedinenie {

    private class Trip {
        int i;
        int l;
        int r;

        public Trip(int i, int l, int r) {
            this.i = i;
            this.l = l;
            this.r = r;
        }

        public int getI() {
            return i;
        }

        public int getL() {
            return l;
        }

        public int getR() {
            return r;
        }
    }


    final long MODULO = (long) 1e9 + 9;
    final int INF = (int) 1e9;
    int n, m;
    int[] a;
    long L, R;
    int ans;
    int min = INF, max = -INF;
    String s;
    int t;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        t = in.nextInt();
        while (t-- > 0) {
            n = in.nextInt();

            List<Trip> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new Trip(i, in.nextInt(), in.nextInt()));
            }

            int[] ans = new int[n];
            sort(list, comparingInt(Trip::getL).thenComparing(Trip::getR));
            boolean trig = false;

            int maxR = Integer.MIN_VALUE;
            for (int i = 0; i < n - 1; i++) {
                maxR = Math.max(maxR, list.get(i).r);
                if (maxR < list.get(i + 1).l && !trig) {
                    trig = true;
                    ans[list.get(i).i] = 1;
                    if (i == n - 2) {
                        ans[list.get(i + 1).i] = 2;
                    }
                    continue;
                }
                if (!trig) ans[list.get(i).i] = 1;
                else ans[list.get(i).i] = 2;

                if (i == n - 2) {
                    ans[list.get(i + 1).i] = 2;
                }
            }

            if (!trig) {
                out.println(-1);
                continue;
            }


            for (int i = 0; i < ans.length; i++) {
                out.print(ans[i] + " ");
            }

            out.println();


        }

    }

}