package com.zdy.leetcode.algorithm.top100.listnode;

import java.time.temporal.Temporal;

/**
 * K 个一组翻转链表: https://leetcode.cn/problems/reverse-nodes-in-k-group/
 *
 * 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode dummy = new ListNode(0,head);
       ListNode pre =dummy;
       while (head!=null){
           ListNode tail = pre;
           for (int i = 0; i < k; i++) {
               tail = tail.next;
               if(tail==null){
                   return dummy.next;
               }
           }
           ListNode next = tail.next;
           ListNode[] reverse = reverse(head, tail);
           head=reverse[0];
           tail= reverse[1];
           pre.next = head;
           tail.next = next;
           pre = tail;
           head = next;
       }
       return dummy.next;
    }


    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode[] reverse(ListNode head,ListNode tail){
        ListNode pre =null;
        ListNode cur = head;
        while (pre!=tail){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail,head};
    }
}
