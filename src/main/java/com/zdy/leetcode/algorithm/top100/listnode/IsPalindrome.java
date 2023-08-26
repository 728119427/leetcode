package com.zdy.leetcode.algorithm.top100.listnode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表：https://leetcode.cn/problems/palindrome-linked-list/?envType=study-plan-v2&id=top-100-liked
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class IsPalindrome {


    public boolean isPalindrome(ListNode head) {
        if(head.next==null){
            return true;
        }
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }
        for(int i=0,j=list.size()-1;i<=j;i++,j--){
            if(!list.get(i).equals(list.get(j))){
                return false;
            }
        }
        return true;
    }
}
