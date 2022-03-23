/**
 * Leetcode - p0026_remove_duplicates_from_sorted_array
 */
package com.leetcode.p0026_remove_duplicates_from_sorted_array;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 *
 * 自己实现：快慢指针法
 */
class Solution2 implements Solution {

    public int removeDuplicates(int[] nums) {

        if (nums.length == 1) {
            return 1;
        }

        int slow = 0;
        int k = 1;

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] == nums[fast]) {
                if (fast + 1 >= nums.length) {
                    break;
                }

                if (nums[fast + 1] != nums[fast]) {
                    nums[slow + 1] = nums[fast + 1];
                    slow++;
                    k++;
                } else {
                    continue;
                }
            } else {
                slow++;
                k++;
            }
        }

        return k;
    }

}
