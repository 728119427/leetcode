package com.zdy.leetcode.algorithm.top100.substr;

/**
 * 最小覆盖子串：https://leetcode.cn/problems/minimum-window-substring/?envType=study-plan-v2&id=top-100-liked
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 */
public class MinCoverSubStr {

    public String minWindow(String s, String t) {
        int[] need = new int[64];
        int sLen = s.length();
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            need[t.charAt(i)-'A']++;
        }
        int l=0,r=0,ansL=-1,len=Integer.MAX_VALUE,count = tLen;
        while (r<sLen){
            char ch = s.charAt(r);
            if(need[ch-'A']>0){
                count--;
            }
            need[ch-'A']--;
            if(count==0){
                //向左收缩窗口
                while (l<=r && need[s.charAt(l)-'A']<0){
                    need[s.charAt(l)-'A']++;
                    l++;
                }
                if(r-l+1<len){
                    len = r-l+1;
                    ansL = l;
                }
                need[s.charAt(l)-'A']++;
                l++;
                count++;
            }
            r++;
        }
        return ansL==-1?"":s.substring(ansL,ansL+len);
    }

}
