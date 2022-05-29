/**
 * Leetcode - p0870_advantage_shuffle
 */
package com.leetcode.p0870_advantage_shuffle;
import java.util.*;
import com.ciaoshen.leetcode.util.*;
import com.test.HorseRace;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution2 implements Solution {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] nums2Original = Arrays.copyOf(nums2, nums2.length);
//        Map<Map<Integer, Integer>> nums2Nums1OriginalMap = new LinkedHashMap();
//        for (int i = 0; i < nums2.length; i++) {
//            nums2Nums1OriginalMap.put(new HashMap<>(nums2[i], nums1[i]));
//        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] maxNums1 = null;
        int maxAdvantage = Integer.MIN_VALUE;

        for (int i = 0; i < nums1.length; i++) {
            int winNum = checkWin(nums1, nums2);
            if (winNum > maxAdvantage) {
                maxAdvantage = winNum;
                maxNums1 = Arrays.copyOf(nums1, nums1.length);
            }

            // rotate usHores
            int tmp = nums1[0];
            for (int j = 1; j < nums1.length; j++) {
                nums1[j - 1] = nums1[j];
            }
            nums1[nums1.length - 1] = tmp;
        }

        if (maxAdvantage == Integer.MIN_VALUE) {
            return null;
        }

//        Map<Integer, Integer> num2AndNum1Map = new HashMap<>();
//        for (int i = 0; i < nums2.length; i++) {
//            num2AndNum1Map.put(nums2[i], maxNums1[i]);
//        }

        Map<Integer, List<Integer>> num2AndNum1Map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            List<Integer> eleList = num2AndNum1Map.get(nums2[i]);
            if (eleList == null) {
                eleList = new ArrayList<>();
                num2AndNum1Map.put(nums2[i], eleList);
            }

            eleList.add(maxNums1[i]);
        }

        int[] resultNums1 = new int[nums1.length];
        for (int i = 0; i < nums2Original.length; i++) {
            List<Integer> eleList = num2AndNum1Map.get(nums2Original[i]);
            Integer ele = eleList.get(0);
            resultNums1[i] = ele;

            if (eleList.size() > 1) {
                eleList.remove(0);
            }
        }


        return resultNums1;

    }


    public int checkWin(int[] nums1, int[] nums2) {
        int counter = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > nums2[i]) {
                counter++;
            }
        }

        return counter;

    }

    public static void main(String[] args) {
//        int[] nums1 = {12, 24, 8, 32};
//        int[] nums2 = {13, 25, 32, 11};

//        int[] nums1 = {2,7,11,15};
//        int[] nums2 = {1,10,4,11};

//        int[] nums1 = {2,0,4,1,2};
//        int[] nums2 = {1,3,0,0,2};
//
//        Solution2 solution = new Solution2();
//        int[] result = solution.advantageCount(nums1, nums2);
//        System.out.println(Arrays.toString(result));


        PriorityQueue<Integer> ints = new PriorityQueue<>((int1, int2) -> int2 - int1);
        ints.add(1);
        ints.add(2);

        System.out.println(ints.poll());
        System.out.println(ints.poll());
    }


}
