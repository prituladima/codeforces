package com.prituladima.stankevich.data_stractures.priority_queue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.prituladima.geeksforgeeks.util.PrintWrapper.sout;
import static com.prituladima.geeksforgeeks.util.PrintWrapper.soutln;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.*;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.pair;
import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class HeapifyTest {

    private int[] array;
    private int[] heap;

    public HeapifyTest(int[] array, int[] heap) {
        this.array = array;
        this.heap = heap;
    }

    @Parameterized.Parameters(name = "{index}: HeapifyTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(array(5, 5, 7, 10, 7, 4, 9, 11), array(4, 5, 5, 7, 7, 9, 10, 11, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE)),
                item(array(5, 1, 8), array(1, 5, 8)),
                item(array(5, 8), array(5, 8, Integer.MAX_VALUE)),
                item(array(5), array(5)),
                item(array(0, 2), array(0, 2, Integer.MAX_VALUE)),
                item(array(5,5,7, 12), array(5,5,7, 12, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE)),
                item(array(10, 10, 10, 10, 10, 10, 10), array(10, 10, 10, 10, 10, 10, 10)),
                item(array(10, 10, 10, 10, 10, 10, 10, 12), array(10, 10, 10, 10, 10, 10, 10, 12, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE))
        );
    }


    @Test
    public void test_heapified_array(){
        soutln("START TEST");
        int[] actual = GeeksHeaps.heapify(array);
        soutln(array);
        soutln(heap);
        soutln(actual);
        assertArrayEquals(heap, GeeksHeaps.heapify(array));


        //must be power of 2
        int heapSize = actual.length + 1;
        soutln(heapSize);
        assertTrue(((heapSize & (~heapSize + 1)) == heapSize));


        soutln("END TEST");
    }

}