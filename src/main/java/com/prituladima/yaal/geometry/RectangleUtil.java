package com.prituladima.yaal.geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

import static java.lang.Integer.max;
import static java.lang.Math.min;

public class RectangleUtil {

    public static class Rect {
        public int x1;
        public int y1;
        public int x2;
        public int y2;

        public Rect(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }


    public static Rect intersection(Rect a, Rect b) {
        if (a == null || b == null) {
            return null;
        }

        int x5 = max(a.x1, b.x1);
        int y5 = max(a.y1, b.y1);

        int x6 = min(a.x2, b.x2);
        int y6 = min(a.y2, b.y2);

        if (x5 > x6 || y5 > y6) {
            return null;
        }

        return new Rect(x5, y5, x6, y6);
    }






}
