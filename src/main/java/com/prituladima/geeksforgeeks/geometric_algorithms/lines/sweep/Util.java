package com.prituladima.geeksforgeeks.geometric_algorithms.lines.sweep;


import static java.lang.Double.min;
import static java.lang.Math.abs;
import static java.lang.Math.max;

/**
 * Created by prituladima on 7/10/18.
 */
public class Util {

    public static final double EPS = 1E-9;

    public static boolean doIntersect(Segment a, Segment b) {
        return doIntersect(a.p, a.q, b.p, b.q);
    }

    public static boolean doIntersect(SPoint p1, SPoint q1, SPoint p2, SPoint q2) {
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        if (o1 != o2 && o3 != o4)
            return true;

        return o1 == 0 && onSegment(p1, q1, p2)
                ||
                o2 == 0 && onSegment(p1, q1, q2)
                ||
                o3 == 0 && onSegment(p2, q2, p1)
                ||
                o4 == 0 && onSegment(p2, q2, q1);

    }


    public static int orientation(SPoint p, SPoint q, SPoint r) {
        double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        return abs(val) < EPS ? 0 : val > 0 ? 1 : -1;
    }


    public static boolean onSegment(SPoint p, SPoint q, SPoint r) {
        return min(p.x, q.x) <= r.x && r.x <= max(p.x, q.x) && min(p.y, q.y) <= r.y && r.y <= max(p.y, q.y);
    }

}
