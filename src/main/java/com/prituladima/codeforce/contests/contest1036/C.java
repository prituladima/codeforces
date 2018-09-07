package com.prituladima.codeforce.contests.contest1036;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        long T = in.nextLong();

        while (T-- > 0) {

            long L = in.nextLong(), R = in.nextLong();
            out.println(amount_of_(R) - amount_of_(L - 1));
        }

    }

    long get_amount_of_numbers(long n, long VAL){
        long ans = 0;
        for(int i = 1; i <= n-1; i++){

            long half = 1;
            for(int j = 1; j <= i; j++){
                if(j == 1){
                    if(i == n){
                        half *= VAL;
                    }else
                    half *= 9;
                }else if(j >= i - 3 + 1){
                    half *=10;
                }else {
                    half *= 9;
                }
            }

            ans += half;
        }

        return ans;

    }

    long digits(long n){
        long amount = 0;
        while (n > 0){
            amount ++;
            n /= 10;
        }
        return amount;
    }

    long amount_of_(long n) {
        if(n <= 9999) return n;
        else {
            long di = digits(n) - 4;
            long ans = n - 9999;
            while (di-- > 0){
                ans -= ans/10;
            }
            return ans;
        }
//        return get_amount_of_numbers(digits(n), Long.parseLong(""+String.valueOf(n).charAt(0)));
    }
}
