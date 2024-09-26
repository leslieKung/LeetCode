package com.kh.array.removeElements;

/**
 * 26. Remove Duplicates from Sorted Array
 *
 */
public class RemoveElements {

    private static int Solution1(int[] nums, int value) {
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            if(value == nums[i]) {
                for(int j = i + 1; j < length; j++) {
                    nums[j-1] = nums[j];
                }
            }
            i--;
            length--;
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        Solution1(nums, 2);
    }
}
