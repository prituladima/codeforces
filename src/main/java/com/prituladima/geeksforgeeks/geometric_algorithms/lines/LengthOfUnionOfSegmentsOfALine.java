package com.prituladima.geeksforgeeks.geometric_algorithms.lines;

import com.prituladima.geeksforgeeks.geometric_algorithms.lines.klee.LSegment;
import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @see "https://www.geeksforgeeks.org/klees-algorithm-length-union-segments-line/"
 */
class LengthOfUnionOfSegmentsOfALine {


    int klee(int[][] input) {

        ArrayList<LSegment> segments = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            segments.add(new LSegment(input[i][0], input[i][1]));
        }

        int n = segments.size();


        ArrayList<Pair<Integer, Boolean>> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            points.add(new Pair<>(segments.get(i).getFirst(), false));
            points.add(new Pair<>(segments.get(i).getSecond(), true));
        }

        Collections.sort(points, Comparator.comparingInt(Pair::getFirst)); //O(n * lon (n))

        int result = 0;
        int active = 0;

        n <<= 1;

        for (int i = 0; i < n; i++) {
            if (active != 0)
                result += (points.get(i).getFirst() - points.get(i - 1).getFirst());

            if (points.get(i).getSecond()) {
                active--;
            } else {
                active++;
            }
        }
        return result;
    }

}