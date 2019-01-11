package com.prituladima.geeksforgeeks.math.factorization;

import java.util.Scanner;

/**
 * Created by prituladima on 8/5/18.
 *
 * @see "https://practice.geeksforgeeks.org/problems/perfect-numbers/0"
 */
public class PerfectNumber {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {

            int n = s.nextInt();

            if (n == 1) {
                System.out.println(0);
                continue;
            }

            int sum = 0;


            for (int i = 1; i * i <= n; i++) {

                if (n % i == 0) {

                    int f = n / i;

                    if (f == i) {
                        sum += i;
                    } else {

                        f = f == n ? 0 : f;
                        sum += i + f;
                    }

                }

            }

            System.out.println((sum == n) ? 1 : 0);

        }
    }

}
