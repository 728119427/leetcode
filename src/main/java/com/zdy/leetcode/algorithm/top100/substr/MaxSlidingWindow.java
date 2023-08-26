package com.zdy.leetcode.algorithm.top100.substr;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 滑动窗口最大值：
 *
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
//        int[] nums ={1,3,-1,-3,5,3,6,7};
//        int k=3;
//        int[] ints = new MaxSlidingWindow().maxSlidingWindow(nums, k);
//        System.out.println(Arrays.toString(ints));


    }

    /**
     * 单调队列维护最大值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k){
        Deque<Integer> deque = new LinkedList<>();
        int len = nums.length;
        int[] ans = new int[len-k+1];
        //构建初始窗口中的单调增队列
        for (int i = 0; i < k; i++) {
            //保证索引小且值大的在前面
            while (!deque.isEmpty()&&nums[i]>nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
        }
        ans[0] = nums[deque.peekFirst()];
        //开始滑动窗口
        for (int i = k; i < len; i++) {
            while (!deque.isEmpty()&&nums[i]>nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
            //移除队列中不在窗口范围内的元素
            while (!deque.isEmpty()&&deque.peekFirst()<i-k+1){
                deque.pollFirst();
            }
            ans[i-k+1]=nums[deque.peekFirst()];
        }
        return ans;
    }

    /**
     * 优先队列维护最大值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len-k+1];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] nums1, int[] nums2) {
                //数字大的排前面,数字相同的情况下索引小的在前面
                return nums1[0]==nums2[0]?nums1[1]-nums2[1]:nums2[0]-nums1[0];
            }
        });
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(new int[]{nums[i],i});
        }
        ans[0] = priorityQueue.peek()[0];
        for (int i = k; i <len ; i++) {
            priorityQueue.offer(new int[]{nums[i],i});
            //滑动窗口的左边界是 i-k+1
            while (priorityQueue.peek()[1]<i-k+1){
                priorityQueue.poll();
            }
            ans[i-k+1] = priorityQueue.peek()[0];
        }
        return ans;
    }


}
