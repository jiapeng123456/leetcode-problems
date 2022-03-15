/**
 * Leetcode - p0567_permutation_in_string
 */
package com.leetcode.p0567_permutation_in_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * for execise
 *
 */
class Solution3 implements Solution {

    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len > s2Len) {
            return false;
        }

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (int i = 0; i < s1Len; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }

        for (int i = s1Len; i < s2Len; i++) {
            cnt2[s2.charAt(i) - 'a']++;
            cnt2[s2.charAt(i - s1Len) - 'a']--;
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }

        return false;


    }


}
