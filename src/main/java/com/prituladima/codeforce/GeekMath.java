package com.prituladima.codeforce;

import java.util.Arrays;
import java.util.Random;

public class GeekMath {

    public static long ceiling(long n, long k) {
        return (n + k - 1) / k;
    }


    public static int upperBound(int[] array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value >= array[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int lowerBound(int[] array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


    long[] shuffle(long[] arr) {
        Random r = new Random();
        for (int i = 1, j; i < arr.length; i++) {
            j = r.nextInt(i);
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
        return arr;
    }

    int[] uniq(int[] arr) {
        Arrays.sort(arr);
        int[] rv = new int[arr.length];
        int pos = 0;
        rv[pos++] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                rv[pos++] = arr[i];
            }
        }
        return Arrays.copyOf(rv, pos);
    }


}
