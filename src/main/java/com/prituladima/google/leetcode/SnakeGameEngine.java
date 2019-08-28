package com.prituladima.google.leetcode;

import java.util.*;

import static java.lang.System.out;

public class SnakeGameEngine {
    public static void main(String[] args) {
        final SnakeGame snakeGame = new SnakeGame(3, 3, new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 2}, {2, 1}, {2, 0}, {1, 0}});
        final String[] directions = {"R", "R", "D", "D", "L", "L", "U", "U", "R", "R", "D", "D", "L", "L", "U", "R", "U", "L", "D"};
        int k = 1;
        for (String direction : directions) {
            out.println(k++ + "/" + directions.length + " " + direction);
            out.println(snakeGame.move(direction));
        }
    }

    static class SnakeGame {

        private static Map<String, int[]> steps = new HashMap<>();

        static {
            steps.put("L", new int[]{-1, 0});
            steps.put("R", new int[]{1, 0});
            steps.put("D", new int[]{0, 1});
            steps.put("U", new int[]{0, -1});
        }

        int width;
        int height;
        int[][] food;


        Deque<int[]> snake = new ArrayDeque<>();
        Set<Pair> hashSet = new HashSet<>();

        int[] curFood;
        int[] head;
        int[] last;

        int nextIndex = 0;
        int points = 0;

        /**
         * Initialize your data structure here.
         *
         * @param width  - screen width
         * @param height - screen height
         * @param food   - A list of food positions
         *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
         */
        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;

            if (nextIndex >= food.length) curFood = null;
            else curFood = food[nextIndex++];


            snake.offer(head = last = new int[]{0, 0});
            hashSet.add(new Pair(0, 0));
        }


        /**
         * Moves the snake.
         *
         * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         * @return The game's score after the move. Return -1 if game over.
         * Game over when snake crosses the screen boundary or bites its body.
         */
        public int move(String direction) {
            if (checkIfGameOver(direction)) return -1;
            int[] path = steps.get(direction);
            int[] maybe = new int[]{head[0] + path[0], head[1] + path[1]};

            if (curFood != null && maybe[0] == curFood[1] && maybe[1] == curFood[0]) {
                points++;
                if (nextIndex >= food.length) curFood = null;
                else curFood = food[nextIndex++];
            } else {
                int[] toRemove = snake.poll();
                if (toRemove == null) throw new IllegalStateException();
                hashSet.remove(new Pair(toRemove[0], toRemove[1]));
            }
            snake.offer(head = new int[]{maybe[0], maybe[1]});
            hashSet.add(new Pair(maybe[0], maybe[1]));
            last = snake.peek();
            return points;
        }

        private boolean checkIfGameOver(String direction) {
            int[] step = steps.get(direction);
            int[] maybe = new int[]{head[0] + step[0], head[1] + step[1]};

            return !isOn(maybe[0], maybe[1]) ||
                    (hashSet.contains(new Pair(maybe[0], maybe[1]))
                            &&
                            !(maybe[0] == last[0] && maybe[1] == last[1])
                    );

        }

        private boolean isOn(int x, int y) {
            return (0 <= x && x < width) && (0 <= y && y < height);
        }

    }

    /**
     * Your SnakeGame object will be instantiated and called as such:
     * SnakeGame obj = new SnakeGame(width, height, food);
     * int param_1 = obj.move(direction);
     */

    static class Pair {
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

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
}