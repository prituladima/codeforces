package com.prituladima.yaal.collections;

import java.util.HashSet;
import java.util.Set;

public class SetUtil {

    public static boolean areIntersect(Set<Integer> set1, Set<Integer> set2) {
        return getIntersection(set1, set2).size() != 0;
    }

    public  static boolean areFullyIntersect(Set<Integer> set1, Set<Integer> set2) {
        if (!areIntersect(set1, set2)) return false;
        if (set1.size() != set2.size()) return false;
        Set<Integer> reminder = getIntersection(set1, set2);
        int setFirstSize = set1.size();
        int setSecondSize = set2.size();
        return setFirstSize == reminder.size() && setSecondSize == reminder.size();
    }

    public static Set<Integer> getIntersection(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> reminder = new HashSet<>(set1);
        Set<Integer> subtrahend = new HashSet<>(set2);
        reminder.retainAll(subtrahend);
        return reminder;
    }
}
