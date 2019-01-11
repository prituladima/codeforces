package com.prituladima.geeksforgeeks.geometric_algorithms.lines;

import com.prituladima.geeksforgeeks.geometric_algorithms.lines.line.Line2D;
import com.prituladima.geeksforgeeks.geometric_algorithms.lines.line.Point2D;

import java.util.List;

/**
 * Created by prituladima on 7/14/18.
 */
public class MinJumpsToReachDestination {

    int minJumpToReachDestination(Point2D start, Point2D dest, List<Line2D> lines) {
        int jumps = 0;
        for (int i = 0; i < lines.size(); i++) {
            int signStart = evalPointOnLine(start, lines.get(i));
            int signDest = evalPointOnLine(dest, lines.get(i));
            if (signStart * signDest < 0)
                jumps++;
        }
        return jumps;
    }

    int evalPointOnLine(Point2D p, Line2D line) {
        int eval = line.getA() * p.getX() + line.getB() * p.getY() + line.getC();
        return eval > 0 ? 1 : eval < 0 ? -1 : 0;
    }


}