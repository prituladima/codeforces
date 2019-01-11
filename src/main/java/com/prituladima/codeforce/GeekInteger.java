package com.prituladima.codeforce;

import java.util.*;

//use long only
// TODO: 30.12.2018 Rename ti something like GeekLong
public class GeekInteger {

    public static Map<Integer, Integer> multiSet(int[] arr) {
        Map<Integer, Integer> co = new HashMap<>();
        for (int i : arr) co.merge(i, 1, Integer::sum);
        return co;
    }

    @Deprecated
    public static String toBitString(int number, int len) {
        String bits = Integer.toString(number, 2);
        StringBuilder sb = new StringBuilder();
        for (int toPrepend = len - bits.length(); toPrepend > 0; toPrepend--) {
            sb.append('0');
        }
        sb.append(bits);
        return sb.toString();
    }

    public static long multiplication(long modulo, List<Long> list) {
        long[] arr = new long[list.size()];
        int k = 0;
        for (long i : list) {
            arr[k++] = i;
        }
        return multiplication(modulo, arr);
    }

    public static long multiplication(long modulo, long... arr) {
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

    public static int ceiling(int n, int k) {
        return (n + k - 1) / k;
    }

    public static boolean equalParity(long a, long b) {
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


    public static long[] shuffle(long[] arr) {
        Random r = new Random();
        for (int i = 1, j; i < arr.length; i++) {
            j = r.nextInt(i);
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
        return arr;
    }

    public static void save_sort(int[] array) {
        shuffle(array);
        Arrays.sort(array);
    }

    public static int[] shuffle(int[] arr) {
        Random r = new Random();
        for (int i = 1, j; i < arr.length; i++) {
            j = r.nextInt(i);
            swap(arr, i, j);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


    static int[] uniq(int[] arr) {
//        GeekInteger.shuffle(arr);
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

    static int[] uniqUsingSet(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        int[] new_array = new int[set.size()];
        for (int i = 0; i < list.size(); i++) {
            new_array[i] = list.get(i);
        }
        return new_array;
    }

    public static int[] toArray(Set<Integer> set) {
        int[] a = new int[set.size()];
        int k = 0;
        for (int cur : set) {
            a[k++] = cur;
        }
        return a;
//        set.stream().collect(Collectors.toList()).
    }


    public static long gcd(long[] a) {
        long gcd = 0;
        for (long i : a) gcd = gcd(gcd, i);
        return gcd;
    }


    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int gcd(int[] a) {
        int gcd = 0;
        for (int i : a) gcd = gcd(gcd, i);
        return gcd;
    }


    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


}
