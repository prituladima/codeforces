package com.prituladima.contests;

import java.util.Scanner;

public class C_964_B {

    public static void main(String[] args) {
        new C_964_B().solve();
    }

    C_964_B() {
    }

    private void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int T = scanner.nextInt();
        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            times[i] = scanner.nextInt();
        }

        int maxSum = 0;
        for (int time : times) {
            maxSum += Math.max(A, A + (C - B) * (T - time));
        }
        System.out.println(maxSum);

    }

}