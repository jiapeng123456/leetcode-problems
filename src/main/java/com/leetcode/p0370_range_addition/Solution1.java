/**
 * Leetcode - p0370_range_addition
 */
package com.leetcode.p0370_range_addition;
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

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        Difference diff = new Difference(nums);
        for (int i = 0; i < updates.length; i++) {
            diff.increment(updates[i][0], updates[i][1], updates[i][2]);
        }

        return diff.getResult();
    }

    public class Difference {

        int[] diff;

        public Difference(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] getResult() {
            int[] reslut = new int[diff.length];
            reslut[0] = diff[0];
            for (int i = 1; i < reslut.length; i++) {
                reslut[i] = diff[i] + reslut[i - 1];
            }

            return reslut;
        }
    }

}
