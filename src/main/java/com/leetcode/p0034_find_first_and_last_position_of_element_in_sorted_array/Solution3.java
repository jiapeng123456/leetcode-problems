/**
 * Leetcode - p0034_find_first_and_last_position_of_element_in_sorted_array
 */
package com.leetcode.p0034_find_first_and_last_position_of_element_in_sorted_array;

/**
 *
 * 比较普遍的写法
 */
class Solution3 implements Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        return new int[]{leftBound(nums, target), rightBound(nums, target)};
    }

    public int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        if (left == nums.length) {
            return -1;
        }

        return nums[left] == target ? left : -1;
    }


    public int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        if (left == 0) {
            return -1;
        }

        return nums[left - 1] == target ? left - 1 : -1;

    }
}
