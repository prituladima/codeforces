package com.prituladima.geeksforgeeks.geometric_algorithms.lines;

import com.prituladima.geeksforgeeks.geometric_algorithms.lines.slope.*;
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
        if(n < 3) return n;

        int ans = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int sum = 2;
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {

                            //System.out.printf("%d %d %d\n", i, j, k);

                            Slope s1 = new Slope(x[i], y[i], x[j], y[j]);
                            Slope s2 = new Slope(x[j], y[j], x[k], y[k]);

                            if (s1.equals(s2)) {
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
