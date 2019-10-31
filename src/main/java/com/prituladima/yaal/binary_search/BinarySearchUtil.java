package com.prituladima.yaal.binary_search;

// TODO: 10/31/2019
//  what if: dec order of array
//  be able to customize <, <= in upper bound
//  be able to customize >, >= in lower bound
public class BinarySearchUtil {

    //Algo that helps to find the rightmost answer in array
    public static int upperBound(int[] a, int value) {
        //Impossible bounds
        int l = -1;
        int r = a.length;
        //Invariant that semi-interval [l, r) length is more than 1
        while (r - l > 1) {
            int m = l + (r - l) >> 1;//To prevent overflow
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
            int m = l + (r - l) >> 1;//To prevent overflow
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

    public static void main(String[] args) {



    }



}
