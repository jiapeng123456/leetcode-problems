/**
 * Leetcode - p0875_koko_eating_bananas
 */
package com.leetcode.p0875_koko_eating_bananas;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/**
 *
 * 书上实现。
 * calculateEatAllTimes 实现的好，不会超时。
 */
class Solution1 implements Solution {

    public int minEatingSpeed(int[] piles, int h) {
        // 计算 k 的范围
        int right = Integer.MIN_VALUE;
        int left = 1;
        for (int pile : piles) {
            right = Integer.max(pile, right);
        }

        if (piles.length == h) {
            return right;
        }

        int eatTimes;
        int mid = -1;
        while (left <= right) {
            mid = (right + left) / 2;
            eatTimes = calculateEatAllTimes(mid, piles, h);
            if (eatTimes == h) {
                right = mid - 1;
            } else if (eatTimes < h){
                right = mid - 1;
            } else if (eatTimes > h) {
                left = mid + 1;
            }
        }

        return left;
    }



    public int calculateEatAllTimes(int k, int[] piles, int h) {
        int eatTimes = 0;

        for (int pile : piles) {
            eatTimes += pile / k;
            if (pile % k != 0) {
                eatTimes++;
            }
        }

        return eatTimes;

    }

}
