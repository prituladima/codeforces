package com.prituladima.codeforce;

import java.util.*;

public class GeekLong {

    public static long binpow(long a, long n) {
        long res = 1;
        while (n > 0) {
            res = (n & 1) != 0 ? (res * a) : 1;
            n >>= 1;
            a *= a;
        }
        return res;
    }

    public static long binpowmod(long a, long n, long modulo) {
        long res = 1;
        a %= modulo;
        while (n > 0) {
            res = (n & 1) != 0 ? (res * a) % modulo : 1;
            n >>= 1;
            a *= a;
            a %= modulo;
        }
        return res;
    }

    public static long positiveMod(long a, long b) {
        return (a % b + b) % b;
    }

    public static List<Long> toList(long[] arr) {
        List<Long> ans = new ArrayList<>();
        for (long i : arr) ans.add(i);
        return ans;
    }

    public static Set<Long> toHashSet(long[] arr) {
        Set<Long> ans = new HashSet<>();
        for (long i : uniq(arr)) ans.add(i);
        return ans;
    }

    public static long[] toArray(Collection<Long> collection) {
        long[] array = new long[collection.size()];
        int k = 0;
        for (long cur : collection) array[k++] = cur;
        return array;
    }

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

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void swap(long[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    static long[] uniq(long[] arr) {
        shuffle(arr);
        Arrays.sort(arr);
        int pos = 0;
        arr[pos++] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[pos++] = arr[i];
            }
        }
        return Arrays.copyOf(arr, pos);
    }

}
