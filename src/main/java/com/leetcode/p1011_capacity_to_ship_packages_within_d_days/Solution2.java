/**
 * Leetcode - p1011_capacity_to_ship_packages_within_d_days
 */
package com.leetcode.p1011_capacity_to_ship_packages_within_d_days;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 * 自己实现：二分搜索
 * calculateShipDays 实现的有点慢。
 */
class Solution2 implements Solution {

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

    public int calculateShipDays(int[] weights, int capacity) {
        int days = 0;
        int actualShipCapacity = 0;
        for (int weight : weights) {

            if (actualShipCapacity + weight > capacity) {
                days++;
                actualShipCapacity = weight;
            } else if (actualShipCapacity + weight == capacity) {
                days++;
                actualShipCapacity = 0;
            } else if (actualShipCapacity + weight < capacity){
                actualShipCapacity += weight;
            }
        }

        if (actualShipCapacity != 0) {
            days++;
        }

        return days;
    }
}
