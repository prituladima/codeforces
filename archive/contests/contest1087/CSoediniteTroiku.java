package com.prituladima.codeforce.contests.contest1087;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.*;

public class CSoediniteTroiku {
    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        Point[] p = new Point[3];

        for (int i = 0; i < 3; i++) {
            p[i] = new Point(in.nextInt(), in.nextInt());
        }

        Arrays.sort(p, Comparator.comparingInt(Point::getX).thenComparing(Point::getY));

        Set<Point> ans =new HashSet<>();
        for(int i = Math.min(Math.min(p[0].y, p[1].y), p[2].y);
            i <= Math.max(Math.max(p[0].y, p[1].y), p[2].y); i++){
                ans.add(new Point(p[1].x, i));
        }

        for(int i = p[0].x; i < p[1].x; i++){
            ans.add(new Point(i, p[0].y));
        }

        for(int i = p[2].x; i > p[1].x; i--){
            ans.add(new Point(i, p[2].y));
        }

        out.printf("%d\n", ans.size());
        for (Point i : ans) {
            out.printf("%d %d\n", i.x, i.y);
        }

    }
}
