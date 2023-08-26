package com.zdy.leetcode.algorithm.top100.slidingwindow;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串：https://leetcode.cn/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&id=top-100-liked
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 */
public class LengthOfLongestSubstring {

    /**
     * 滑动窗口
     * awedkpwknew
     * pwwkew
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int start=0,end=0;
        int ans=0;
        for (char c : s.toCharArray()) {
            if(charSet.contains(c)){
                ans = Math.max(end-start,ans);
                while (charSet.contains(c)){
                    charSet.remove(s.charAt(start++));
                }
            }
            charSet.add(c);
            end++;
        }
        ans = Math.max(end-start,ans);
        return ans;
    }
}
