package com.prituladima.google.leetcode;

import java.math.BigInteger;

public class A000_add_two_numbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum /10;
            cur = cur.next = new ListNode(sum % 10);
            if(l1 != null ) l1 = l1.next;
            if(l2 != null ) l2 = l2.next;
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int rem = 0;
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        while(l1!= null && l2 != null){
            int sum = l1.val + l2.val + rem;
            if(sum > 9) {rem = 1; sum = sum - 10;}
            else rem = 0;
            cur = cur.next = new ListNode(sum);
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null){
            while(l2 != null){
                int sum = l2.val + rem;
                if(sum > 9) {rem = 1; sum -= 10;}
                else rem = 0;
                cur = cur.next = new ListNode(sum);

                l2 = l2.next;
            }
        }

        if(l2 == null){
            while(l1 != null){
                int sum = l1.val + rem;
                if(sum > 9) {rem = 1; sum -= 10;}
                else rem = 0;
                cur = cur.next = new ListNode(sum);
                l1 = l1.next;

            }
        }
        if(rem == 1) cur = cur.next = new ListNode(1);
        return head.next;
    }


    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        BigInteger f = getNumberFromList(l1);
        BigInteger s = getNumberFromList(l2);

        BigInteger r = f.add(s);

        char[] chars = new StringBuilder().append(String.valueOf(r.toString())).reverse().toString().toCharArray();

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (char c : chars) {
            cur.next = new ListNode(Integer.parseInt(String.valueOf(c)));
            cur = cur.next;
        }


        return head.next;
    }


    private BigInteger getNumberFromList(ListNode l1) {
        StringBuilder sb = new StringBuilder();
        while (l1 != null) {
            sb.append(l1.val);
            l1 = l1.next;
        }
        return new BigInteger(sb.reverse().toString());
    }

}
