package com.kh.array.binarySearch;

/**
 * @ClassName ValidPerfactSquare
 * @Description  Given a positive integer num, return true if num is a perfect square or false otherwise.
 * @Author Kanghao
 * @Date 2024/9/26 15:01
 * @Version 1.0
 **/
public class ValidPerfectSquare {
    // Time Complexity O(logn)
    // Space complexity  O(1)
    public static boolean getPerfectSquare(int positiveNum) {
        if (positiveNum < 0 || positiveNum > 1L << 32 - 1) {
            return false;
        }

        if (1 == positiveNum) {
            return true;
        }

        int left = 0;
        int right = positiveNum / 2;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (middle < positiveNum * 1.0 / middle) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return right == positiveNum * 1.0 / right;
    }

    public static void main(String[] args) {
        int num = 808201;
        System.out.println("Is num a valid perfect square: " + getPerfectSquare(num));

        int num1 = 14;
        System.out.println("Is num1 a valid perfect square: " + getPerfectSquare(num1));

        int num2 = 2147483647;
        System.out.println("Is num2 a valid perfect square: " + getPerfectSquare(num2));

        int num3 = 1;
        System.out.println("Is num3 a valid perfect square: " + getPerfectSquare(num3));
    }
}
