package com.zdy.leetcode.algorithm.top100.print;

import java.util.HashMap;
import java.util.Map;

/**
 * 打印n边形
 */
public class PrintRhombus {

    public static void main(String[] args) {
        printRhombus(4);
    }

    public static void printRhombus(int n){
        //打印上层金字塔
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1- i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        //打印中间的隔层
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        //打印下层金字塔
        System.out.println();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n-1-i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
