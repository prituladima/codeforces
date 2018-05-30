package com.prituladima.contests;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class C_2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = Integer.parseInt(scanner.nextLine());
        String leader = "";
        int max = Integer.MIN_VALUE;
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < amount; i++) {
            String[] line = scanner.nextLine().split(" ");
            String str = line[0];
            int score = Integer.parseInt(line[1]);
            if (!map.containsKey(str)) {
                map.put(str, score);
            } else {
                int was = map.get(str);
                map.remove(str);
                map.put(str, was + score);
            }
        }
        for (String name : map.keySet()) {
            if (max < map.get(name)) {
                max = map.get(name);
                leader = name;
            }
        }
        System.out.println(leader);
    }

}