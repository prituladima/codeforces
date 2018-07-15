package com.prituladima.geeksforgeeks.geometric_algorithms.lines;

/**
 * Created by prituladima on 7/15/18.
 */
public class PointOfIntersectionOfTwoLines {


    double[] pointOfIntersectionOfTwoLines(int[][] line1, int[][] line2) {
        // Line AB represented as a1x + b1y = c1
        double a1 = line1[0][1] - line1[1][1];
        double b1 = line1[1][0] - line1[0][0];
        double c1 = a1 * (line1[0][0]) + b1 * (line1[0][1]);

        // Line CD represented as a2x + b2y = c2
        double a2 = line2[0][1] - line2[1][1];
        double b2 = line2[1][0] - line2[0][0];
        double c2 = a2 * (line2[0][0]) + b2 * (line2[0][1]);

        double determinant = a1 * b2 - a2 * b1;

        if (determinant != 0) {
            double x = (b2 * c1 - b1 * c2) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;
            return new double[]{x, y};
        }


        return null;
    }


}
