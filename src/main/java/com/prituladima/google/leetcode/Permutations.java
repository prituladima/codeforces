package com.prituladima.google.leetcode;

import java.util.*;

public class Permutations {

    // C++ program to print all
// permutations with duplicates allowed
//#include<bits/stdc++.h>
//    using namespace
//    std;

    public static void main(String[] args) {
        final char[] a = "ABCC".toCharArray();
        Arrays.sort(a);
        new Permutations().permute(a);
    }

    // Function to print permutations of string
// This function takes three parameters:
// 1. String
// 2. Starting index of the string
// 3. Ending index of the string.

    Map<Character, Integer> counter = new TreeMap<>();
    Map<Character, Integer> counterH = new HashMap<>();
    List<String> ans = new ArrayList<>();

    void permute(char[] a) {

        for (char c : a) {
            counter.merge(c, 1, Integer::sum);
            counterH.merge(c, 1, Integer::sum);
        }
        final int size = counter.size();
        char[] arrToPerm = new char[size];
        int p = 0;
        for (Character c : counter.keySet()) {
            arrToPerm[p++] = c;
        }

        permute(arrToPerm, 0);

        ans.forEach(System.out::println);
    }

    void permute(char[] a, int l) {

        // Base case
        if (l == a.length - 1) {
            StringBuilder sb = new StringBuilder();
            for (char c : a) {
                int amount = counterH.get(c);
                while (amount-- > 0) sb.append(c);
            }
            ans.add(sb.toString());
        } else {
            // Permutations made
            for (int i = l; i <= a.length - 1; i++) {

                // Swapping done
                swap(a, l, i);

                // Recursion called
                permute(a, l + 1);

                //backtrack
                swap(a, l, i);

            }
        }
    }


    private void swap(char[] a, int l, int i) {
        char c = a[l];
        a[l] = a[i];
        a[i] = c;
    }

    // Driver Code
//    int main()
//    {
//        string str = "ABC";
//        int n = str.size();
//        permute(str, 0, n-1);
//        return 0;
//    }

// This is code is contributed by rathbhupendra


}
