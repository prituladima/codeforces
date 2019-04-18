package com.prituladima.stankevich.data_stractures.priority_queue;


import java.util.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.prituladima.geeksforgeeks.util.PrintWrapper.soutln;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.item;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.testSet;
@Ignore
@RunWith(value = Parameterized.class)
public class LeftistHeapFromArrayBenchmarkTest {

    private int generated_size;
    private int[] randomNumbers;
    private ArrayList<Integer> randomNumbersList;
    private ArrayList<Double> randomNumbersListPriority;

    public LeftistHeapFromArrayBenchmarkTest(int generated_size) {
        this.generated_size = generated_size;
        randomNumbers = new int[generated_size];
        randomNumbersList = new ArrayList<>();
        randomNumbersListPriority = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < generated_size; i++) {
            randomNumbers[i] = r.nextInt(1000);
            randomNumbersList.add(randomNumbers[i]);
            randomNumbersListPriority.add((double)randomNumbers[i]);
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
    public void test_heaps_init() {

        LeftistHeap leftistHeap = new LeftistHeap();
        LeftistHeap leftistHeap1 = new LeftistHeap();
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
//        PriorityQueue<Integer> pr_fast = new PriorityQueue<>(ar, comp) {
//            PriorityQueue(List<edge> ar, Comparator<edge> c) {
//                this(c);
//                for(int i = 0; i < queue.length; i++) {
//                    queue[i] = ar.get(i);
//                }
//                this.size = queue.length;
//                heapify(); // O(n), except that heapify is private and thus you can't call it!!!
//            }
//        }
        BinaryHeap binaryHeap = new BinaryHeap();

        long current_time = System.currentTimeMillis();
        leftistHeap.add(randomNumbers);
        soutln("Leftist heap init - O(n*log(n)) - " + (System.currentTimeMillis() - current_time));

        current_time = System.currentTimeMillis();
        int op = leftistHeap1.add_fast(randomNumbers);
        soutln("Leftist heap init - O(n) - " + (System.currentTimeMillis() - current_time) + " - " + op + " - probably wrong?");

        soutln("");

        current_time = System.currentTimeMillis();
        new PriorityQueue<>(randomNumbersList);
        soutln("PriorityQueue - O(n) - " + (System.currentTimeMillis() - current_time) );


        current_time = System.currentTimeMillis();
        for (int i = 0; i < generated_size; i++) {
            PQ.add(randomNumbers[i]);
        }
        soutln("PriorityQueue -  O(n*log(n)) - " + (System.currentTimeMillis() - current_time) );

        soutln("");

        current_time = System.currentTimeMillis();
        for (int i = 0; i < generated_size; i++) {
            binaryHeap.add(randomNumbers[i]);
        }
        soutln("binaryHeap - n*log(n) " + (System.currentTimeMillis() - current_time) );


        current_time = System.currentTimeMillis();
        BinaryHeap binaryHeap1 = new BinaryHeap(randomNumbers);
        soutln("binaryHeap - n " + (System.currentTimeMillis() - current_time) );

        current_time = System.currentTimeMillis();
        FibonacciHeap<Integer> fibonacciHeap = new FibonacciHeap<>();
        for (int i = 0; i < generated_size; i++) {
//            binaryHeap.add(randomNumbers[i]);
            fibonacciHeap.enqueue(randomNumbers[i], randomNumbersListPriority.get(i));
        }
        soutln("fibonacciHeap - O(n)* " + (System.currentTimeMillis() - current_time) );
    }

}
