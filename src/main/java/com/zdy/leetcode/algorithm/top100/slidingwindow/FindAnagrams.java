package com.zdy.leetcode.algorithm.top100.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中所有字母异位词：https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&id=top-100-liked
 *
 * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

 */
public class FindAnagrams {


    /**
     * 滑动窗口
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if(sLen<pLen){
            return ans;
        }
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        //构建初始的滑动窗口
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i)-'a']++;
            sCount[s.charAt(i)-'a']++;
        }
        //比较数组中的元素值是否相同
        if(Arrays.equals(sCount,pCount)){
            ans.add(0);
        }
        //移动滑动窗口,滑动的最大距离为sLen-pLen,因为窗口的长度为pLen
        for (int i = 0; i < sLen - pLen; i++) {
            sCount[s.charAt(i)-'a']--;
            sCount[s.charAt(i+pLen)-'a']++;
            if(Arrays.equals(sCount,pCount)){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
