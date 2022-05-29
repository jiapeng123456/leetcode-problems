/**
 * Leetcode - p0046_Permutations
 */
package com.leetcode.p0046_Permutations;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 * Leetcode 标准解法
 */
class Solution1 implements Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rtn = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        doPermute(list, rtn, 0, nums.length);

        return rtn;
    }

    public void doPermute(List<Integer> list, List<List<Integer>> rtn, int first, int len) {
        if (first == len) {
            rtn.add(new ArrayList<>(list));
        }

        for (int i = first; i < len; i++) {
            Collections.swap(list, first, i);
            doPermute(list, rtn, first + 1, len);
            Collections.swap(list, i, first);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
//        int[] arr = {1, 2, 3, 4};
        Solution solution = new Solution1();
        List<List<Integer>> rtn = solution.permute(arr);

        for (List<Integer> list : rtn) {
            System.out.println(list);
        }
    }

}
