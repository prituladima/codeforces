package com.prituladima.geeksforgeeks.geometric_algorithms.lines;

import java.util.*;

import static java.util.stream.IntStream.range;

/**
 * Created by prituladima on 7/11/18.
 */
public class AmountOfPointOnTheSameLine {


    public static void main(String[] args) {
        new AmountOfPointOnTheSameLine().solve();
    }

    void solve() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];

            range(0, n).forEach(i -> x[i] = scanner.nextInt());
            range(0, n).forEach(i -> y[i] = scanner.nextInt());

            System.out.println(noOfPoints(x, y, n));
        }

    }


    int noOfPoints(int x[], int y[], int n) {
        int ans = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int sum = 2;
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {

                            System.out.printf("%d %d %d\n", i, j, k);

                            int A = y[i] - y[j];
                            int B = x[k] - x[i];
                            int C = y[k] - y[i];
                            int D = x[i] - x[j];

                            if (B == 0 && C == 0) {
                                sum++;
                                continue;
                            } else if (B == 0 || C == 0) {
                                continue;
                            }

                            if (D == 0 && A == 0) {
                                sum++;
                                continue;
                            } else if (A == 0 || D == 0) {
                                continue;
                            }


                            if (A * B == C * D) {
                                sum++;
                            }


                        }
                    }
                    ans = Math.max(ans, sum);
                }

            }
        }


        return ans;

    }


}
