package com.prituladima.yaal.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class GreedyUtil {

    public static <T> List<T> calculatePrefix(List<T> init, BinaryOperator<T> operator) {
        List<T> pref = new ArrayList<>(init);
        for (int i = 1; i < init.size(); i++) {
            pref.set(i, operator.apply(pref.get(i - 1), pref.get(i)));
        }
        return pref;
    }

    public static <T> List<T> calculateSuffix(List<T> init, BinaryOperator<T> operator) {
        List<T> suff = new ArrayList<>(init);
        for (int i = init.size() - 2; i >= 0; i--) {
            suff.set(i, operator.apply(suff.get(i + 1), suff.get(i)));
        }
        return suff;
    }

}
