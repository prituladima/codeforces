package com.prituladima.geeksforgeeks.math.fib;

public class LeonardoNumber {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(leonardo(i));
        }

    }


    static int leonardo(int n){

        //base case
        if(n == 0 || n == 1) return 1;


        int F = fib(n+1);


        return 2 * F - 1;
    }

    static int fib(int n){
        int[][] M = new int[][]{{1, 1},{1, 0}};

        pow(M, n-1);

        return M[0][0];
    }


    static void pow(int F[][], int n) {
        if (n == 0 || n == 1)
            return;
        int M[][] = new int[][]{{1, 1}, {1, 0}};

        pow(F, n / 2);
        multiply(F, F);

        if (n % 2 != 0)
            multiply(F, M);
    }

    static void multiply(int[][]F, int[][] M){
        int x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
        int y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
        int z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
        int w = F[1][0] * M[0][1] + F[1][1] * M[1][1];
        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

}
