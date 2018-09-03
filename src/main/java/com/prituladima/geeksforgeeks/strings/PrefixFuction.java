package com.prituladima.geeksforgeeks.strings;

import java.util.ArrayList;
import java.util.List;

public class PrefixFuction {

    public static List<Integer> compute_prefix_function(String s) {
        int len = s.length();
        List<Integer> p = new ArrayList<>(); // значения префикс-функции
        for (int i = 0; i < len; ++i) {      // заполнение листа нулями default
            p.add(0);
        }
        // индекс листа соответствует номеру последнего символа аргумента
        int k = 0;
        for (int i = 1; i < len; ++i) {
            while ((k > 0) && (s.charAt(k) != s.charAt(i)))
                k = p.get(k - 1);
            if (s.charAt(k) == s.charAt(i))
                ++k;
            p.set(i, k);
        }
        return p;
    }

}
