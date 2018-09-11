package com.prituladima.stankevich.data_stractures.priority_queue;

import java.util.Arrays;

public class GeeksHeaps {

    protected static int[] heapify(int[] array) {

        int i = array.length - 1;
        int level = 0;

        while (i > 0){
            if(i % 2 == 0){
                i -= 2;
            }else {
                i -= 1;
            }
            i >>= 1;
            level++;
        }

        int j = 0;
        while (level > 0){
            j <<= 1;
            j += 2;
            level--;
        }

        int[] heapifiedArray = new int[j + 1];

        Arrays.sort(array);

        int index = 0;
        for (int k = 0; k < array.length; k++) {
            heapifiedArray[index++] = array[k];
        }

        for (int k = index; k < heapifiedArray.length; k++) {
            heapifiedArray[k] = Integer.MAX_VALUE;
        }

        return heapifiedArray;
    }

}
