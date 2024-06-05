package com.kh.array.binarySearch;

public class BinarySearch {

    // PreCondition:
    // 1. Sorted Array
    // 2. No duplicate elements in the array

    private static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int middle = left + ((right - left) / 2);
            if(array[middle] > target) {
                right = middle - 1;
            } else if(array[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
//      return -1;
        return left;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-1,0,3,5,9,12};
//        int target = 9;
        int[] nums = new int[] {1,3,5,6};
        int target = 7;
        int index = binarySearch(nums, target);
        System.out.println(index);
    }
}
