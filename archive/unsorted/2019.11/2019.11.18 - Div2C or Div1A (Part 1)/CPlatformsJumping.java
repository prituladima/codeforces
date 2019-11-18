package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Arrays;

public class CPlatformsJumping {
    private String yes = "YES", no = "NO";

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.nextInt(), m = in.nextInt(), d = in.nextInt();
        int[] c = in.nextIntArray(m);
        int sumLen = Arrays.stream(c).sum();

        int[] rightMostIndex = new int[n];
        int pointer = 0;
        for (int i = n - sumLen; i < n; ) {
            rightMostIndex[i] = pointer + 1;
            for (int j = 0; j < c[pointer]; j++) {
                i++;
            }
            pointer++;
        }
//        out.println(Arrays.toString(rightMostIndex));

        int lastReached = 0;
        for (int i = 0; i < m; i++) {
            //move each block as close as possible to left
            int ind = i + 1;
            int indLocation = -1;
            for (int j = 0; j < n; j++) {
                if (rightMostIndex[j] == ind) {
                    indLocation = j + 1;
                }
            }

            //find position of platform i
            int canJumTo = lastReached + d;

            if (canJumTo >= indLocation) {
                out.println(yes);
                buildTheAnswer(rightMostIndex, c);
                for (int j = 0; j < n; j++)
                    out.printf("%d ", rightMostIndex[j]);
                out.println();
                return;
            } else {
                rightMostIndex[indLocation - 1] = 0;
                rightMostIndex[canJumTo - 1] = ind;
                lastReached = canJumTo + c[i] - 1;
            }

        }


        //check if we can jump from last to end
        //if yes
        if (lastReached + d >= n + 1) {
            out.println(yes);
            buildTheAnswer(rightMostIndex, c);
            for (int i = 0; i < n; i++)
                out.printf("%d ", rightMostIndex[i]);
            out.println();
        }

        //else no
        else {
            out.println(no);
        }

    }

    private void buildTheAnswer(int[] ans, int[] c) {
        int pointer = 0;
        for (int i = 0; i < ans.length; ) {
            if (ans[i] != 0) {
                int val = ans[i];
                for (int j = 0; j < c[pointer]; j++) {
                    ans[i] = val;
                    i++;
                }
                pointer++;
            } else {
                i++;
            }
        }
    }
}
