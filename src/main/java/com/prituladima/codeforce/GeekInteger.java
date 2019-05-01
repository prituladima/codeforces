package com.prituladima.codeforce;

import com.prituladima.Naive;
import com.prituladima.Reliable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GeekInteger {

    public static int max(int... a){
        return Arrays.stream(a).max().getAsInt();
    }

    public static int min(int... a){
        return Arrays.stream(a).min().getAsInt();
    }

    public static int sum(int... a){
        return Arrays.stream(a).sum();
    }

    public static long max(long... a){
        return Arrays.stream(a).max().getAsLong();
    }

    public static long min(long... a){
        return Arrays.stream(a).min().getAsLong();
    }

    public static long sum(long... a){
        return Arrays.stream(a).sum();
    }


    public static int posMod(int a, int b) {
        return (a % b + b) % b;
    }

    public static List<Integer> toList(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        for (int i : arr) ans.add(i);
        return ans;
    }

    public static Set<Integer> toHashSet(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        for (int i : uniq(arr)) ans.add(i);
        return ans;
    }

    public static int[] toArray(Collection<Integer> collection) {
        int[] array = new int[collection.size()];
        int k = 0;
        for (int cur : collection) array[k++] = cur;
        return array;
    }

    public static long[] calculatePrefixSum(long[] a) {
        long[] pref = new long[a.length];
        pref[0] = a[0];
        for (int i = 1; i < a.length; i++) pref[i] = pref[i - 1] + a[i];
        return pref;
    }

    public static long[] calculateSuffixSum(long[] a) {
        long[] suff = new long[a.length];
        suff[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) suff[i] = suff[i + 1] + a[i];
        return suff;
    }

    public static long[] calculateRemSum(long[] pref, long[] suff) {
        int len = pref.length;
        long[] rem = new long[len];
        for (int i = 0; i < len; i++) {
            rem[i] = 0;
            if (i > 0) {
                rem[i] += pref[i - 1];
            }
            if (i < len - 1) {
                rem[i] += suff[i + 1];
            }
        }
        return rem;
    }

    public static int[] calculatePrefixSum(int[] a) {
        int[] pref = new int[a.length];
        pref[0] = a[0];
        for (int i = 1; i < a.length; i++) pref[i] = pref[i - 1] + a[i];
        return pref;
    }

    public static int[] calculateSuffixSum(int[] a) {
        int[] suff = new int[a.length];
        suff[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) suff[i] = suff[i + 1] + a[i];
        return suff;
    }

    public static int[] calculateRemSum(int[] pref, int[] suff) {
        int len = pref.length;
        int[] rem = new int[len];
        for (int i = 0; i < len; i++) {
            rem[i] = 0;
            if (i > 0) {
                rem[i] += pref[i - 1];
            }
            if (i < len - 1) {
                rem[i] += suff[i + 1];
            }
        }
        return rem;
    }

    public static Map<Integer, Integer> multiSet(int[] arr) {
        Map<Integer, Integer> co = new HashMap<>();
        for (int i : arr) co.merge(i, 1, Integer::sum);
        return co;
    }

    public static Map<Long, Integer> multiSet(long[] arr) {
        Map<Long, Integer> co = new HashMap<>();
        for (long i : arr) co.merge(i, 1, Integer::sum);
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

    @Deprecated
    public static long multiplication(long modulo, List<Long> list) {
        long[] arr = new long[list.size()];
        int k = 0;
        for (long i : list)
            arr[k++] = i;

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

    @Reliable
    public static long ceilingDivide(long n, long k) {
        return (n + k - 1) / k;
    }

    @Reliable
    public static int ceilingDivide(int n, int k) {
        return (n + k - 1) / k;
    }

    @Reliable
    public static boolean equalParity(long a, long b) {
        return a % 2 == b % 2;
    }

    public static int upperBound(int[] array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (value >= array[mid])
                low = mid + 1;
            else
                high = mid;

        }
        return low;
    }

    public static int upperBound(long[] array, int length, long value) {
        int low = 0;
        int high = length;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (value >= array[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public static int lowerBound(int[] array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (value <= array[mid])
                high = mid;
            else
                low = mid + 1;

        }
        return low;
    }

    public static int lowerBound(long[] array, int length, long value) {
        int low = 0;
        int high = length;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (value <= array[mid])
                high = mid;
            else
                low = mid + 1;

        }
        return low;
    }

    @Reliable
    public static void save_sort(int[] array) {
        shuffle(array);
        Arrays.sort(array);
    }

    @Reliable
    public static int[] shuffle(int[] array) {
        int n = array.length;
        Random random = new Random();
        for (int i = 0, j; i < n; i++) {
            j = i + random.nextInt(n - i);
            int randomElement = array[j];
            array[j] = array[i];
            array[i] = randomElement;
        }
        return array;
    }

    public static char[] shuffle(char[] array) {
        int n = array.length;
        Random random = new Random();
        for (int i = 0, j; i < n; i++) {
            j = i + random.nextInt(n - i);
            char randomElement = array[j];
            array[j] = array[i];
            array[i] = randomElement;
        }
        return array;
    }

    @Reliable
    public static int[] uniq(int[] arr) {
        arr = arr.clone();
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

    public static char[] uniq(char[] arr) {
        arr = arr.clone();
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

    @Naive
    public static int[] uniqUsingSet(int[] array) {
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

    @Reliable
    @Naive
    public static List<List<Integer>> getAllPermutationsUpTo(int upTo) {
        int[] array = new int[upTo];
        for (int i = 0; i < upTo; i++) {
            array[i] = i;
        }
        List<List<Integer>> perm = new ArrayList<>();
        permute(array, 0, array.length - 1, perm);
        return perm;
    }

    private static void permute(int[] a, int l, int r, List<List<Integer>> perm) {
        int i;
        if (l == r)
            perm.add(Arrays.stream(a).boxed().collect(Collectors.toList()));
        else {
            for (i = l; i <= r; i++) {
                swap(a, l, i);
                permute(a, l + 1, r, perm);
                swap(a, l, i); //backtrack
            }
        }
    }


    private static void swap(int[] a, int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] ints = IntStream.range(0, 11).toArray();
        System.out.println(Arrays.toString(ints));
        shuffle(ints);
        System.out.println(Arrays.toString(ints));
    }

}
