package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;
import javafx.geometry.Point3D;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class C1BalancedRemovalsEasier {

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        List<Points3D> points = readPoints3DList(in);

        Map<Points3D, Integer> pointToIndex = new HashMap<>();
        int k = 1;
        for (Points3D point : points) {
            pointToIndex.put(point, k++);
        }

        for (Points3D point : points) {
            if(pointToIndex.containsKey(point)){//looking for pair to remove
                int numberRemoved = pointToIndex.remove(point);

                Iterator<Points3D> iterator = pointToIndex.keySet().iterator();
                Points3D closest = iterator.next();//at least one here

                while (iterator.hasNext()) {
                    long toClosest = dist(point, closest);
                    Points3D next = iterator.next();
                    long toNext = dist(point, next);
                    if(toClosest > toNext) {
                        closest = next;
                    }

                }

                out.printf("%d %d\n", numberRemoved, pointToIndex.remove(closest));


            }
        }

    }

    private long dist(Points3D first, Points3D second){
        return (first.getX() - second.getX())*1L*(first.getX() - second.getX())
                + (first.getY() - second.getY())*1L*(first.getY() - second.getY())
                + (first.getZ() - second.getZ())*1L*(first.getZ() - second.getZ());
    }


    private List<Points3D> readPoints3DList(InputReader in){
        List<Points3D> ans = new ArrayList<>();
        int n = in.nextInt();
        for(int i = 0; i < n; i ++) ans.add(new Points3D(in.nextInt(), in.nextInt(), in.nextInt()));
        return ans;
    }

    private static class Points3D {
        private int x;
        private int y;
        private int z;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }

        public Points3D(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Points3D points3D = (Points3D) o;
            return x == points3D.x &&
                    y == points3D.y &&
                    z == points3D.z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }
    }
}