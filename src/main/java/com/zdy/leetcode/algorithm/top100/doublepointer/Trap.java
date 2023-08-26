package com.zdy.leetcode.algorithm.top100.doublepointer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 接雨水：https://leetcode.cn/problems/trapping-rain-water/?envType=study-plan-v2&id=top-100-liked
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 */
public class Trap {


    /**
     * 动态规划：先计算出每个下标i处左右两边的最大值
     * 对于下标i,下雨后水能到达的最大高度等于下标i两边的最大高度的最小值,下表i处能接的雨水量等于该最大高度-height[i]
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        rightMax[len-1] = height[len-1];
        //计算下标i处左右两边的最大值
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }
        for (int i = len-2; i >=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return ans;
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public int trap0(int[] height){
        int len = height.length;
        int left = 0,right = len-1;
        int leftMax = 0,rightMax = 0;
        int ans = 0;
        while (left<right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            //注意，left或right指针其中有一方一定是指向相对于它当前坐标i的leftMax或rightMax;所以height[left]<height[right]肯定有leftMax<rightMax
            if(height[left]<height[right]){
                ans+=leftMax-height[left];
                left++;
            }else {
                ans+=rightMax-height[right];
                right--;
            }
        }
        return ans;
    }

    /**
     * 单调栈
     * @param height
     * @return
     */
    public int trap1(int[] height){
        int len = height.length;
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty()&&height[i]>height[stack.peek()]){
                Integer top = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                Integer left = stack.peek();
                int currentWidth = i-left-1;
                int currentHigh =Math.min(height[left],height[i])-height[top];
                ans+=currentWidth*currentHigh;
            }
            stack.push(i);
        }
        return ans;
    }
}
