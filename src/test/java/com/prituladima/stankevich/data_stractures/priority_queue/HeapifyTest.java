package com.prituladima.stankevich.data_stractures.priority_queue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static com.prituladima.geeksforgeeks.util.PrintWrapper.soutln;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.*;
import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class HeapifyTest {

    private int[] array;

    public HeapifyTest(int[] array) {
        this.array = array;
    }

    @Parameterized.Parameters(name = "{index}: HeapifyTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(array(5, 5, 7, 10, 7, 4, 9, 11)),
                item(array(5, 1, 8)),
                item(array(5, 8)),
                item(array(5)),
                item(array(0, 2)),
                item(array(5,5,7, 12)),
                item(array(10, 10, 10, 10, 10, 10, 10)),
                item(array(10, 10, 10, 10, 10, 10, 10, 12))
        );
    }


    @Test
    public void test_heapified_array(){
        soutln("START TEST");
        int[] heap = GeeksHeaps.heapify(array);
        soutln(array);
        soutln(heap);
        assertArrayEquals(heap, GeeksHeaps.heapify(array));


        //must be power of 2
        int heapSize = heap.length + 1;
        soutln(heapSize);
        assertTrue(((heapSize & (~heapSize + 1)) == heapSize));

        //must be heap ordering
        for(int i = heap.length - 1; i > 0; i--){
            assertTrue(heap[i] >= heap[GeeksHeaps.getParent(i)]);
        }


        soutln("END TEST");
    }

}