/**
 * Leetcode - p0034_find_first_and_last_position_of_element_in_sorted_array
 */
package com.leetcode.p0034_find_first_and_last_position_of_element_in_sorted_array;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/**
 *
 * 自己实现
 */
class Solution2 implements Solution {

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
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                // 处理两种情况：
                // 1, 和 target 相等的值的 idx 为 0。 mid == 0
                // 2, 和 target 相等的值的 idx 不为 0。
                //    nums[mid - 1] != nums[mid] 说明 mid 值等于 target，并且 mid - 1 的值不等于 target。
                if (mid == 0 || nums[mid - 1] != nums[mid]) {
                    return mid;
                }

                // 注意，这里 right = mid 也行。
                // 因为，整除会向下取整，所以在 leftBound 时，不管 left + right 是奇数还是偶数，
                // right 都会向左移动，而且会移动到 idx 为 0 的位置。
                // 但在 rightBound 时，就因为向下取整的问题，left 无法移动到 nums.length - 1 的位置。
                // 例如：[2, 2] 的话，left 无法移动到 idx = 1 的位置。
//                right = mid;
                right = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }


    public int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                // 处理两种情况：
                // 1, 和 target 相等的值的 idx 为 nums.length - 1。
                // 2, 和 target 相等的值的 idx 不为 nums.length - 1。
                //    nums[mid + 1] != nums[mid] 说明 mid 值等于 target，并且 mid + 1 的值不等于 target。
                if (mid == nums.length - 1 || nums[mid + 1] != nums[mid]) {
                    return mid;
                }

                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
