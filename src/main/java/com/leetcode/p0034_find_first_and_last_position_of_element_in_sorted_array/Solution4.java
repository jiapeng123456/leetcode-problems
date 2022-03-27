/**
 * Leetcode - p0034_find_first_and_last_position_of_element_in_sorted_array
 */
package com.leetcode.p0034_find_first_and_last_position_of_element_in_sorted_array;

/**
 *
 * for execise
 */
class Solution4 implements Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        return new int[]{leftBound(nums, target), rightBound(nums, target)};
    }

    public int leftBound(int[] nums, int target) {
        return -1;
    }


    public int rightBound(int[] nums, int target) {
        return -1;
    }
}
