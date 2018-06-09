package com.prituladima.codeforce.contests;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class C_926_A {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int from = sc.nextInt();
        int to = sc.nextInt();

        Set<Integer> set = new TreeSet<>();
        for (int xi = 0; xi <= 30; xi++)
            for (int yi = 0; yi <= 19; yi++) {
                int currentValue = pow(2, xi) * pow(3, yi);
                set.add(currentValue);
            }

        int r = 0;
        for (Integer c : set) {
            if (from <= c && c <= to){
                //System.out.println(c);
                r++;
            }
        }


        System.out.println(r);

    }

    static int pow(int a, int n) {
        if (n == 0)
            return 1;
        if (n % 2 == 1)
            return pow (a, n-1) * a;
        else {
            int b = pow (a, n/2);
            return b * b;
        }
    }

}