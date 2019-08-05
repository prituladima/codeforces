package com.prituladima.google.leetcode;

import java.util.*;

public class Skyline {

    /**
     * Represents either start or end of building
     */
    static class BuildingPoint implements Comparable<BuildingPoint> {
        int x;
        boolean isStart;
        int height;

        @Override
        public int compareTo(BuildingPoint o) {
            //first compare by x.
            //If they are same then use this logic
            //if two starts are compared then higher height building should be picked first
            //if two ends are compared then lower height building should be picked first
            //if one start and end is compared then start should appear before end
            if (this.x != o.x) {
                return this.x - o.x;
            } else {
                return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
            }
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {

        //for all start and end of building put them into List of BuildingPoint
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
        int index = 0;
        for (int building[] : buildings) {
            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].x = building[0];
            buildingPoints[index].isStart = true;
            buildingPoints[index].height = building[2];

            buildingPoints[index + 1] = new BuildingPoint();
            buildingPoints[index + 1].x = building[1];
            buildingPoints[index + 1].isStart = false;
            buildingPoints[index + 1].height = building[2];
            index += 2;
        }
        Arrays.sort(buildingPoints);

        //using TreeMap because it gives log time performance.
        //PriorityQueue in java does not support remove(object) operation in log time.
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        //PriorityQueue<Integer> queue1 = new PriorityQueue<>(Collections.reverseOrder());
        queue.put(0, 1);
        //queue1.add(0);
        int prevMaxHeight = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (BuildingPoint buildingPoint : buildingPoints) {
            //if it is start of building then add the height to map. If height already exists then increment
            //the value
            if (buildingPoint.isStart) {
                queue.compute(buildingPoint.height, (key, value) -> {
                    if (value != null) {
                        return value + 1;
                    }
                    return 1;
                });
                //  queue1.add(cp.height);
            } else { //if it is end of building then decrement or remove the height from map.
                queue.compute(buildingPoint.height, (key, value) -> {
                    if (value == 1) {
                        return null;
                    }
                    return value - 1;
                });
                // queue1.remove(cp.height);
            }
            //peek the current height after addition or removal of building x.
            int currentMaxHeight = queue.lastKey();
            //int currentMaxHeight = queue1.peek();
            //if height changes from previous height then this building x becomes critcal x.
            // So add it to the result.
            if (prevMaxHeight != currentMaxHeight) {
                result.add(new ArrayList<Integer>() {{
                    add(buildingPoint.x);
                    add(currentMaxHeight);
                }});
                prevMaxHeight = currentMaxHeight;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int[][] buildings = {{0, 2, 3}, {2, 5, 3}};
        Skyline sd = new Skyline();
        List<List<Integer>> criticalPoints = sd.getSkyline(buildings);
        criticalPoints.forEach(cp -> System.out.println(cp.get(0) + " " + cp.get(1)));
    }

    /**
     * Divide-and-conquer algorithm to solve skyline problem,
     * which is similar with the merge sort algorithm.
     */
    public List<List<Integer>> getSkyline1(int[][] buildings) {
        int n = buildings.length;
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        // The base cases
        if (n == 0) return output;
        if (n == 1) {
            int xStart = buildings[0][0];
            int xEnd = buildings[0][1];
            int y = buildings[0][2];

            output.add(new ArrayList<Integer>() {{
                add(xStart);
                add(y);
            }});
            output.add(new ArrayList<Integer>() {{
                add(xEnd);
                add(0);
            }});
            // output.add(new int[]{xStart, y});
            // output.add(new int[]{xEnd, 0});
            return output;
        }

        // If there is more than one building,
        // recursively divide the input into two subproblems.
        List<List<Integer>> leftSkyline, rightSkyline;
        leftSkyline = getSkyline1(Arrays.copyOfRange(buildings, 0, n / 2));
        rightSkyline = getSkyline1(Arrays.copyOfRange(buildings, n / 2, n));

        // Merge the results of subproblem together.
        return mergeSkylines(leftSkyline, rightSkyline);
    }

    public List<List<Integer>> getSkyline2(int low, int high, int[][] buildings) {

        List<List<Integer>> output = new ArrayList<List<Integer>>();

        // The base cases
        if (low > high) {
            return output;
        } else if (low == high) {
            int xStart = buildings[low][0];
            int xEnd = buildings[low][1];
            int y = buildings[low][2];

            output.add(new ArrayList<Integer>() {{
                add(xStart);
                add(y);
            }});
            output.add(new ArrayList<Integer>() {{
                add(xEnd);
                add(0);
            }});
            // output.add(new int[]{xStart, y});
            // output.add(new int[]{xEnd, 0});
            return output;
        } else {

            // If there is more than one building,
            // recursively divide the input into two subproblems.
            List<List<Integer>> leftSkyline, rightSkyline;
            int mid = (low + high) >>> 1;
            leftSkyline = getSkyline2(low, mid, buildings);
            rightSkyline = getSkyline2(mid + 1, high, buildings);

            // Merge the results of subproblem together.
            return mergeSkylines(leftSkyline, rightSkyline);
        }
    }

    /**
     * Merge two skylines together.
     */
    public List<List<Integer>> mergeSkylines(List<List<Integer>> left, List<List<Integer>> right) {
        int nL = left.size(), nR = right.size();
        int pL = 0, pR = 0;
        int currY = 0, leftY = 0, rightY = 0;
        int x, maxY;
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        // while we're in the region where both skylines are present
        while ((pL < nL) && (pR < nR)) {
            List<Integer> pointL = left.get(pL);
            List<Integer> pointR = right.get(pR);
            // pick up the smallest x
            if (pointL.get(0) < pointR.get(0)) {
                x = pointL.get(0);
                leftY = pointL.get(1);
                pL++;
            } else {
                x = pointR.get(0);
                rightY = pointR.get(1);
                pR++;
            }
            // max height (i.e. y) between both skylines
            maxY = Math.max(leftY, rightY);
            // update output if there is a skyline change
            if (currY != maxY) {
                updateOutput(output, x, maxY);
                currY = maxY;
            }
        }

        // there is only left skyline
        appendSkyline(output, left, pL, nL, currY);

        // there is only right skyline
        appendSkyline(output, right, pR, nR, currY);

        return output;
    }

    /**
     * Update the final output with the new element.
     */
    public void updateOutput(List<List<Integer>> output, int x, int y) {
        // if skyline change is not vertical -
        // add the new point
        if (output.isEmpty() || output.get(output.size() - 1).get(0) != x)
            output.add(new ArrayList<Integer>() {{
                add(x);
                add(y);
            }});
            // if skyline change is vertical -
            // update the last point
        else {
            output.get(output.size() - 1).set(1, y);
        }
    }

    /**
     * Append the rest of the skyline elements with indice (p, n)
     * to the final output.
     */
    public void appendSkyline(List<List<Integer>> output, List<List<Integer>> skyline,
                              int p, int n, int currY) {
        while (p < n) {
            List<Integer> point = skyline.get(p);
            int x = point.get(0);
            int y = point.get(1);
            p++;

            // update output
            // if there is a skyline change
            if (currY != y) {
                updateOutput(output, x, y);
                currY = y;
            }
        }
    }

    public List<List<Integer>> getSkyline5(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> heightHeap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[2] == b[2] ? a[0] - b[0] : b[2] - a[2];
            }
        });

        int[] pre = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        for(int[] b : buildings) {
            while(!heightHeap.isEmpty() && b[0] > pre[1]) { // totally separated
                int[] curHeighest = heightHeap.poll();
                if(curHeighest[1] <= pre[1]) continue;
                res.add(Arrays.asList(pre[1], curHeighest[2]));
                pre = curHeighest;
            }
            if(b[2] > pre[2]) {
                if(b[0] == pre[0]) { // we always make sure pre is the last element in the res
                    // if b[0] and pre[0] overlap but b is higher than pre, then we track the point in b not pre
                    res.remove(res.size() - 1);
                }
                res.add(Arrays.asList(b[0], b[2])); // highest point possibly has a pos in result;
                if(b[1] < pre[1]) {
                    heightHeap.offer(pre);
                }
                pre = b;
            }
            else if(b[1] > pre[1]) {
                if(b[2] == pre[2]) {
                    pre[1] = b[1];
                }
                else {
                    heightHeap.offer(b);
                }
            }
        }
        while(!heightHeap.isEmpty()) {
            int[] cur = heightHeap.poll();
            if(cur[1] <= pre[1]) continue;
            res.add(Arrays.asList(pre[1], cur[2]));
            pre = cur;
        }

        if(pre[2] > 0) {
            res.add(Arrays.asList(pre[1], 0));
        }
        return res;
    }
}