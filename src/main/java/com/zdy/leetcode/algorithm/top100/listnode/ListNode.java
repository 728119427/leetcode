package com.zdy.leetcode.algorithm.top100.listnode;

/**
 * @Description TODO
 * @Author zhengdongyuan@hanyangtech.cn
 * @Date 2023/5/11 14:20
 */
public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }

    ListNode(int x,ListNode next) {
        val = x;
        this.next = next;
    }
}
