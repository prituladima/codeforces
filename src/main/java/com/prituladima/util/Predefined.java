package com.prituladima.util;

import java.util.*;

/**
 * Created by prituladima on 3/23/18.
 */
public class Predefined {

    public static long c = 0;

    public static long mod = 1000000007;
    public static int d;
    public static int p;
    public static int q;

    public static void nextGreater(long[] a, int[] ans)
    {

        Stack<Integer> stk = new Stack<>();
        stk.push(0);


        for(int i=1; i<a.length; i++)
        {

            if(!stk.isEmpty())
            {
                int s = stk.pop();
                while(a[s]<a[i])
                {
                    ans[s] = i;
                    if(!stk.isEmpty())
                        s = stk.pop();
                    else
                        break;
                }
                if(a[s]>a[i])
                    stk.push(s);
            }

            stk.push(i);

        }
        return;

    }

    public static void nextGreaterRev(long[] a, int[] ans)
    {

        int n = a.length;
        int[] pans = new int[n];
        Arrays.fill(pans, -1);
        long[] arev = new long[n];
        for(int i=0; i<n; i++)
            arev[i] = a[n-1-i];

        Stack<Integer> stk = new Stack<>();
        stk.push(0);


        for(int i=1; i<n; i++)
        {

            if(!stk.isEmpty())
            {
                int s = stk.pop();
                while(arev[s]<arev[i])
                {
                    pans[s] = n - i-1;
                    if(!stk.isEmpty())
                        s = stk.pop();
                    else
                        break;
                }
                if(arev[s]>arev[i])
                    stk.push(s);
            }

            stk.push(i);

        }

        //for(int i=0; i<n; i++)
        //System.out.print(pans[i]+" ");

        for(int i=0; i<n; i++)
            ans[i] = pans[n-i-1];



        return;

    }



    public static  int gcd(int p2, int p22)
    {
        if (p2 == 0)
            return (int) p22;
        return gcd(p22%p2, p2);
    }



    public static int findGCD(int arr[], int n)
    {
        int result = arr[0];
        for (int i=1; i<n; i++)
            result = gcd(arr[i], result);

        return result;
    }


    public static long lcm(int[] numbers) {
        long lcm = 1;
        int divisor = 2;
        while (true) {
            int cnt = 0;
            boolean divisible = false;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == 0) {
                    return 0;
                } else if (numbers[i] < 0) {
                    numbers[i] = numbers[i] * (-1);
                }
                if (numbers[i] == 1) {
                    cnt++;
                }
                if (numbers[i] % divisor == 0) {
                    divisible = true;
                    numbers[i] = numbers[i] / divisor;
                }
            }
            if (divisible) {
                lcm = lcm * divisor;
            } else {
                divisor++;
            }
            if (cnt == numbers.length) {
                return lcm;
            }
        }
    }
    public static long fact(long n) {

        long factorial = 1;
        for(int i = 1; i <= n; i++)
        {
            factorial *= i;
        }
        return factorial;
    }



    public static int lowerLimit(int[] a, int n) {
        int ans = 0;

        int ll = 0;
        int rl = a.length-1;
        //	System.out.println(a[rl]+" "+n);
        if(a[0]>n)
            return 0;
        if(a[0]==n)
            return 1;
        else if(a[rl]<=n)
            return rl+1;

        while(ll<=rl)
        {

            int mid = (ll+rl)/2;
            if(a[mid]==n)
            {
                ans = mid + 1;
                break;
            }

            else if(a[mid]>n)
            {
                rl = mid-1;

            }
            else
            {
                ans = mid+1;
                ll = mid+1;
            }
        }

        return ans;
    }


    public static long choose(long total, long choose){
        if(total < choose)
            return 0;
        if(choose == 0 || choose == total)
            return 1;
        return (choose(total-1,choose-1)+choose(total-1,choose))%mod;
    }

    public static int[] suffle(int[] a,Random gen)
    {
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            int ind = gen.nextInt(n-i)+i;
            int temp = a[ind];
            a[ind] = a[i];
            a[i] = temp;
        }
        return a;
    }

    public static int floorSearch(int arr[], int low, int high, int x)
    {
        if (low > high)
            return -1;

        if (x > arr[high])
            return high;
        int mid = (low+high)/2;


        if (mid > 0 && arr[mid-1] < x && x < arr[mid])
            return mid-1;

        if (x < arr[mid])
            return floorSearch(arr, low, mid-1, x);

        return floorSearch(arr, mid+1, high, x);
    }


    /*	public static void swap(int a, int b){
            int temp = a;
            a = b;
            b = temp;
        }
        */
    public static ArrayList<Integer> primeFactorization(int n)
    {
        ArrayList<Integer> a =new ArrayList<Integer>();
        for(int i=2;i*i<=n;i++)
        {
            while(n%i==0)
            {
                a.add(i);
                n/=i;
            }
        }
        if(n!=1)
            a.add(n);
        return a;
    }


    public static void sieve(boolean[] isPrime,int n)
    {
        for(int i=1;i<n;i++)
            isPrime[i] = true;

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2;i*i<n;i++)
        {
            if(isPrime[i] == true)
            {
                for(int j=(2*i);j<n;j+=i)
                    isPrime[j] = false;
            }
        }
    }

    public static int GCD(int a,int b)
    {
        if(b==0)
            return a;
        else
            return GCD(b,a%b);
    }

    public static long GCD(long a,long b)
    {
        if(b==0)
            return a;
        else
            return GCD(b,a%b);
    }

    public static void extendedEuclid(int A,int B)
    {
        if(B==0)
        {
            d = A;
            p = 1 ;
            q = 0;
        }
        else
        {
            extendedEuclid(B, A%B);
            int temp = p;
            p = q;
            q = temp - (A/B)*q;
        }
    }


    public static int lowerbound(ArrayList<Long> list, long n) {
        int i= Collections.binarySearch(list, n);
        if(i<0)
            i = -(i+2);
        return i;


    }
    public static int uperbound(ArrayList<Long> list, long n) {
        int i=Collections.binarySearch(list, n);
        if(i<0)
            i = -(i+1);
        return i;


    }






    public static long LCM(long a,long b)
    {
        return (a*b)/GCD(a,b);
    }

    public static int LCM(int a,int b)
    {
        return (a*b)/GCD(a,b);
    }

    public static int binaryExponentiation(int x,int n)
    {
        int result=1;
        while(n>0)
        {
            if(n % 2 ==1)
                result=result * x;
            x=x*x;
            n=n/2;
        }
        return result;
    }


    public static int[] countDer(int n)
    {
        int der[] = new int[n + 1];

        der[0] = 1;
        der[1] = 0;
        der[2] = 1;

        for (int i = 3; i <= n; ++i)
            der[i] = (i - 1) * (der[i - 1] + der[i - 2]);

        // Return result for n
        return der;
    }


    static long binomialCoeff(int n, int k)
    {
        long C[][] = new long[n+1][k+1];
        int i, j;

        // Calculate  value of Binomial Coefficient in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (j = 0; j <= Math.min(i, k); j++)
            {
                // Base Cases
                if (j == 0 || j == i)
                    C[i][j] = 1;

                    // Calculate value using previosly stored values
                else
                    C[i][j] = C[i-1][j-1] + C[i-1][j];
            }
        }

        return C[n][k];
    }

    public static long binaryExponentiation(long x,long n)
    {
        long result=1;
        while(n>0)
        {
            if(n % 2 ==1)
                result=result * x;
            x=(x%mod * x%mod)%mod;
            n=n/2;
        }
        return result;
    }

    public static int modularExponentiation(int x,int n,int M)
    {
        int result=1;
        while(n>0)
        {
            if(n % 2 ==1)
                result=(result * x)%M;
            x=(x*x)%M;
            n=n/2;
        }
        return result;
    }

    public static long modularExponentiation(long x,long n,long M)
    {
        long result=1;
        while(n>0)
        {
            if(n % 2 ==1)
                result=(result * x)%M;
            x=(x*x)%M;
            n=n/2;
        }
        return result;
    }

    public static int modInverse(int A,int M)
    {
        return modularExponentiation(A,M-2,M);
    }

    public static long modInverse(long A,long M)
    {
        return modularExponentiation(A,M-2,M);
    }

    public static boolean isPrime(int n)
    {

        if (n <= 1)  return false;
        if (n <= 3)  return true;

        if (n%2 == 0 || n%3 == 0)
            return false;

        for (int i=5; i*i<=n; i=i+6)
        {
            if (n%i == 0 || n%(i+2) == 0)
                return false;
        }

        return true;
    }



}
