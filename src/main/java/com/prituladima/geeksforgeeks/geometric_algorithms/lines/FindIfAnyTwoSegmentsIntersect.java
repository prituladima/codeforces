package com.prituladima.geeksforgeeks.geometric_algorithms.lines;

import com.prituladima.geeksforgeeks.geometric_algorithms.lines.sweep.*;
import java.util.*;

import static com.prituladima.geeksforgeeks.geometric_algorithms.lines.sweep.Util.doIntersect;

public class FindIfAnyTwoSegmentsIntersect {

    int sweepLineAlgorithm(int n, int[][] points) {


        PriorityQueue<SPoint> pointsPQ = new PriorityQueue<>(Comparator.comparingDouble(SPoint::getX).thenComparingInt(SPoint::getId));

        for (int i = 0; i < n; i++) {
            int[] segment = points[i];
            SPoint p = new SPoint(i, segment[0], segment[1]);
            SPoint q = new SPoint(i, segment[2], segment[3]);

            Segment seg = new Segment(p, q);

            pointsPQ.add(seg.getP());
            pointsPQ.add(seg.getQ());
        }


        TreeSet<Segment> tree = new TreeSet<>((s1, s2) -> Double.compare(s1.getP().getY(), s2.getP().getY()));


        while (!pointsPQ.isEmpty()) {
            SPoint current = pointsPQ.remove();
            if (current.isLeft()) {
                tree.add(current.getS());

                if (tree.lower(current.getS()) != null)
                    if (doIntersect(current.getS(), tree.lower(current.getS())))
                        return 1;
                if (tree.higher(current.getS()) != null)
                    if (doIntersect(current.getS(), tree.higher(current.getS())))
                        return 1;

            } else {
                if (tree.lower(current.getS()) != null && tree.higher(current.getS()) != null)
                    if (doIntersect(tree.lower(current.getS()), tree.higher(current.getS())))
                        return 1;
                tree.remove(current.getS());
            }
        }

        return 0;
    }

}
