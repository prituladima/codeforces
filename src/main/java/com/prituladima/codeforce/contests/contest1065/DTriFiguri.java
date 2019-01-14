package com.prituladima.codeforce.contests.contest1065;

import com.prituladima.codeforce.InputReader;
import com.sun.deploy.pings.Pings;

import java.io.PrintWriter;
import java.util.Arrays;

public class DTriFiguri {

    private static class Point {
        int x, y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Point of(int x, int y) {
            return new Point(x, y);
        }

        public static int hash(int x, int y, int p) {
            return x * N * 3 + y * 3 + p;
        }

        public static Point min(Point a, Point b) {
            if (a.x == b.x) {
                return a.y < b.y ? a : b;
            }
            return a.x < b.x ? a : b;
        }

        public static Point sum(Point point1, Point point) {
            return Point.of(point1.x + point.x, point1.y + point.y);
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    static int N;
    int M = 305;
    int INF = (int)1e9;
    Point[] possibleKnight = new Point[]{
            Point.of(2, 1),
            Point.of(-2, 1),
            Point.of(2, -1),
            Point.of(-2, -1),
            Point.of(1, 2),
            Point.of(-1, 2),
            Point.of(1, -2),
            Point.of(-1, -2)
    };
    Point[][] dist = new Point[M][M];


    {


    }

    private boolean in(Point p) {
        return 0 <= p.x && p.x < N && 0 <= p.y && p.y < N;
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        N = in.nextInt();
        Point[] pos = new Point[N * N];
        int[][] A = new int[N][N];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                A[x][y] = in.nextInt() - 1;
                pos[A[x][y]] = Point.of(x, y);

            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
//                Arrays.fill(dist[i], Point.of(INF, INF));
                dist[i][j] = Point.of(INF, INF);
            }
        }
        for (int i = 0; i < M; i++)
//            for (int j = 0; j < M; j++)
//                if (i == j)
                    dist[i][i] = Point.of(0, 0);


        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                //knight
                for (int i = 0; i < possibleKnight.length; i++) {
                    int nx = x + possibleKnight[i].x;
                    int ny = y + possibleKnight[i].y;
                    if (in(Point.of(nx, ny))) {
                        dist[Point.hash(x, y, 0)][Point.hash(nx, ny, 0)] = Point.of(1, 0);
                    }
                }
                //bishop
                for (int i = -N + 1; i <= N - 1; i++) {
                    int nx = x + i;
                    int ny = y + i;
                    if (in(Point.of(nx, ny)))
                        dist[Point.hash(x, y, 1)][Point.hash(nx, ny, 1)] = Point.of(1, 0);

                    ny = y - i;
                    if (in(Point.of(nx, ny)))
                        dist[Point.hash(x, y, 1)][Point.hash(nx, ny, 1)] = Point.of(1, 0);
                }

                //rook
                for (int i = 0; i < N; i++) {
                    int nx = i;
                    int ny = y;
//                    if (in(Point.of(nx, ny)))
                    dist[Point.hash(x, y, 2)][Point.hash(nx, ny, 2)] = Point.of(1, 0);
                    nx = x;
                    ny = i;
//                    if (in(Point.of(nx, ny)))
                    dist[Point.hash(x, y, 2)][Point.hash(nx, ny, 2)] = Point.of(1, 0);

                }

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i != j) {
                            dist[Point.hash(x, y, i)][Point.hash(x, y, j)] = Point.of(1, 1);
                        }
                    }
                }


            }
        }

        for (int k = 0; k < M; k++) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    dist[i][j] = Point.min(dist[i][j], Point.sum(dist[i][k], dist[k][j]));
                }
            }
        }

        Point[][] dp = new Point[N * N][3];
        for (int i = 0; i < N * N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Point.of(INF, INF);
            }
        }

        dp[0][0] = dp[0][1] = dp[0][2] = Point.of(0, 0);


        for (int i = 0; i < N * N - 1; i++)
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++)
                    dp[i + 1][k] = Point.min(
                            dp[i + 1][k],
                            Point.sum(dp[i][j], dist[Point.hash(pos[i].x, pos[i].y, j)][Point.hash(pos[i + 1].x, pos[i + 1].y, k)])
                    );


        Point ans = Point.of(INF, INF);
        ans = Point.min(ans, dp[N * N - 1][0]);
        ans = Point.min(ans, dp[N * N - 1][1]);
        ans = Point.min(ans, dp[N * N - 1][2]);


        out.print(ans.toString());
    }

}