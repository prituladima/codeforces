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
 * todo write benchmark for it
 */
@RunWith(value = Parameterized.class)
public class AllHeapsTest {

    private int[] array;
    private int[] sorted;

    public AllHeapsTest(int[] array, int[] sorted) {
        this.array = array;
        this.sorted = sorted;
    }

    @Parameterized.Parameters(name = "{index}: AllHeapsTest")
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
        LeftistHeap leftistHeap = new LeftistHeap();

        soutln("SIZES");
        soutln( array.length + " " + sorted.length);
        assertEquals(array.length, sorted.length);

        int size = array.length;
        for(int i = 0; i < size; i++){
            javaPQ.add(array[i]);
            customPQ.add(array[i]);
            leftistHeap.add(array[i]);
        }
        soutln("LEFTIST HEAP AFTER INSERTION");
        soutln(leftistHeap);

        soutln("ARRAYS");
        soutln(array);
        soutln(sorted);

        for(int i = 0; i < size; i++){
            assertEquals((int)javaPQ.remove(), sorted[i]);
            assertEquals(customPQ.delete(), sorted[i]);
            assertEquals(leftistHeap.delete(), sorted[i]);
        }

        soutln("LEFTIST HEAP AFTER REMOVING");
        soutln(leftistHeap);

        //test twice
        for(int i = 0; i < size; i++){
            javaPQ.add(array[i]);
            customPQ.add(array[i]);
            leftistHeap.add(array[i]);
        }
        soutln("LEFTIST HEAP AFTER INSERTION");
        soutln(leftistHeap);

        for(int i = 0; i < size; i++){
            assertEquals((int)javaPQ.remove(), sorted[i]);
            assertEquals(customPQ.delete(), sorted[i]);
            assertEquals(leftistHeap.delete(), sorted[i]);
        }

        soutln("LEFTIST HEAP AFTER REMOVING");
        soutln(leftistHeap);

        //third test
        for(int i = 0; i < size; i++){
            javaPQ.add(array[i]);
            customPQ.add(array[i]);
            leftistHeap.add(array[i]);
            assertEquals((int)javaPQ.remove(), array[i]);
            assertEquals(customPQ.delete(), array[i]);
            assertEquals(leftistHeap.delete(), array[i]);
        }


        soutln("END TEST");
    }
}