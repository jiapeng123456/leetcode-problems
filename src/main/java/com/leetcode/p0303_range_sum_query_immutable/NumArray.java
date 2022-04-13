/**
 * Leetcode - p0303_range_sum_query_immutable
 */
package com.leetcode.p0303_range_sum_query_immutable;

/**
 * 书上实现。
 */
class NumArray implements Solution {

    private int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] += nums[i - 1] + preSum[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right+1] - preSum[left];
    }

}
