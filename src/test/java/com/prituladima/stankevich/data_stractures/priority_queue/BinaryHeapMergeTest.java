package com.prituladima.stankevich.data_stractures.priority_queue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.PriorityQueue;

import static com.prituladima.geeksforgeeks.util.PrintWrapper.soutln;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.array;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.item;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.testSet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(value = Parameterized.class)
public class BinaryHeapMergeTest {

    private int[] A;
    private int[] B;

    public BinaryHeapMergeTest(int[] A, int[] B) {
        this.A = A;
        this.B = B;
    }

    @Parameterized.Parameters(name = "{index}: BinaryHeapMergeTest")
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

        soutln( A.length + " " + B.length);
        soutln(A);
        soutln(B);

        BinaryHeap binaryHeapA = new BinaryHeap(A);
        BinaryHeap binaryHeapB = new BinaryHeap(B);
        BinaryHeap mergedBinaryHeap = BinaryHeap.meld(binaryHeapA, binaryHeapB);

        int[] merged = mergedBinaryHeap.toHeapArray();

        soutln("Data");
        soutln(binaryHeapA.toNiceString());
        soutln("B");
        soutln(binaryHeapB.toNiceString());
        soutln("MERGED");
        soutln(mergedBinaryHeap.toNiceString());

        //must be power of 2
        int heapSize = merged.length + 1;
        soutln(heapSize);
        assertTrue(((heapSize & (~heapSize + 1)) == heapSize));

        //must be heap ordering
        for(int i = merged.length - 1; i > 0; i--){
            assertTrue(merged[i] >= merged[GeeksHeaps.getParent(i)]);
        }

        soutln("END TEST");
    }

}
