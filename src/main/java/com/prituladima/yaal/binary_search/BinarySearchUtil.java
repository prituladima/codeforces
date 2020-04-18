package com.prituladima.yaal.binary_search;

import java.util.function.Function;
import java.util.function.Predicate;

public class BinarySearchUtil {

    //Algo that helps to find the rightmost answer in array
    public static int upperBound(int[] a, int value) {
        //Impossible bounds
        int l = -1;
        int r = a.length;
        //Invariant that semi-interval [l, r) length is more than 1
        while (r - l > 1) {
            int m = l + (r - l) / 2;//To prevent overflow
            if (a[m] < value)//function
                l = m;//Left bound is on
            else
                r = m;//Right bound is off
        }
        //Invariant broken we now have semi-interval
        //with len 1. [l, r) where l s the answer.
        //We must check if this l != -1
        //If we were looking for specific value we must check it.
        return l;//
    }

    //Algo that helps to find the leftmost answer in array
    public static int lowerBound(int[] a, int value) {
        //Impossible bounds
        int l = -1;
        int r = a.length;
        //Invariant that semi-interval (l, r] length is more than 1
        while (r - l > 1) {
            int m = l + (r - l) / 2;//To prevent overflow
            if (a[m] >= value)//function
                r = m;//Right bound is on
            else
                l = m;//Left bound is off
        }
        //Invariant broken we now have semi-interval
        //with length 1. (l, r] where r is the answer.
        //We must check if this r != a.length
        //If we were looking for specific value we must check it.
        return r;
    }

    public int upperBound(int inclusiveLeft, int exclusiveRight, Function<Integer, Integer> function, Predicate<Integer> predicate) {
        while (exclusiveRight - inclusiveLeft > 1) {
            int middle = inclusiveLeft + (exclusiveRight - inclusiveLeft) / 2;
            if (predicate.test(function.apply(middle))) {
                inclusiveLeft = middle;
            } else {
                exclusiveRight = middle;
            }
        }
        return inclusiveLeft;
    }

    public int lowerBound(int exclusiveLeft, int inclusiveRight, Function<Integer, Integer> function, Predicate<Integer> predicate) {
        while (inclusiveRight - exclusiveLeft > 1) {
            int middle = exclusiveLeft + (inclusiveRight - exclusiveLeft) / 2;
            if (predicate.test(function.apply(middle))) {
                inclusiveRight = middle;
            } else {
                exclusiveLeft = middle;
            }
        }
        return inclusiveRight;
    }


    public static void main(String[] args) {



    }



}
