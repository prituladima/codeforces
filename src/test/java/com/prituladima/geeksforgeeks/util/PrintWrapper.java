package com.prituladima.geeksforgeeks.util;

import java.util.Arrays;

import static java.util.stream.IntStream.range;
import static java.lang.System.out;

/**
 * Created by prituladima on 6/13/18.
 */
public class PrintWrapper {

    public static void soutln(int[][] mtx) {
        range(0, mtx.length).forEach(i -> soutln(mtx[i]));
    }

    public static void soutln(long[][] mtx) {
        range(0, mtx.length).forEach(i -> soutln(mtx[i]));
    }

    public static void soutln(int[] arr) {
        soutln(Arrays.toString(arr));
    }

    public static void soutln(long[] arr) {
        soutln(Arrays.toString(arr));
    }

    public static void soutln(Object o) {
        sout(o);
        newLine();
    }

    private static void newLine() {
        sout('\n');
    }


    public static void sout(Object o) {
        out.print(o);
    }

    private static void souf(String format, Object... args) {
        out.printf(format, args);
    }

}
