package com.prituladima.stankevich.data_stractures.priority_queue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Random;

import static com.prituladima.geeksforgeeks.util.TestSetWrapper.array;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.item;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.testSet;
import static org.junit.Assert.*;
import static com.prituladima.geeksforgeeks.util.PrintWrapper.soutln;

@RunWith(value = Parameterized.class)
public class LeftistHeapCorrectnessTest {

    private int generated_size;

    public LeftistHeapCorrectnessTest(int generated_size) {
        this.generated_size = generated_size;
    }

    @Parameterized.Parameters(name = "{index}: LeftistHeapCorrectnessTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(1),
                item(2),
                item(3),
                item(4),
                item(10),
                item(100),
                item(1000),
                item(10000)
        );
    }

    @Test
    public void test_leftist_heap_property() {

        soutln("START TEST");
        LeftistHeap leftistHeap = new LeftistHeap();

        int[] randomNumbers = new int[generated_size];
        Random r = new Random();
        for (int i = 0; i < generated_size; i++) {
            randomNumbers[i] = r.nextInt(1000);
        }

        leftistHeap.add(randomNumbers);

        //heap property test
        soutln("HEAP REPRESENTATION");
        soutln(leftistHeap);


        assertLeftistNode(leftistHeap.root);


        soutln("END TEST");

    }

    private void assertLeftistNode(LeftistHeap.Node current) {
        if (current.left == null) {
            assertNull(current.right);
        } else if (current.right != null) {
            assertTrue(current.left.s >= current.right.s);
            assertLeftistNode(current.left);
            assertLeftistNode(current.right);
        } else {
            assertLeftistNode(current.left);
        }
    }

}