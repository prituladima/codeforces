package com.prituladima.codeforce;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GeekLong {

    public static Map<Long, Integer> toMultiSet(long[] arr) {
        Map<Long, Integer> multiSet = new HashMap<>();
        for (long i : arr) multiSet.merge(i, 1, Integer::sum);
        return multiSet;
    }

    public static long multiplication(long modulo, long... arr) {
        long ans = 1;
        for (long l : arr) {
            ans *= l % modulo;
            ans %= modulo;
        }
        return ans;
    }

    public static long ceiling(long n, long k) {
        return (n + k - 1) / k;
    }

    public static boolean equalParity(long a, long b) {
        return a % 2 == b % 2;
    }

    public static int upperBound(long[] array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) >>> 1;
            if (value >= array[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int lowerBound(long[] array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) >>> 1;
            if (value <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static long[] shuffle(long[] arr) {
        Random r = new Random();
        for (int i = 1, j; i < arr.length; i++) {
            j = r.nextInt(i);
            swap(arr, i, j);
        }
        return arr;
    }

    public static void save_sort(long[] array) {
        shuffle(array);
        Arrays.sort(array);
    }

    public static void swap(long[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
