/**
 * Leetcode - p1109_corporate_flight_bookings
 */
package com.leetcode.p1109_corporate_flight_bookings;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

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

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference diff = new Difference(nums);
        for (int i = 0; i < bookings.length; i++) {
            diff.increment(bookings[i][0] - 1, bookings[i][1] - 1, bookings[i][2]);
        }

        return diff.getResult();
    }

    public class Difference {

        int[] diff;

        public Difference(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] getResult() {
            int[] reslut = new int[diff.length];
            reslut[0] = diff[0];
            for (int i = 1; i < reslut.length; i++) {
                reslut[i] = diff[i] + reslut[i - 1];
            }

            return reslut;
        }
    }

}
