package com.prituladima.codeforce.contests.contest1104;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;


public class DIgraSModulem {

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        while (true) {
            String s = in.nextToken();
            if (s.equals("start")) {
                out.printf("! %d\n", bs(in, out, 1, (int)1e9));
            }
            if (s.equals("mistake") || s.equals("end")) {
                return;
            }
        }

    }

    public int bs(InputReader in, PrintWriter out, int low, int high) {
        int index = (int) 1e9+1;
        while (low <= high) {
            int mid = (low + high) / 2;

//            if (mid < key) {
//                low = mid + 1;
//            } else if (mid > key) {
//                high = mid - 1;
//            } else if (mid == key) {
//                index = mid;
//                break;
//            }
        }
        return index;
    }

}