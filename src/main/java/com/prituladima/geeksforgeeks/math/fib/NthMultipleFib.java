package com.prituladima.geeksforgeeks.math.fib;

import java.util.Scanner;

public class NthMultipleFib {


    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while (t-- > 0) {
            NthMultipleFib o = new NthMultipleFib();
            long n = s.nextLong();
            long k = s.nextLong();
            System.out.println(o.findPosition(k, n));
        }
    }


    public long findPosition(long k, long n) {
        long f1 = 0;
        long f2 = 1;
        long f3;

        int i = 2;
        while (true) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;

            if (f2 % k == 0) {
                return n * i;
            }
            i++;

        }
    }


}
