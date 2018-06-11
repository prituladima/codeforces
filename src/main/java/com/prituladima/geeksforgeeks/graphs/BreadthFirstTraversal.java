package com.prituladima.geeksforgeeks.graphs;

/**
 * @see "https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/"
 * @see "https://practice.geeksforgeeks.org/problems/x-total-shapes/0"
 */
public class BreadthFirstTraversal {

    private char X = 'X';
    private char O = 'O';

    public int islands(String mtx) {
        if (mtx.equals("")) return -1;

        String[] arr = mtx.split(" ");
        char[][] newMtx = new char[arr.length][];

        for (int i = 0; i < arr.length; i++) {
            newMtx[i] = arr[i].toCharArray();
        }

        return islands(newMtx);
    }

    public int islands(char[][] mtx) {

        boolean[][] visited = new boolean[mtx.length][mtx[0].length];

        int ans = 0;

        int[] newRoot;
        while ((newRoot = getNewRoot(mtx, visited))[0] != -1) {

            int i = newRoot[0];
            int j = newRoot[1];

            traversal(i, j, mtx, visited);
            ans++;

        }

        return ans;
    }

    //Let's find first vertex that we have never visited
    private int[] getNewRoot(char[][] mtx, boolean[][] visited) {

        for (int i = 0; i < mtx.length; i++) {
            for (int j = 0; j < mtx[i].length; j++) {
                if (!visited[i][j] && mtx[i][j] == X) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};

    }


    private void traversal(int i, int j, char[][] mtx, boolean[][] visited) {
        //Let's move left if we have path and we've never been there
        //Let's move up if we have path and we've never been there
        //Let's move right if we have path and we've never been there
        //Let's move down if we have path and we've never been there
        visited[i][j] = true;
        if (i - 1 >= 0 && mtx[i - 1][j] == X && !visited[i - 1][j]) {
            traversal(i - 1, j, mtx, visited);
        }
        if (j - 1 >= 0 && mtx[i][j - 1] == X && !visited[i][j - 1]) {
            traversal(i, j - 1, mtx, visited);
        }
        if (i + 1 <= mtx.length - 1 && mtx[i + 1][j] == X && !visited[i + 1][j]) {
            traversal(i + 1, j, mtx, visited);
        }
        if (j + 1 <= mtx[i].length - 1 && mtx[i][j + 1] == X && !visited[i][j + 1]) {
            traversal(i, j + 1, mtx, visited);
        }

    }

}
