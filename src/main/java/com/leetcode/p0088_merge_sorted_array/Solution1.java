/**
 * Leetcode - p0088_merge_sorted_array
 */
package com.leetcode.p0088_merge_sorted_array;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 * two pointer
 */
class Solution1 implements Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // todo check data


        int p1 = m - 1;
        int p2 = n - 1;
        int last = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[last] = nums1[p1];
                p1--;
            } else {
                nums1[last] = nums2[p2];
                p2--;
            }

            last--;
        }


        // if nums1 has rest element, just return.
        if (p1 < 0) {
            while (p2 >= 0) {
                nums1[last] = nums2[p2];
                p2--;
                last--;
            }
        }
    }

}
