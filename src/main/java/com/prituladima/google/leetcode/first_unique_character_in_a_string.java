package com.prituladima.google.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class first_unique_character_in_a_string {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> counter = new LinkedHashMap<>();
        for(char c : chars){
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        for(char c: counter.keySet()){
            if(counter.get(c) == 1) return s.indexOf(c) ;
        }

        return -1;
    }
}
