package com.prituladima.geeksforgeeks.geometric_algorithms.lines;

import com.prituladima.geeksforgeeks.geometric_algorithms.lines.slope.*;
import java.util.*;

/**
 * Created by prituladima on 7/13/18.
 */
public class MinimumLinesToCoverAllPointsWhichGoThroughASpecificPoint {
    int minLinesToCoverPoints(int x, int y, int[][] points){
        Set<Slope> set = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            set.add(new Slope(x, y, points[i][0], points[i][1]));
        }
        return set.size();
    }
}