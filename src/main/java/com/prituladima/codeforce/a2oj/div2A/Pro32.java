package com.prituladima.codeforce.a2oj.div2A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.util.stream.IntStream.range;

/**
 * Created by prituladima on 6/28/18.
 */
public class Pro32 {

    private void solve() {

        int n = nextInt(), v = nextInt();

        List<Integer> sellers = range(1, n + 1)
                .filter(
                        i -> v > range(0, nextInt())
                                .map(j -> nextInt())
                                .min()
                                .getAsInt()
                )
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        out.println(sellers.size());
        sellers.forEach(x -> out.print(x + " "));

    }

    public static void main(String[] args) {
        new Pro32().solve();
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ;
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
