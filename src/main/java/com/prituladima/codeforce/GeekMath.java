package com.prituladima.codeforce;

import java.util.Arrays;
import java.util.Random;

//use long only
// TODO: 30.12.2018 Rename ti something like GeekLong
public class GeekMath {

    public static String toBitString(int number, int len) {
        String bits = Integer.toString(number, 2);
        StringBuilder sb = new StringBuilder();
        for (int toPrepend = len - bits.length(); toPrepend > 0; toPrepend--) {
            sb.append('0');
        }
        sb.append(bits);
        return sb.toString();
    }

    public static long multiplication(long modulo, long... arr){
        long ans = 1;
        for (long l : arr) {
            ans *= l;
            ans %= modulo;
        }
        return ans;
    }

    public static long ceiling(long n, long k) {
        return (n + k - 1) / k;
    }

    public static boolean equalParity(long a, long b){
        return a % 2 == b % 2;
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
