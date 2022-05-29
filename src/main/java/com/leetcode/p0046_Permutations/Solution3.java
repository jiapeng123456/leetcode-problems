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
class Solution3 implements Solution {

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            return Arrays.asList(Arrays.asList(nums[0]));
        }

        Integer[] integerNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            integerNums[i] = nums[i];
        }

        List<List<Integer>> rtn = new ArrayList<>();
        doPermute(integerNums, 0, nums.length - 1, rtn);
        return rtn;
    }

    public void doPermute(Integer[] arr, int start, int end, List<List<Integer>> rtn) {
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
            Integer[] arrCopied = Arrays.copyOf(arr, arr.length);
            exchangeElement(arrCopied, start, i);

            // reduce range
            doPermute(arrCopied, start + 1, end, rtn);
        }
    }

    public void save(Integer[] arr, List<List<Integer>> rtn) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        rtn.add(list);
//        rtn.add(Arrays.asList(Arrays.copyOf(arr, arr.length)));

    }

    public void exchangeElement(Integer[] arr, int i, int j) {
        Integer tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
//        List<List<Integer>> rtn = new ArrayList<>();
//        Integer[] arr = {1, 2, 3};
//        Integer[] copy = Arrays.copyOf(arr, arr.length);
//
//        arr[0] = 0;
//        System.out.println(copy);


        int[] arr = {1, 2, 3};
//        int[] arr = {1, 2, 3, 4};
        Solution solution = new Solution3();
        List<List<Integer>> rtn = solution.permute(arr);

        for (List<Integer> list : rtn) {
            System.out.println(list);
        }
    }

}
