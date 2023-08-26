package com.zdy.leetcode.algorithm.top100.listnode;

/**
 * 排序链表：https://leetcode.cn/problems/sort-list/?envType=study-plan-v2&envId=top-100-liked
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表
 */
public class SortList {


    public ListNode sortList(ListNode head) {
        return sortList0(head,null);
    }

    public ListNode sortList0(ListNode head,ListNode tail){
        if(head==null){
            return head;
        }
        if(head.next==tail){
            head.next=null;
            return head;
        }
        ListNode slow =head,fast = head;
        while (fast!=tail){
            slow = slow.next;
            fast = fast.next;
            if(fast!=tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode node1 = sortList0(head,mid);
        ListNode node2 = sortList0(mid,tail);
        return mergeSortList(node1,node2);
    }


    /**
     * 合并有序链表
     * @param node1
     * @param node2
     * @return
     */
    public ListNode mergeSortList(ListNode node1,ListNode node2){
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        ListNode aPtr = node1,bptr = node2;
        while (aPtr!=null && bptr!=null){
            if(aPtr.val<bptr.val){
                temp.next = new ListNode(aPtr.val);
                aPtr = aPtr.next;
            }else {
                temp.next = new ListNode(bptr.val);
                bptr = bptr.next;
            }
            temp = temp.next;
        }
        if(aPtr==null){
            temp.next = bptr;
        }else {
            temp.next = aPtr;
        }
        return ans.next;
    }
}
