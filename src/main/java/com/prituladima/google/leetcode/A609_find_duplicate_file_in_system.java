package com.prituladima.google.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A609_find_duplicate_file_in_system {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentToFiles = new HashMap<>();
        for (String path : paths) {
            String[] splited = path.split(" ");
            String root = splited[0];
            for (int i = 1; i < splited.length; i++) {
                int beginIndex = splited[i].lastIndexOf("(");
                String content = splited[i].substring(beginIndex, splited[i].length() - 1);
                String file = splited[i].substring(0, beginIndex);

                if (!contentToFiles.containsKey(content)) {
                    contentToFiles.put(content, new ArrayList<>(1));
                }
                contentToFiles.get(content).add(root + "/" + file);

            }
        }

        List<List<String>> ans = new ArrayList<>();
        contentToFiles.forEach((key, val) -> {
            if(val.size() > 1)
                ans.add(val);
        });
        return ans;
    }
}
