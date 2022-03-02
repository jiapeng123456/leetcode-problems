/**
 * Leetcode - p0167_two_sum_ii
 */
package com.leetcode.p0167_two_sum_ii;
import java.util.*;
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
class Solution1 implements Solution {

    @Override
    public int[] twoSum(int[] numbers, int target) {
        // check param
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        // find idx
        int l = 0;
        int r = numbers.length - 1;
        int sum;
        while (l < r) {
            sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{++l, ++r};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return null;
    }

}
