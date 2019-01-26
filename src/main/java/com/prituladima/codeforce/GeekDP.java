package com.prituladima.codeforce;

import java.util.Objects;

public class GeekDP {

    @Deprecated
    public static class Pair {

        int id;
        int first;
        int second;

        public Pair(int id, int first, int second) {
            this.id = id;
            this.first = first;
            this.second = second;
        }

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return id == pair.id &&
                    first == pair.first &&
                    second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, first, second);
        }


    }

}
