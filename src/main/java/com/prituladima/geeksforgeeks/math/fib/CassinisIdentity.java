package com.prituladima.geeksforgeeks.math.fib;

import java.util.Scanner;

public class CassinisIdentity {

    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0){
            System.out.println((s.nextInt() & 1) == 0 ?  1 : -1 );
        }
    }
}