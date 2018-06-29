package com.prituladima.codeforce.a2oj.div2A;

import java.io.*;
import java.util.*;

import static java.util.stream.IntStream.range;
import static java.lang.System.out;

/**
 * Created by prituladima on 6/28/18.
 */
public class Pro32 {

    private void solve() {

        int n = nextInt(), v = nextInt();

        List<Integer> sellers = new ArrayList<>();

        range(1, n + 1)
                .filter(i -> v > range(0, nextInt()).map(j -> nextInt()).min().getAsInt())
                .forEach(sellers::add);

        out.println(sellers.size());
        sellers.forEach(x -> out.print(x + " "));

    }

    public static void main(String[] args) {
        new Pro32().solve();
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;
    StringTokenizer tokenizer;

    int nextInt() {
        return Integer.parseInt(nextToken());
    }

    String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

}
