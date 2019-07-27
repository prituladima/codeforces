package com.prituladima.google.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class F001_lru_cache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
        for (int i = 0; i < 27; i++)
            lruCache.put(i, 10);

        for (int i = 17; i < 19; i++)
            lruCache.get(i);

        for (int i = 27; i < 30; i++)
            lruCache.put(i, 10);

        lruCache.forEach((key, value) -> {
            System.out.println(key);
        });
    }


    private static class LRUCache extends LinkedHashMap<Integer, Integer> {

        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, .75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    private static class LRUCache2 {
        private static class DLinkedNode {
            int key;
            int value;
            DLinkedNode next;
            DLinkedNode prev;
        }

        private DLinkedNode head;
        private DLinkedNode tail;

        private void addNode(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;

            head.next = node;
            node.next.prev = node;
        }

        private void removeNode(DLinkedNode node) {
            DLinkedNode prev = node.prev;
            DLinkedNode next = node.next;

            prev.next = next;
            next.prev = prev;


        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addNode(node);
        }

        private DLinkedNode popTail() {
            DLinkedNode poped = tail.prev;
            removeNode(poped);
            return poped;
        }

        int capacity;
        int size;
        private Map<Integer, DLinkedNode> cache = new HashMap<>();

        public LRUCache2(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            this.head = new DLinkedNode();
            this.tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }


        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node != null) {
                node.value = value;
                moveToHead(node);
            } else {
                node = new DLinkedNode();
                node.value = value;
                node.key = key;

                addNode(node);
                cache.put(key, node);

                ++size;

                if (size > capacity) {
                    DLinkedNode last = popTail();
                    cache.remove(tail.key);
                    size--;
                }
            }
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node != null) {
                moveToHead(node);
                return node.value;
            } else {
                return -1;
            }
        }

    }


}
