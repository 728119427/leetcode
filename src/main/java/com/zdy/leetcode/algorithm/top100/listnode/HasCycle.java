package com.zdy.leetcode.algorithm.top100.listnode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 环形链表：https://leetcode.cn/problems/linked-list-cycle/?envType=study-plan-v2&id=top-100-liked
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 */
public class HasCycle {

    public boolean hasCycle(ListNode head){
        if(head==null || head.next==null){
            return false;
        }
        ListNode fast = head.next,slow = head;
        while (fast!=slow){
            if(fast.next==null || fast.next.next==null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;

    }

    public boolean hasCycle1(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode temp = head;
        while (temp!=null){
            if(nodeSet.contains(temp)){
                return true;
            }
            nodeSet.add(temp);
            temp = temp.next;
        }
        return false;
    }

}
