/**
 * Leetcode - p0560_subarray_sum_equals_k
 */
package com.leetcode.p0560_subarray_sum_equals_k;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 * for execise
 */
class Solution2 implements Solution {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumTimes = new HashMap<>();
        int sum = 0;
        int rtn = 0;

        preSumTimes.put(0, 1);
        for (int i = 1; i <= nums.length; i++) {
            sum += nums[i - 1];

            int preSumToFind = sum - k;
            if (preSumTimes.containsKey(preSumToFind)) {
                rtn += preSumTimes.get(preSumToFind);
            }

            preSumTimes.put(sum, preSumTimes.getOrDefault(sum, 0) + 1);
        }

        return rtn;
    }

}
