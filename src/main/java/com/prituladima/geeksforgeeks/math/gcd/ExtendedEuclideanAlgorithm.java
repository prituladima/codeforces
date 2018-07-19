package com.prituladima.geeksforgeeks.math.gcd;


/**
 * @see "https://www.geeksforgeeks.org/euclidean-algorithms-basic-and-extended/"
 */
public class ExtendedEuclideanAlgorithm {

    // extended Euclidean Algorithm
    public static int gcdExtended(int a, int b, int[] x)
    {
        // Base Case
        if (a == 0)
        {
            x[0] = 0;
            x[1] = 1;
            return b;
        }

        int[] t = {1,1}; // To store results of recursive call
        int gcd = gcdExtended(b%a, a,t);

        // Update t using results of recursive
        // call

        x[0] = t[1] - (b/a) * t[0];
        x[1] = t[0];



        return gcd;
    }

    // Driver Program
    public static void main(String[] args)
    {
        int[] x = new int[]{1,1};
        int a = 35, b = 15;
        int g = gcdExtended(a, b, x);
        System.out.println("gcd(" + a + " , " + b+ ") = " + g);
        System.out.println("Coefficients = "+x[0]+" "+x[1]);
    }

}
