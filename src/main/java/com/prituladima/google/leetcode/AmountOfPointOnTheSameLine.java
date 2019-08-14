package com.prituladima.google.leetcode;

import java.util.HashMap;
import java.util.Map;

public class AmountOfPointOnTheSameLine {
    static class Solution {
        public int maxPoints(int[][] points) {
            int len = points.length;

            if (len < 3) return len;
            Slope point = new Slope(0, 0, 0, 0);
            int max = 0;
            for (int i = 0; i < len; i++) {

                Map<Slope, Integer> counter = new HashMap<>();

                int localMax = 0;
                for (int j = 0; j < len; j++) {

                    if (i != j) {
                        Slope sl = new Slope(points[i][0], points[i][1], points[j][0], points[j][1]);

                        counter.merge(sl, 1, Integer::sum);
                        localMax = Math.max(counter.get(sl), localMax);
                    }


                }


                max = Math.min(Math.max(max, localMax + counter.getOrDefault(point, 0) + 1), len);
                counter.clear();
            }
            return max;

        }

        private static class Slope {
            int f;
            int s;

            public Slope(int x1, int y1, int x2, int y2) {
                int gcd = gcd(x1 - x2, y1 - y2);

                this.f = (x1 - x2);
                this.s = (y1 - y2);

                if (gcd != 0) {
                    this.f /= gcd;
                    this.s /= gcd;

                }
            }

            int gcd(int a, int b) {
                return b == 0 ? a : gcd(b, a % b);
            }


            @Override
            public int hashCode() {
                int result = f;
                result = 31 * result + s;
                return result;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Slope)) return false;
                Slope oo = (Slope) o;
                //if(oo.f == 0 && oo.s == 0 || 0 == f && 0 == s) return true;

                return oo.f == f && oo.s == s;
            }
        }
    }
}
