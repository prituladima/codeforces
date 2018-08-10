package com.prituladima.geeksforgeeks.math.fib.matrix;

import java.util.*;

/**
 * Created by prituladima on 8/11/18.
 */
public class GFG2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            long n = sc.nextLong();
            long m = sc.nextLong();
            long arr[][] = {{a, b, 1}, {1, 0, 0}, {0, 0, 1}};
            long ans[][] = power(arr, n - 2, m);

            long base[][] = {{1}, {1}, {c}};

            System.out.println((ans[0][0] + ans[0][1] + (ans[0][2] * c) % m) % m);
        }
    }

    public static long[][] multi(long a[][], long b[][], long m) {
        long ans[][] = new long[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    ans[i][j] = (ans[i][j] + a[i][k] * b[k][j]) % m;
                }
            }
        }
        return ans;
    }

    public static long[][] multi1(long a[][], long b[][], long m) {
        long ans[][] = new long[3][1];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < 3; k++) {
                    ans[i][j] = (ans[i][j] + a[i][k] * b[k][j]) % m;
                }
            }
        }
        return ans;
    }

    public static long[][] power(long arr[][], long n, long m) {
        if (n == 1) {
            return arr;
        }
        if (n % 2 == 0) {
            long a[][] = power(arr, n / 2, m);
            long ans[][] = multi(a, a, m);
            return ans;
        } else {
            long a[][] = power(arr, n / 2, m);
            long b[][] = multi(a, a, m);
            long ans[][] = multi(b, arr, m);
            return ans;
        }
    }

}
