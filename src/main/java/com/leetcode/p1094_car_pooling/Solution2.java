/**
 * Leetcode - p1094_car_pooling
 */
package com.leetcode.p1094_car_pooling;

import java.util.*;

import com.ciaoshen.leetcode.util.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution2 implements Solution {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1000];
        Difference diff = new Difference(nums);
        for (int[] trip : trips) {
            diff.increment(trip[1], trip[2] - 1, trip[0]);
        }

        int[] result = diff.getResult();
        for (int passengerNum : result) {
            if (passengerNum > capacity) {
                return false;
            }
        }

        return true;
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
