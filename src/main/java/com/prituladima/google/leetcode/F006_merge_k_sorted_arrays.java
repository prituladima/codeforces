package com.prituladima.google.leetcode;

import java.util.*;

//O(Nk) Merge with one big list every time
//O(NlogN) Just put everything together and sort
//O(NlogK) put everything to PQ and build single answer, put it back to PQ and repeat N times
//O(Nlogk) put everything to queue. get 2 remove it from begging, merge and put it to the end

public class F006_merge_k_sorted_arrays {
//    Model
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        List<Integer> list = new ArrayList<>();
        for (ListNode cur : lists) {
            ListNode node = cur;
            if (node == null) continue;
            do {
                list.add(node.val);
            } while ((node = node.next) != null);
        }

        Collections.sort(list);

        ListNode head = null;
        ListNode cur = null;
        for (int val : list) {
            if (head == null) {
                head = new ListNode(val);
                cur = head;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        int len = lists.length;
        if (lists.length == 0) return null;
        ListNode res = lists[0];
        for (int i = 1; i < len; i++) {
            ListNode pointer1 = res;
            ListNode pointer2 = lists[i];
            res = merge(pointer1, pointer2);
        }
        return res;
    }

    public ListNode mergeKLists5(ListNode[] lists) {
        Queue<ListNode> queue = new ArrayDeque<>();
        for(ListNode cur : lists){
            if(cur!= null)queue.offer(cur);
        }

        while (queue.size() >= 2){
            ListNode pointer1 = queue.remove();
            ListNode pointer2 = queue.remove();
            queue.offer(merge(pointer1, pointer2));
        }
        if(queue.size() == 1)
        return queue.remove();
        return null;
    }

    private ListNode merge(ListNode pointer1, ListNode pointer2) {
        if (pointer1 == null) return pointer2;
        if (pointer2 == null) return pointer1;
        ListNode newOne = null;
        ListNode cur = null;
        do {
            if (newOne == null) {
                newOne = new ListNode(Math.min(pointer1.val, pointer2.val));
                cur = newOne;
            } else {
                cur.next = new ListNode(Math.min(pointer1.val, pointer2.val));
                cur = cur.next;
            }
            if (pointer1.val < pointer2.val)
                pointer1 = pointer1.next;
            else
                pointer2 = pointer2.next;
        } while ((pointer1) != null && (pointer2) != null);
        if (pointer1 == null) {
            cur.next = pointer2;
        } else {
            cur.next = pointer1;
        }
        return newOne;
    }


    public ListNode mergeKLists3(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for(ListNode l : lists){
            if(l!=null){
                q.add(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while(!q.isEmpty()){
            point.next = q.remove();
            point = point.next;
            ListNode next = point.next;
            if(next!=null){
                q.add(next);
            }
        }
        return head.next;
    }

}
