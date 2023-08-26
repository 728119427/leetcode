package com.zdy.leetcode.algorithm.top100.listnode;

/**
 * @Description 删除链表的倒数第N个节点: https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-100-liked
 * @Author zhengdongyuan@hanyangtech.cn
 * @Date 2023/5/22 13:38
 */
public class RemoveNthFromEnd {


    /**
     * 使用双指针first和second,first比second领先n个节点，当first指向链表末尾时,second刚好指向倒数第n个节点;
     * 使用一个哑节点dummy作为头节点的前驱节点，避免对头结点进行特殊处理；使second节点指向dummy，则first指向链表末尾时，second刚好指向倒数第n个节点的前驱节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0,head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first!=null){
            first = first.next;
            second = second.next;
        }
        ListNode removeNode = second.next;
        second.next = removeNode.next;
        removeNode.next = null;
        return dummy.next;
    }


    /**
     * 计算链表长度后再删除
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if(head.next==null){
            return null;
        }
        ListNode temp = head;
        int len = getLength(head);
        if(n==len){
            return head.next;
        }
        int i=1;
        while (temp!=null){
            if(i==len-n){
                ListNode next = temp.next;
                temp.next = next.next;
                next.next=null;
                return head;
            }
            temp = temp.next;
            i++;
        }
        return head;
    }

    public int getLength(ListNode head){
        ListNode temp = head;
        int  i =0;
        while (temp!=null){
            i++;
            temp = temp.next;
        }
        return i;
    }
}
