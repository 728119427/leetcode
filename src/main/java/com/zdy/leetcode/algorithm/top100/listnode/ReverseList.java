package com.zdy.leetcode.algorithm.top100.listnode;

/**
 * 反转链表：https://leetcode.cn/problems/reverse-linked-list/?envType=study-plan-v2&id=top-100-liked
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current!=null){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

}
