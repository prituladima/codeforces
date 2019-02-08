package com.prituladima.codeforce.contests.contest1072;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;


public class DMinimalniiPut {
    int n, k;
    char[][] a;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        k = in.nextInt();


        if (k >= 2 * n - 1) {
            char[] ans = new char[2 * n - 1];
            Arrays.fill(ans, 'a');
            out.println(new StringBuilder().append(ans).toString());
            return;
        }

        a = new char[n][n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextToken().toCharArray();

        int[][] dp = new int[n][n];
        dp[0][0] = a[0][0] != 'a' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + (a[i][0] != 'a' ? 1 : 0);
            dp[0][i] = dp[0][i - 1] + (a[0][i] != 'a' ? 1 : 0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i - 1][j] < dp[i][j - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + (a[i][j] != 'a' ? 1 : 0));
                    break;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + (a[i][j] != 'a' ? 1 : 0));
                    break;
                }

//                if (a[i - 1][j] < a[i][j - 1])
//                    dp[i][j] = dp[i - 1][j]; + (a[i][j] != 'a' ? 1 : 0);
//                else if ()
//                    dp[i][j] = dp[i][j - 1]; + (a[i][j] != 'a' ? 1 : 0);

            }
        }

        if (dp[n - 1][n - 1] == k) {
            char[] ans = new char[2 * n - 1];
            Arrays.fill(ans, 'a');
            out.println(new StringBuilder().append(ans).toString());
            return;
        }

        int iMIN = Integer.MAX_VALUE;
        int jMIN = Integer.MAX_VALUE;
        char min = 'z';

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(0, dp[i][j] - k);
                if (dp[i][j] == 1) {
                    if (a[i][j] < min) {
                        iMIN = i;
                        jMIN = j;
                    }
                }
            }
        }


        StringBuilder ans = new StringBuilder();
        int i = iMIN;
        int j = jMIN;
        ans.append(a[i][j]);
        while (i < n - 1 || j < n - 1) {
            if (i == n - 1) {
                ans.append(a[i][j - 1]);
                j++;
                continue;
            }

            if (j == n - 1) {

                ans.append(a[i - 1][j]);
                i++;
                continue;
            }

            if (a[i - 1][j] < a[i][j - 1]) {
                ans.append(a[i - 1][j]);
                i++;
            } else {
                ans.append(a[i][j - 1]);
                j++;
            }
        }


        char[] chars = ans.reverse().toString().toCharArray();
        System.out.println(Arrays.toString(chars));
//        while (k-- > 0){
        for (int L = 0; L < chars.length; L++) {
            if (chars[L] != 'a' && k > 0) {
                chars[L] = 'a';
                k--;
            }
        }

        out.println(new StringBuilder().append(chars).toString());

//        }


    }

}