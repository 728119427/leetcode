package com.zdy.leetcode.algorithm.top100.listnode;

/**
 * 相交链表：https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null
 */
public class GetIntersectionNode {

    /**
     * 1->9->1->2->4->3->2->4
     * 3->2->4->1->9->1->2->4
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA!=null || tempB!=null){
            if(tempA==null){
                tempA = headB;
            }
            if(tempB==null){
                tempB = headA;
            }
            if(tempA==tempB){
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }
}
