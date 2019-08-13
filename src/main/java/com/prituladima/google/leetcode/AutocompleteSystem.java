package com.prituladima.google.leetcode;

import java.util.*;

class AutocompleteSystem {

    NavigableMap<String, Integer> tree = new TreeMap<>();
    Map<String, Integer> hashCounter = new HashMap<>();
    StringBuilder current = new StringBuilder();

    public AutocompleteSystem(String[] sentences, int[] times) {
        int len = sentences.length;
        for (int i = 0; i < len; i++) {
            tree.put(sentences[i], times[i]);
            hashCounter.put(sentences[i], times[i]);
        }
    }


    public List<String> input(char c) {
        if (c == '#') {
            tree.merge(current.toString(), 1, Integer::sum);
            hashCounter.merge(current.toString(), 1, Integer::sum);
            current = new StringBuilder();
            return new ArrayList<>();
        }

        current.append(c);
        String from = current.toString();
        String upTo = current.toString() + (char)('z' + 1);

        Iterator<String> range = tree.subMap(from, upTo).keySet().iterator();

        PriorityQueue<String> pq = new PriorityQueue<>((str1, str2)

                -> {int fc = -Integer.compare(hashCounter.get(str1), hashCounter.get(str2));
            if(fc == 0){
                return str1.compareTo(str2);
            }
            return fc;
        }
        );

        while(range.hasNext()) pq.add(range.next());

        List<String> ans = new ArrayList<>();
        int i = 3;
        while (i-- > 0 && !pq.isEmpty()) {
            ans.add(pq.remove());
        }
        //Collections.sort(ans);
        return ans;

    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */