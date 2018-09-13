package com.prituladima.stankevich.data_stractures.priority_queue;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Random;

import static com.prituladima.geeksforgeeks.util.PrintWrapper.soutln;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.item;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.testSet;

@RunWith(value = Parameterized.class)
public class LeftistHeapFromArrayBenchmarkTest {

    private int generated_size;
    private int[] randomNumbers;

    public LeftistHeapFromArrayBenchmarkTest(int generated_size) {
        this.generated_size = generated_size;
        randomNumbers = new int[generated_size];
        Random r = new Random();
        for (int i = 0; i < generated_size; i++) {
            randomNumbers[i] = r.nextInt(1000);
        }
    }

    @Parameterized.Parameters(name = "{index}: LeftistHeapFromArrayBenchmarkTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(10000000),
                item(10000000),
                item(10000000),
                item(10000000),
                item(10000000),
                item(10000000),
                item(10000000),
                item(10000000)
        );
    }

    @Test
    public void test_() {

        LeftistHeap leftistHeap = new LeftistHeap();
        LeftistHeap leftistHeap1 = new LeftistHeap();
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        BinaryHeap binaryHeap = new BinaryHeap();

        long current_time = System.currentTimeMillis();


        leftistHeap.add(randomNumbers);


        soutln("O(n*log(n)) - " + (System.currentTimeMillis() - current_time));


        current_time = System.currentTimeMillis();


        int op = leftistHeap1.add_fast(randomNumbers);

        soutln("O(n) - " + (System.currentTimeMillis() - current_time) + " - " + op);




        current_time = System.currentTimeMillis();

        for (int i = 0; i < generated_size; i++) {
            PQ.add(randomNumbers[i]);
        }

        soutln("PriorityQueue - " + (System.currentTimeMillis() - current_time) );


        current_time = System.currentTimeMillis();

        for (int i = 0; i < generated_size; i++) {
            binaryHeap.add(randomNumbers[i]);
        }

        soutln("binaryHeap - n*log(n) " + (System.currentTimeMillis() - current_time) );


        current_time = System.currentTimeMillis();


        BinaryHeap binaryHeap1 = new BinaryHeap(randomNumbers);

        soutln("binaryHeap - n " + (System.currentTimeMillis() - current_time) );

    }

}
