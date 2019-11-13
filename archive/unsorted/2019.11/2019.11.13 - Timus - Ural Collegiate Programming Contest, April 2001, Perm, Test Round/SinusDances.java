package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

public class SinusDances {

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int N = in.nextInt();

        List<Character> res = new ArrayList<>();
        S(N, 1, res);

        res.forEach(out::print);
        out.println();

    }


    private void S(int N, int plus, List<Character> list) {
        if(N == 1){
            char[] chars = String.format("sin(1)+%d", plus).toCharArray();
            for (char ch : chars)
                list.add(ch);

        }else {

            List<Character> A = new ArrayList<>();
            A(1, N, A);


            list.add('(');
            S(N - 1, plus + 1, list);
            list.add(')');
            list.addAll(A);

            list.add('+');
            char[] chars = String.valueOf(plus).toCharArray();
            for (char ch : chars)
                list.add(ch);
        }

    }
    
    private void A(int from, int to, List<Character> list) {
        if (from == to) {
            char[] res = String.format("sin(%d)", to).toCharArray();
            for (char re : res)
                list.add(re);
        } else {
            char sign = from % 2 == 0 ? '+' : '-';

            char[] res = String.format("sin(%d%c", from, sign).toCharArray();
            for (char re : res)
                list.add(re);
            A(from + 1, to, list);
            char end = ')';
            list.add(end);

        }
    }
}
