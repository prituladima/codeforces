package com.prituladima.stankevich.data_stractures.priority_queue;

import java.util.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import static com.prituladima.geeksforgeeks.util.PrintWrapper.soutln;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.*;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.array;
import static org.junit.Assert.*;

/**
 * Created by prituladima on 9/11/18.
 */
@RunWith(value = Parameterized.class)
public class BinaryHeapTest {

    private int[] array;
    private int[] prioritedArray;

    public BinaryHeapTest(int[] array, int[] prioritedArray) {
        this.array = array;
        this.prioritedArray = prioritedArray;
    }

    @Parameterized.Parameters(name = "{index}: BinaryHeapTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(array(5), array(5)),
                item(array(Integer.MAX_VALUE), array(Integer.MAX_VALUE)),
                item(array(5, 10), array(5, 10)),
                item(array(10, 5), array(5, 10)),
                item(array(9, 8, 7, 6, 5, 4, 3, 2, 1), array(1, 2, 3, 4, 5, 6, 7, 8, 9)),
                item(array(17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1),
                        array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17)),
                item(array(1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000),
                        array(1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000)),
                item(array(10001000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 10001000),
                        array(1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 10001000, 10001000))
                );
    }


    @Test
    public void test_custom_priority_queue() {
        soutln("START TEST");
        PriorityQueue<Integer> javaPQ = new PriorityQueue<>();
        BinaryHeap customPQ = new BinaryHeap();

        soutln( array.length + " " + prioritedArray.length);
        assertEquals(array.length, prioritedArray.length);

        int size = array.length;
        for(int i = 0; i < size; i++){
            javaPQ.add(array[i]);
            customPQ.add(array[i]);
        }

        soutln(array);
        soutln(prioritedArray);
        for(int i = 0; i < size; i++){
            assertEquals((int)javaPQ.remove(), prioritedArray[i]);
            assertEquals(customPQ.delete(), prioritedArray[i]);
        }

        //test twice
        for(int i = 0; i < size; i++){
            javaPQ.add(array[i]);
            customPQ.add(array[i]);
        }

        for(int i = 0; i < size; i++){
            assertEquals((int)javaPQ.remove(), prioritedArray[i]);
            assertEquals(customPQ.delete(), prioritedArray[i]);
        }


        soutln("END TEST");
    }
}