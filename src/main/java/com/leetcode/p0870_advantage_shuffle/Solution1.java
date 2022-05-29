/**
 * Leetcode - p0870_advantage_shuffle
 */
package com.leetcode.p0870_advantage_shuffle;

import java.util.Arrays;
import java.util.PriorityQueue;

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

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // 给 nums2 降序排序
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(
                (int[] pair1, int[] pair2) -> {
                    return pair2[1] - pair1[1];
                }
        );
        for (int i = 0; i < n; i++) {
            maxpq.offer(new int[]{i, nums2[i]});
        }
        // 给 nums1 升序排序
        Arrays.sort(nums1);

        // nums1[left] 是最小值，nums1[right] 是最大值
        int left = 0, right = n - 1;
        int[] res = new int[n];

        while (!maxpq.isEmpty()) {
            int[] pair = maxpq.poll();
            // maxval 是 nums2 中的最大值，i 是对应索引
            int i = pair[0], maxval = pair[1];
            if (maxval < nums1[right]) {
                // 如果 nums1[right] 能胜过 maxval，那就自己上
                res[i] = nums1[right];
                right--;
            } else {
                // 否则用最小值混一下，养精蓄锐
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums1 = {12, 24, 8, 32};
//        int[] nums2 = {13, 25, 32, 11};

//        int[] nums1 = {2,7,11,15};
//        int[] nums2 = {1,10,4,11};

        int[] nums1 = {2,0,4,1,2};
        int[] nums2 = {1,3,0,0,2};

        Solution solution = new Solution1();
        int[] result = solution.advantageCount(nums1, nums2);
        System.out.println(Arrays.toString(result));


    }

}
