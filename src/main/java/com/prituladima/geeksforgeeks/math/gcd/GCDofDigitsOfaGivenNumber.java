package com.prituladima.geeksforgeeks.math.gcd;

import java.util.Scanner;

public class GCDofDigitsOfaGivenNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(gcdDigits(n));


    }

    static long gcdDigits(long n){
        long ans = 0;
        while (n > 0){
            ans = gcd(n % 10, ans);

            if (ans == 1)
                return 1;

            n /= 10;
        }
        return ans;
    }

    static long gcd (long a, long b){
        return b == 0 ? a : gcd(b, a%b);
    }

}