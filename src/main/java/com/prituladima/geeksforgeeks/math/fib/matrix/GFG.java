package com.prituladima.geeksforgeeks.math.fib.matrix;

import java.util.*;

/**
 * Created by prituladima on 8/10/18.
 */
public class GFG {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.valueOf(scanner.nextLine());

        List<Integer> store = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");

            calcAll(new Long(s[0]),
                    new Long(s[1]),
                    new Long(s[2]),
                    new Long(s[3]),
                    new Long(s[4]));

            //System.out.println(b);
        }

        // calcAll(2, 2, 2, 4, 1000);

        // calcAll(7, 4, 5, 67, 100000000);
        // calcAll(3, 3, 3, 3, 10000);
    }


    private static void calcAll(long a, long b, long c, long n, long m) {
        if (n <= 2) {
            System.out.println("1");
        }
//        long base[][] = getBase(a, b, c);
        long s[][] = null;
        long cur[][] = getBase(a, b, c);


        long nn = n - 2;
        while (nn > 0) {
            if (nn % 2 == 1) {
                s = multiple(cur, s, m);
            }
            cur = multiple(cur, cur, m);

            nn = nn >> 1;
        }

        System.out.println(multipleVector(s, 1, 1, m));

        //getN(a, b, c, n, m);
    }

    private static long[][] getBase(long a, long b, long c) {
        long s[][] = new long[3][3];
        s[0][0] = a;
        s[1][0] = b;
        s[2][0] = c;

        s[0][1] = 1;
        s[2][2] = 1;

        return s;
    }

    private static void getN(long a, long b, long c, long n, long m) {
        long f = 1;
        long f2 = 1;


        for (int i = 3; i <= n; i++) {
            long tmp = f2 * a % m + f * b % m + c % m;
            f = f2;
            f2 = tmp % m;
        }
        System.out.println(f2);
    }

    private static void print(long s[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(s[j][i] + ", ");
            }
            System.out.println();
        }
    }


    private static long[][] multiple(long a[][], long b[][], long m) {
        if (b == null) {
            return a;
        }
        if (a == null) {
            return b;
        }
        long ret[][] = new long[3][3];

        ret[0][0] = (a[0][0] * b[0][0]) % m + (a[1][0] * b[0][1]) % m + (a[2][0] * b[0][2]) % m;
        ret[0][1] = (a[0][1] * b[0][0]) % m + (a[1][1] * b[0][1]) % m + (a[2][1] * b[0][2]) % m;
        ret[0][2] = (a[0][2] * b[0][0]) % m + (a[1][2] * b[0][1]) % m + (a[2][2] * b[0][2]) % m;

        ret[1][0] = (a[0][0] * b[1][0]) % m + (a[1][0] * b[1][1]) % m + (a[2][0] * b[1][2]) % m;
        ret[1][1] = (a[0][1] * b[1][0]) % m + (a[1][1] * b[1][1]) % m + (a[2][1] * b[1][2]) % m;
        ret[1][2] = (a[0][2] * b[1][0]) % m + (a[1][2] * b[1][1]) % m + (a[2][2] * b[1][2]) % m;

        ret[2][0] = (a[0][0] * b[2][0]) % m + (a[1][0] * b[2][1]) % m + (a[2][0] * b[2][2]) % m;
        ret[2][1] = (a[0][1] * b[2][0]) % m + (a[1][1] * b[2][1]) % m + (a[2][1] * b[2][2]) % m;
        ret[2][2] = (a[0][2] * b[2][0]) % m + (a[1][2] * b[2][1]) % m + (a[2][2] * b[2][2]) % m;

        return ret;
    }

    private static long multipleVector(long a[][], long f2, long f, long m) {
        return (a[0][0] * f2 % m + a[1][0] * f % m + a[2][0] % m) % m;
    }

}
