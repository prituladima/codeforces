package com.prituladima.codeforce.contests;

import java.util.Scanner;

public class C_1_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long a = scanner.nextLong();
        System.out.println(((n + a - 1) / a) * ((m + a - 1) / a));

    }
}