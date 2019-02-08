package com.prituladima.codeforce.contests.contest1036;

import java.util.Arrays;

public class Test {
    static int[] arr = new int[]{0, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        arr = new int[1000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }


        System.out.println(UPPER_BOUND(arr, 1));
        System.out.println(UPPER_BOUND(arr, 2));
        System.out.println(UPPER_BOUND(arr, 3));
        System.out.println(UPPER_BOUND(arr, 1000));
        System.out.println(UPPER_BOUND(arr, -1));
        System.out.println(UPPER_BOUND(arr, -100));
        System.out.println(UPPER_BOUND(arr, -20));
        System.out.println(UPPER_BOUND(arr, -20000));
        System.out.println(UPPER_BOUND(arr, 1000000));


        int L = 1;
        int R = 1000;
        System.out.println(SOLVE_FOR_RANGE(L, R));
    }


    static int SOLVE_FOR_RANGE(int L, int R) {
        return SOLVE_FOR_NUMBER(R) - SOLVE_FOR_NUMBER(L - 1);
    }

    static int SOLVE_FOR_NUMBER(int V) {
        return UPPER_BOUND(arr, V);
    }

    static int UPPER_BOUND(int[] array, int value) {
        int index = Arrays.binarySearch(array, value);
        if (index < 0) index = -(index + 1);
        return index;
    }

}
