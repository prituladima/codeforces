package com.prituladima.codeforce.util;

import java.util.Arrays;
import java.util.Random;

public class Sorting {


    static int[] amounts = {10, 100, 1000, 10_000, 100_000, 1_000_000, 10_000_000};


    public static void main(String[] args) {

        for (int i = 0; i < amounts.length; i++) {

            System.out.printf("---------- Start for %d amount ---------\n", amounts[i]);

            System.out.printf("---------- Gen for %d amount ---------\n", amounts[i]);

            Random random = new Random();
            int[] array = new int[amounts[i]];
            long start;
            long stop;

            for (int i1 = 0; i1 < amounts[i]; i1++) {
                array[i1] = random.nextInt();
            }


            int[] copy1 = Arrays.copyOf(array, array.length);


            start = System.currentTimeMillis();

            Arrays.sort(copy1);

            stop = System.currentTimeMillis();


            System.out.println("---------- Time for --------- " +  (stop - start));


            int[] copy2 = Arrays.copyOf(array, array.length);


            start = System.currentTimeMillis();

            quickSort(copy2);

            stop = System.currentTimeMillis();


            System.out.println("---------- Time for --------- " +  (stop - start));


        }


    }

    private static void quickSort(int[] array){
        quickSort(array,        0, array.length-1);
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i] <= array[cur])) {
                i++;
            }
            while (j > cur && (array[cur] <= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        quickSort(array, start, cur);
        quickSort(array, cur+1, end);
    }


}
