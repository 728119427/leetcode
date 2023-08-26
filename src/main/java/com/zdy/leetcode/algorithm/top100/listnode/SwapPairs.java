package com.zdy.leetcode.algorithm.top100.listnode;

/**
 * @Description 两两交换链表中的节点: https://leetcode.cn/problems/swap-nodes-in-pairs/?envType=study-plan-v2&envId=top-100-
 * @Author zhengdongyuan@hanyangtech.cn
 * @Date 2023/5/22 14:44
 */
public class SwapPairs {



    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode temp = dummy;
        while (temp.next!=null && temp.next.next!=null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummy.next;
    }

}
