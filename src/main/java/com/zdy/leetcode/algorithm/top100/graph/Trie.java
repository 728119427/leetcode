package com.zdy.leetcode.algorithm.top100.graph;

import java.lang.management.GarbageCollectorMXBean;

/**
 * 前缀树/字典树：https://leetcode.cn/problems/implement-trie-prefix-tree/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 *
 *
 * |-0-|-1-|-2-|-3-|-4-|-5-|-6-|-7-|-8-|-9-|-10-|-11-|-12-|-13-|-14-|-15-|-16-|-17-|-18-|-19-|-20-|-21-|-22-|-23-|-24-|-25-|
 *
 * |- -|- -|- -|- -|- -|- -|- -|- -|- -|- -|-  -|-  -|-  -|-  -|-  -|-  -|-  -|-  -|-  -|-  -|-  -|-  -|- w-|-  -|-  -|-  -|
 *                                                                                                       ||
 *                                                                                                       ||
 *                                                                                                       \/
 * |- -|- -|- -|- -|- -|- -|- -|- -|- -|- -|-  -|-  -|-  -|-  -|-o -|-  -|-  -|-  -|-  -|-  -|-  -|-  -|-  -|-  -|-  -|-  -|
 *                                                               ||
 *                                                               ||
 *                                                               \/
 * |- -|- -|- -|- -|- -|- -|- -|- -|- -|- -|-  -|-  -|-  -|-  -|- -|-  -|-  -|- r -|-  -|-  -|-  -|-  -|-  -|-  -|-  -|-  -|
 *                                                                             ||
 *                                                                             ||
 *                                                                             \/
 * |- -|- -|- -|-d-|- -|- -|- -|- -|- -|- -|-  -|-  -|-  -|-  -|- -|-  -|-  -|-   -|-  -|-  -|-  -|-  -|-  -|-  -|-  -|-  -|
 */
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
    }

    Trie[] children;
    boolean isEnd;


    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(node.children[index]==null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        //最后一个字符
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie trie = searchPrefix(word);
        return trie!=null && trie.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix)!=null;
    }

    /**
     * 如果找不到该prefix返回null，找到的话返回prefix最后一个字符对应的node
     * @param prefix
     * @return
     */
    public Trie searchPrefix(String prefix){
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch-'a';
            Trie chNode = node.children[index];
            if(chNode==null){
                return null;
            }
            node = chNode;
        }
        return node;
    }
}
