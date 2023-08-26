package com.zdy.leetcode.algorithm.top100.listnode;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/**
 * 合并K个升序链表：https://leetcode.cn/problems/merge-k-sorted-lists/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
       return merge(lists,0,lists.length-1);
    }

    /**
     * 分治
     * @param lists
     * @param l
     * @param r
     * @return
     */
    private ListNode merge(ListNode[] lists, int l, int r) {
        if(l==r){
            return lists[l];
        }
        if(l>r){
            return null;
        }
        int mid =(l+r)>>1;
        return mergeSortedList(merge(lists,l,mid),merge(lists,mid+1,r));
    }


    /**
     * 合并两个升序的链表
     * @param node1
     * @param node2
     * @return
     */
    public ListNode mergeSortedList(ListNode node1,ListNode node2){
        ListNode ans = new ListNode(0);
        ListNode aptr = node1,bptr = node2,temp = ans;
        while (aptr!=null && bptr!=null){
            if(aptr.val<bptr.val){
                temp.next = aptr;
                aptr = aptr.next;
            }else {
                temp.next = bptr;
                bptr = bptr.next;
            }
            temp = temp.next;
        }
        if(aptr==null){
            temp.next = bptr;
        }else {
            temp.next = aptr;
        }
        return ans.next;
    }
}

