package com.prituladima.google.leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CleaningRobot {
    public static void main(String[] args) {

    }

    /**
     * // This is the robot's control interface.
     * // You should not implement it, or speculate about its implementation
     * interface Robot {
     * // Returns true if the cell in front is open and robot moves into the cell.
     * // Returns false if the cell in front is blocked and robot stays in the current cell.
     * public boolean move();
     * <p>
     * // Robot will stay in the same cell after calling turnLeft/turnRight.
     * // Each turn will be 90 degrees.
     * public void turnLeft();
     * public void turnRight();
     * <p>
     * // Clean the current cell.
     * public void clean();
     * }
     */
    class Solution {
        Set<Pair> used = new HashSet<>();
        int[][] paths = new int[][]{
                {0, 1},
                {-1, 0},
                {0, -1},
                {1, 0}
        };
        //int[] rotations = {0, 1, 2, 4};

        public void cleanRoom(Robot robot) {
            dfs(robot, 0, 0, 0);
        }

        private void dfs(Robot robot, int i, int j, int rightRotationToNormalize) {
            for (int k = 0; k < rightRotationToNormalize; k++) {
                robot.turnRight();
            }
            Pair curPos;
            robot.clean();
            used.add(curPos = new Pair(i, j));

            for (int k = 0; k < paths.length; k++) {
                int[] path = paths[k];
                for (int i1 = 0; i1 < k; i1++)
                    robot.turnLeft();

                Pair toPos = new Pair(curPos.getFirst() + path[0], curPos.getSecond() + path[1]);
                if (canMove(robot) && !used.contains(toPos)) {
                    robot.move();
                    dfs(robot, toPos.getFirst(), toPos.getSecond(), k);
                    moveBack(robot);
                }

                for (int i1 = 0; i1 < k; i1++)
                    robot.turnRight();

            }

            for (int i1 = 0; i1 < rightRotationToNormalize; i1++) {
                robot.turnLeft();
            }
        }

        private void moveBack(Robot robot) {
            robot.turnLeft();
            robot.turnLeft();
            if (!robot.move()) throw new IllegalStateException();
            robot.turnLeft();
            robot.turnLeft();
        }

        private boolean canMove(Robot robot) {
            if (!robot.move()) return false;
            else {
                moveBack(robot);
                return true;
            }
        }
    }


    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        void turnLeft();

        void turnRight();

        // Clean the current cell.
        void clean();
    }

    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first &&
                    second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}
