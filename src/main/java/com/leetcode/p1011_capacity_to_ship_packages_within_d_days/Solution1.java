/**
 * Leetcode - p1011_capacity_to_ship_packages_within_d_days
 */
package com.leetcode.p1011_capacity_to_ship_packages_within_d_days;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 * 书上实现：二分搜索。
 * calculateShipDays 实现的比较好。
 */
class Solution1 implements Solution {

    public int shipWithinDays(int[] weights, int days) {

        int left = -1, right = 0;
        for (int weight : weights) {
            right += weight;
            left = Integer.max(left, weight);
        }

        int mid;
        while (left <= right) {
            mid = (right + left) / 2;
            int dayCalculated = calculateShipDays(weights, mid);
            if (dayCalculated == days) {
                right = mid - 1;
            } else if (dayCalculated < days) {
                right = mid - 1;
            } else if (dayCalculated > days) {
                left = mid + 1;
            }
        }


        return left;
    }

    public int calculateShipDays(int[] weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.length; ) {
            // 尽可能多装货物
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) break;
                else cap -= weights[i];
                i++;
            }
            days++;
        }
        return days;
    }

}
