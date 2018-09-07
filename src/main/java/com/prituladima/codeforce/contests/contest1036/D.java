package com.prituladima.codeforce.contests.contest1036;

import com.prituladima.codeforce.InputReader;
import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, InputReader in, PrintWriter out) {


        int n = in.nextInt();
        int[] a = in.nextArr(n);

        int m = in.nextInt();
        int[] b = in.nextArr(m);


        long sum_a = 0;
        long sum_B = 0;
        for (int i = 0; i < n; i++) {
            sum_a += a[i];
        }
        for (int i = 0; i < m; i++) {
            sum_B += b[i];
        }

        if(sum_a != sum_B){
            out.print(-1);
        }else{
            int j = 0;
            int i = 0;

            int I_SUM = 0;
            for(; i < n && j < m; ){
                if(i == j){
                    i++;
                    j++;
                }else if(a[i] < b[j]){

                }


            }

        }



    }
}
