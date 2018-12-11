//package com.prituladima.codeforce.contests.contest1036;

import java.util.Arrays;
import java.util.Scanner;

public class p {


    static boolean[] sieve(int n) {
        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);

        sieve[0] = sieve[1] = false;

        for (int i = 2; i <= n; i++)
            if (sieve[i])
                for (int j = 2 * i ; j <= n; j += i)
                    sieve[j] = false;

        return sieve;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        boolean[] primes = sieve(1000000);
        int i = scanner.nextInt();

        int part1 = 2;
        int part2 = i - part1;

        while (primes[part1] || primes[part2]){
            part1++;
            part2--;
        }

        System.out.println(part1 + " " + part2);
    }
}
