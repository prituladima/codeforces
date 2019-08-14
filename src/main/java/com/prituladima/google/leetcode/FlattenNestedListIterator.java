package com.prituladima.google.leetcode;

import java.util.*;

public class FlattenNestedListIterator {

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        private Deque<Iterator<NestedInteger>> iteratorsQueue = new ArrayDeque<>();
        private Integer next;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.iteratorsQueue.push(nestedList.iterator());
        }

        @Override
        public Integer next() {
            if (next == null)
                throw new NoSuchElementException();
            else
                return next;
        }

        @Override
        public boolean hasNext() {
            while (!iteratorsQueue.isEmpty() && iteratorsQueue.peekFirst().hasNext()) {
                NestedInteger val = iteratorsQueue.peekFirst().next();
                if (!iteratorsQueue.peekFirst().hasNext())
                    this.iteratorsQueue.poll();

                if (val.isInteger()) {

                    next = val.getInteger();
                    return true;

                } else {
                    List<NestedInteger> list = val.getList();
                    if (!list.isEmpty())
                        this.iteratorsQueue.push(list.iterator());

                }
            }


            return false;
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

}
