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

    public static int[][] asArray(int[]... lines){
        return matrix(lines);
    }


    public static int[] segment(int x1, int x2){
        return array(x1, x2);
    }

    public static int[][] segment(int[] p, int[] q){
        return matrix(p, q);
    }

    public static int[] point(int x, int y, int z){
        return array(x, y, z);
    }

    public static int[] point(int x, int y){
        return array(x, y);
    }


}
