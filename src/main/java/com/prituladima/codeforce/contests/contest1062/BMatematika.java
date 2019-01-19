package com.prituladima.codeforce.contests.contest1062;

import static com.prituladima.codeforce.GeekDP.Pair;

import com.prituladima.codeforce.InputReader;
import java.io.PrintWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;



public class BMatematika {
    final long MODULO = (long) 1e9 + 9;
    final int INF = (int) 1e9;
    long n, m;
    int[] a;
    long L, R;
    long ans;
    int min = INF, max = -INF;
    String s;
    private List<Pair> pairs = new ArrayList<>();

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        if(n == 1){
            out.printf("%d %d\n", n, 0);
            return;
        }

        List<LongIntPair> factorize = factorize(n);

        long ans = 1;
        long max = -INF;
        long min = INF;
        for (int i = 0; i < factorize.size(); i++) {
            ans *= factorize.get(i).first;
            max = Long.max(max, factorize.get(i).second);
            min = Long.min(min, factorize.get(i).second);
        }

        int pow = 0;
        long max1 = max;
        if(!isPowerOfTwo(max1) || max != min){
            max1 = nextPowerOf2(max1);
            pow++;
        }

        while (max1 % 2 == 0){
            max1 /= 2;
            pow++;
        }


        out.printf("%d %d\n", ans, pow);
    }
    static long nextPowerOf2(long n)
    {
        n--;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        n++;

        return n;
    }

    static boolean isPowerOfTwo (long x)
    {
        return x!=0 && ((x&(x-1)) == 0);

    }

    public static List<LongIntPair> factorize(long number) {
        List<LongIntPair> result = new ArrayList<>();
        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                int power = 0;
                do {
                    power++;
                    number /= i;
                } while (number % i == 0);
                result.add(LongIntPair.makePair(i, power));
            }
        }


        if (number != 1) {
            result.add(LongIntPair.makePair(number, 1));
        }
        return result;
    }

    public static class LongIntPair implements Comparable<LongIntPair> {
        public final long first;
        public final int second;

        public static LongIntPair makePair(long first, int second) {
            return new LongIntPair(first, second);
        }

        public LongIntPair(long first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            LongIntPair pair = (LongIntPair) o;

            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            int result = Long.hashCode(first);
            result = 31 * result + Integer.hashCode(second);
            return result;
        }

        @Override
        public String toString() {
            return "(" + first + "," + second + ")";
        }

        @SuppressWarnings({"unchecked"})
        public int compareTo(LongIntPair o) {
            int value = Long.compare(first, o.first);
            if (value != 0) {
                return value;
            }
            return Integer.compare(second, o.second);
        }
    }



}