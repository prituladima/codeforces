package com.prituladima.geeksforgeeks.math.factorization;

import java.util.HashSet;
import java.util.Scanner;


/**
 * @see "https://practice.geeksforgeeks.org/problems/sphenic-number/0"
 */
public class SphenicNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- >0){
            System.out.println(isSphenic(scanner.nextLong()) ? 1 : 0);
        }
    }



    static boolean isSphenic(long n){
        HashSet<Long> set = new HashSet<>();
        int counter = 0;

        while(n % 2 == 0){
            set.add(2L);
            counter++;
            n /=2;
        }

        long f = 3;

        while (f *f  <= n){
            if(n % f == 0){
                set.add(f);
                counter ++;
                n /= f;
            }
            else
                f += 2;
        }


        if(n != 1)
        {
            set.add(n);
            counter++;
        }

        return set.size() == 3 && counter == 3;

    }



}
