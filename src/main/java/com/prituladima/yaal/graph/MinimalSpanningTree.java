package com.prituladima.yaal.graph;

import com.prituladima.yaal.collections.iss.IndependentSetSystem;
import com.prituladima.yaal.collections.iss.RecursiveIndependentSetSystem;
import com.prituladima.yaal.generated.collections.comparator.IntComparator;
import com.prituladima.yaal.generated.collections.set.IntHashSet;
import com.prituladima.yaal.generated.collections.set.IntSet;
import com.prituladima.yaal.misc.ArrayUtils;
import com.prituladima.yaal.numbers.IntegerUtils;

/**
 *  */
public class MinimalSpanningTree {
    public static IntSet minimalTree(final BidirectionalGraph graph) {
        IntSet result = new IntHashSet(graph.vertexCount - 1);
        int[] edgeOrder = new int[graph.edgeCount >> 1];
        for (int i = 0; i < edgeOrder.length; i++) {
            edgeOrder[i] = i << 1;
        }
        ArrayUtils.sort(edgeOrder, new IntComparator() {
            public int compare(int first, int second) {
                return IntegerUtils.longCompare(graph.weight(first), graph.weight(second));
            }
        });
        IndependentSetSystem setSystem = new RecursiveIndependentSetSystem(graph.vertexCount);
        for (int i : edgeOrder) {
            if (setSystem.join(graph.source(i), graph.destination(i))) {
                result.add(i);
            }
        }
        if (setSystem.getSetCount() == 1) {
            return result;
        } else {
            return null;
        }
    }
}
