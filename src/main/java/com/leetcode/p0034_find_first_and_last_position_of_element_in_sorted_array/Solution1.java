/**
 * Leetcode - p0034_find_first_and_last_position_of_element_in_sorted_array
 */
package com.leetcode.p0034_find_first_and_last_position_of_element_in_sorted_array;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 *
 * 书上实现：都是使用闭区间。
 */
class Solution1 implements Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        return new int[]{leftBound(nums, target), rightBound(nums, target)};
    }

    public int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        // 第二个条件中，如果使用 right 的话，就要使用 right + 1。因为在 nums[mid] == target 时，做 right = mid - 1，
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }

        return left;
    }


    public int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        if (right == -1 || nums[right] != target) {
            return -1;
        }

        return right;
    }

}
