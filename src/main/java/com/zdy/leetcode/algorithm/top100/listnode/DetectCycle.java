package com.zdy.leetcode.algorithm.top100.listnode;

/**
 * 环形链表II: https://leetcode.cn/problems/linked-list-cycle-ii/
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode fast = head,slow = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }while (fast!=slow);
        ListNode ptr = head;
        while (ptr!=slow){
            slow = slow.next;
            ptr = ptr.next;
        }
        return ptr;
    }


}
