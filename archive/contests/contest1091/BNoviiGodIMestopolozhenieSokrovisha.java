package com.prituladima.codeforce.contests.contest1091;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BNoviiGodIMestopolozhenieSokrovisha {

    public static class XYPoint {
        int x, y;

        public XYPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            XYPoint xyPoint = (XYPoint) o;
            return x == xyPoint.x &&
                    y == xyPoint.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
        }

        Map<XYPoint, Long> countex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                countex.merge(new XYPoint(x[i] + a[j], y[i] + b[j]), 1L, Long::sum);
            }
        }

        for (XYPoint xyPoint : countex.keySet()) {
            if (countex.get(xyPoint) == n) {
                out.println(xyPoint.x + " " + xyPoint.y);
                return;
            }
        }


    }
}
