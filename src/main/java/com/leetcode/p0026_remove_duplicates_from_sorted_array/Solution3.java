/**
 * Leetcode - p0026_remove_duplicates_from_sorted_array
 */
package com.leetcode.p0026_remove_duplicates_from_sorted_array;

/** 
 *
 * for execise
 */
class Solution3 implements Solution {

    public int removeDuplicates(int[] nums) {
        int left = 1, right = 1;

        while (right < nums.length) {
            if (nums[right] != nums[right - 1]) {
                nums[left] = nums[right];
                left++;
            }

            right++;
        }

        return left;
    }

}
