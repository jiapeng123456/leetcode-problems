/**
 * Leetcode - p0081_search_in_rotated_sorted_array_ii
 */
package com.leetcode.p0081_search_in_rotated_sorted_array_ii;
import java.util.*;
import java.util.logging.Level;

import com.ciaoshen.leetcode.util.*;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution2 implements Solution {

    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;

//        while (left <= right) {
//            mid = left + (right - left) / 2;
//
//            if (nums[left] >= nums[mid])
//
//        }

//        boolean leftIncreasing, rightIncreasing;
//        while (left <= right) {
//            mid = left + (right - left) / 2;
//            leftIncreasing = nums[left] <= nums[mid] ? true : false;
//            rightIncreasing = nums[mid] <= nums[right] ? true : false;
//
//            if (leftIncreasing && rightIncreasing) {
//
//            } else if (leftIncreasing || rightIncreasing) {
//                if (leftIncreasing) {
//
//                }
//            }
//        }

        return false;
    }

}
