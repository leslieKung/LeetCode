package com.kh.array.binarySearch;

/**
 * @ClassName ValidPerfactSquare
 * @Description  Given a positive integer num, return true if num is a perfect square or false otherwise.
 * @Author Kanghao
 * @Date 2024/9/26 15:01
 * @Version 1.0
 **/
public class ValidPerfactSquare {

    public static boolean getPerfectSquare(int positiveNum) {
        if(positiveNum <= 0) {
            return false;
        }

        int left = 0;
        int right = positiveNum;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (middle * middle > positiveNum) {
                right = middle - 1;
            } else if (middle * middle < positiveNum) {
                left = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int num = 16;
        System.out.println("Is num a valid perfect square: " + getPerfectSquare(num));

        int num1 = 14;
        System.out.println("Is num1 a valid perfect square: " + getPerfectSquare(num1));
    }

}
