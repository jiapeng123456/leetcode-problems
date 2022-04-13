/**
 * Leetcode - p0303_range_sum_query_immutable
 */
package com.leetcode.p0303_range_sum_query_immutable;

/**
 * 自己实现。
 * 暴力破解
 */
class NumArray2 implements Solution {

    private int[] nums;

    public NumArray2(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {

        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }

        return sum;
    }

}
