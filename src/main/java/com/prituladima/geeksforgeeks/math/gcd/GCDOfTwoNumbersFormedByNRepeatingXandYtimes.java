package com.prituladima.geeksforgeeks.math.gcd;

import java.util.Scanner;

public class GCDOfTwoNumbersFormedByNRepeatingXandYtimes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), x = scanner.nextInt(), y = scanner.nextInt();
        int gcd = gcd(x, y);

        for (int i = 0; i < gcd; i++) {
            System.out.print(n);
        }


    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
