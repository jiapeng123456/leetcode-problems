/**
 * Leetcode - p0046_Permutations
 */
package com.leetcode.p0046_Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/** 
 * 自己实现
 */
class Solution4 implements Solution {

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
//            int[] arrCopied = Arrays.copyOf(arr, arr.length);
            exchangeElement(arr, start, i);

            // reduce range
            doPermute(arr, start + 1, end, rtn);

            exchangeElement(arr, i, start);

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
        int[] arr = {1, 2, 3};
//        int[] arr = {1, 2, 3, 4};
        Solution solution = new Solution4();
        List<List<Integer>> rtn = solution.permute(arr);

        for (List<Integer> list : rtn) {
            System.out.println(list);
        }
    }

}
