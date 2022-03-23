/**
 * Leetcode - p0026_remove_duplicates_from_sorted_array
 */
package com.leetcode.p0026_remove_duplicates_from_sorted_array;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 * 官方作法：双指针
 * 和自己做的不同点是，fast 指向的位置要和前一个位置进行比较。
 * 自己实现的是 fast 和后一个位置进行比较。
 *
 */
class Solution1 implements Solution {

    public int removeDuplicates(int[] nums){
        int slow = 1, fast = 1;

        while (fast < nums.length) {
            if (nums[fast - 1] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }

}
