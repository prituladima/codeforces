package com.prituladima.geeksforgeeks.util;

/**
 * Created by prituladima on 6/12/18.
 */
public class Util {

    public static int[][] matrix(int[]... lines) {
        int[][] matrix = new int[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            matrix[i] = lines[i];
        }
        return matrix;
    }

    public static int[] array(int... item) {
        int[] array = new int[item.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = item[i];
        }
        return array;
    }


}
