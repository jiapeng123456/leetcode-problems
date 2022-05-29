/**
 * Leetcode - p0046_Permutations
 */
package com.leetcode.p0046_Permutations;
import java.util.*;
import java.util.stream.Collectors;

import com.ciaoshen.leetcode.util.*;


/** 
 * 自己实现
 */
class Solution2 implements Solution {

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            return Arrays.asList(Arrays.asList(nums[0]));
        }


        List<List<Integer>> rtn = new ArrayList<>();
        doPermute(nums, 0, nums.length - 1, rtn);
        return rtn;
    }

    public void doPermute(int[] arr, int start, int end, List<List<Integer>> rtn) {
        if (end - start == 1) {
            save(arr, rtn);

            // exchange last two elements, and print array
            exchangeElement(arr, start, end);
            save(arr, rtn);

            // restore arr sequence
            exchangeElement(arr, start, end);

            return;
        }

        for (int i = start; i < arr.length; i++) {
            // exchange element
            int[] arrCopied = Arrays.copyOf(arr, arr.length);
            exchangeElement(arrCopied, start, i);

            // reduce range
            doPermute(arrCopied, start + 1, end, rtn);
        }
    }

    public void save(int[] arr, List<List<Integer>> rtn) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        rtn.add(list);

        // cost a lot of time
//        rtn.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));

    }

    public void exchangeElement(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        Solution solution = new Solution2();
        List<List<Integer>> rtn = solution.permute(arr);

        for (List<Integer> list : rtn) {
            System.out.println(list);
        }
    }

}
