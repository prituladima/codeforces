package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

public class IsenbaevsNumber {
    String main = "Isenbaev";
    boolean[] used = new boolean[330];

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();

        Map<Integer, Set<Integer>> graph = new HashMap<>();
//        graph.putIfAbsent(0, new LinkedHashSet<>());
        Map<String, Integer> tree = new TreeMap<>();
//        tree.putIfAbsent(main, 0);

        for (int i = 0; i < n; i++) {
            String s1 = in.nextToken();
            String s2 = in.nextToken();
            String s3 = in.nextToken();

            int val1 = tree.computeIfAbsent(s1, key -> tree.size() + 1);
            int val2 = tree.computeIfAbsent(s2, key -> tree.size() + 1);
            int val3 = tree.computeIfAbsent(s3, key -> tree.size() + 1);

            graph.computeIfAbsent(val1, key -> new LinkedHashSet<>());
            graph.computeIfAbsent(val2, key -> new LinkedHashSet<>());
            graph.computeIfAbsent(val3, key -> new LinkedHashSet<>());

            graph.get(val1).add(val2);
            graph.get(val1).add(val3);

            graph.get(val2).add(val1);
            graph.get(val2).add(val3);

            graph.get(val3).add(val1);
            graph.get(val3).add(val2);
        }

        if (!tree.containsKey(main)) {
            for (String s : tree.keySet())
                out.printf("%s undefined\n", s);
            return;
        }

        int[] idToSteps = new int[330];
        Arrays.fill(idToSteps, -1);

        bfs(tree.get(main), graph, idToSteps);

        for (String s : tree.keySet()) {
            int ind = tree.get(s);
            out.printf("%s ", s);
            if (idToSteps[ind] == -1) {
                out.println("undefined");
            } else {
                out.println(idToSteps[ind]);
            }
        }


    }

    private void bfs(Integer from, Map<Integer, Set<Integer>> graph, int[] idToSteps) {

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(from);
        used[from] = true;
        idToSteps[from] = 0;


        while (!deque.isEmpty()) {
            int curFrom = deque.removeFirst();
            for (int to : graph.get(curFrom)) {
                if (!used[to]) {
                    used[to] = true;
                    deque.addLast(to);
                    idToSteps[to] = idToSteps[curFrom] + 1;
                }
            }
        }

    }
}
