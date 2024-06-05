package com.kh.array.binarySearch;

public class Sqrtx {

    public static int mySqrt(int x) {
        if(x < 0 || x > 1L<<32 - 1) {
            return -1;
        }
        int left = 0;
        int right = x;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if(middle * middle > x) {
                right = middle - 1;
                System.out.println("right: " +right);
            } else if (middle * middle < x) {
                left = middle + 1;
                System.out.println("left: " +left);
            } else {
                return middle;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int index = mySqrt(1024);
        System.out.println(index);
    }
}
