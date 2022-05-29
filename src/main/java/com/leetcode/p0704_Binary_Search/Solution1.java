/**
 * Leetcode - p0704_Binary_Search
 */
package com.leetcode.p0704_Binary_Search;

import java.util.*;

import com.ciaoshen.leetcode.util.*;

/**
 * 基础实现。
 */
class Solution1 implements Solution {

    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}
