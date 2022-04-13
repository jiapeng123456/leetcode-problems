/**
 * Leetcode - p0560_subarray_sum_equals_k
 */
package com.leetcode.p0560_subarray_sum_equals_k;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 * 书上实现。
 *
 */
class Solution1 implements Solution {

    public int subarraySum(int[] nums, int k) {
        // 保存前缀和的个数
        Map<Integer, Integer> presumMap = new HashMap<>();
        // 为了单个元素等于 k 的情况，所以先把 0 放里。
        presumMap.put(0, 1);

        int rtn = 0;
        int presum = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            int diff = presum - k;
            // 是否有 diff 大小的前缀和
            if (presumMap.containsKey(diff)) {
                rtn += presumMap.get(diff);
            }

            // 把当前"前缀和"放到 map 里。
            presumMap.put(presum, presumMap.getOrDefault(presum, 0) + 1);
        }

        return rtn;
    }

}
