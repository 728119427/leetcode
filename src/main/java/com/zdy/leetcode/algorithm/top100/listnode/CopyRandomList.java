package com.zdy.leetcode.algorithm.top100.listnode;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表: https://leetcode.cn/problems/copy-list-with-random-pointer/
 */
public class CopyRandomList {

    Map<Node,Node> nodeMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        if(!nodeMap.containsKey(head)){
            Node newNode = new Node(head.val);
            nodeMap.put(head,newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }
        return nodeMap.get(head);
    }

}
