package com.prituladima.codeforce.contests.contest1101;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class ENovayaRabotaPolikarpa {
    final long MODULO = (long) 1e9 + 9;
    final int INF = (int) 1e9;
    int x, y, h, w;
    //    int[] a;
//    long L, R;
//    int ans;
//    int min = INF, max = -INF;
    String s;
    int t;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        t = in.nextInt();
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

//        int maxH2 = Integer.MIN_VALUE;
//        int maxW1 = Integer.MIN_VALUE;
//
//
//        int minH = Integer.MAX_VALUE;
//        int minW = Integer.MAX_VALUE;
//
//        int minH2 = Integer.MAX_VALUE;
//        int minW1 = Integer.MAX_VALUE;


        while (t-- > 0) {

            s = in.nextToken();


            if (s.equals("+")) {
                x = in.nextInt();
                y = in.nextInt();

//                minH = Math.min(minH, x);
//
//                minW = Math.min(minW, y);

                if (x < y) {
                    int b = x;
                    x = y;
                    y = b;
                }

                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);


//                minH2 = Math.min(minH2, x);
//                minW1 = Math.min(minW1, y);
//
//                maxH2 = Math.max(maxH2, x);
//                maxW1 = Math.max(maxW1, y);


            } else {

                h = in.nextInt();
                w = in.nextInt();

                if(h < w){
                    int b = h;
                    h = w;
                    w = b;
                }

                if (h >= maxX && w >= maxY ) {
                    out.println("YES");

                } else {
                    out.println("NO");
                }

            }


//            out.println(ans);
        }

    }

}