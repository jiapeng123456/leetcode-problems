/**
 * Leetcode - p0003_longest_hsubstring_hwithout_hrepeating_hcharacters
 */
package com.leetcode.p0003_longest_hsubstring_hwithout_hrepeating_hcharacters;

import java.util.HashMap;
import java.util.Map;

/** 
 * for execise
 *
 */
class Solution3 implements Solution {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s.toCharArray()) {
            window.put(c, 0);
        }


        int left = 0, right = 0;
        int len = Integer.MIN_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            window.put(c, window.get(c) + 1);

            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;

                window.put(d, window.get(d) - 1);
            }

            if (right - left > len) {
                len = right - left;
            }
        }


        return len;
    }

}
