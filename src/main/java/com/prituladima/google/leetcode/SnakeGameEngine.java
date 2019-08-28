package com.prituladima.google.leetcode;

import java.util.*;

import static java.lang.System.out;

public class SnakeGameEngine {
    public static void main(String[] args) {

        final SnakeGame snakeGame = new SnakeGame(100, 30, new int[][]{{11, 0}, {58, 7}});
        final String[] directions = {"D", "R", "R", "D", "D", "U", "D", "R", "L", "R", "U", "D", "D", "R", "R", "U", "D", "R", "D", "D", "D", "D", "U", "D", "L", "D", "U", "D", "U", "D", "R", "L", "L", "R", "D", "L", "U", "L", "L", "L", "R", "R", "U", "R", "L", "D", "R", "L", "U", "U", "D", "D", "D", "L", "L", "D", "L", "D", "R", "U", "L", "U", "R", "R", "U", "L", "D", "L", "D", "D"};
        int k = 1;
        for (String direction : directions) {
            out.println(k++ +  "/" + directions.length +  " " + direction);
            out.println(snakeGame.move(direction));
        }
    }

    static class SnakeGame {

        /**
         * Initialize your data structure here.
         *
         * @param width - screen width
         * @param height - screen height
         * @param food - A list of food positions
         * E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
         */
        Deque<int[]> snake = new ArrayDeque<>();
        int width;
        int height;
        int[][] food;
        int[] cur;
        int[] last;
        char[][] field;
        //        boolean end = false;
        int k = 0;
        int ans = 0;

        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;
            this.field = new char[width][height];
            for (int i = 0; i < width; i++) for (int j = 0; j < height; j++) field[i][j] = ' ';
            field[0][0] = 'S';
            if(food.length > k){
                field[food[k][1]][food[k][0]] = 'F';
                k++;
            }
            snake.offer(cur = last = new int[]{0, 0});

            out.println();
            out.println(Arrays.deepToString(field));

        }

        private static Map<String, int[]> steps = new HashMap<>();

        static {
            steps.put("L", new int[]{-1, 0});
            steps.put("R", new int[]{1, 0});
            steps.put("D", new int[]{0, 1});
            steps.put("U", new int[]{0, -1});
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
            int[] a = steps.get(direction);
            int[] maybe = new int[]{cur[0] + a[0], cur[1] + a[1]};
            if (field[maybe[0]][maybe[1]] == 'F') {
                snake.offer(cur = new int[]{maybe[0], maybe[1]});
                field[maybe[0]][maybe[1]] = 'S';
                if (k < food.length) {
                    field[food[k][1]][food[k][0]] = 'F';
                    k++;
                }
                ans++;
            } else {
                snake.offer(cur = new int[]{maybe[0], maybe[1]});
                int[] toRemove = snake.poll();
                if (toRemove == null) throw new IllegalStateException();
                field[toRemove[0]][toRemove[1]] = ' ';
                last = snake.peekFirst();
                field[maybe[0]][maybe[1]] = 'S';
            }
            out.println();
            out.println(Arrays.deepToString(field));
            return ans;
        }

        private boolean checkIfGameOver(String direction) {
            int[] a = steps.get(direction);
            int[] maybe = new int[]{cur[0] + a[0], cur[1] + a[1]};

            return !isOn(maybe[0], maybe[1]) ||
                    (field[maybe[0]][maybe[1]] == 'S'
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

    static class Pair{
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