/**
 * Leetcode - p0567_permutation_in_string
 */
package com.leetcode.p0567_permutation_in_string;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/**
 *
 *
 *
 */
class Solution1 implements Solution {

    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
            window.put(c, 0);
        }

        int left = 0, right = 0;
        int valid = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.get(c) + 1);

                if (Objects.equals(window.get(c), need.get(c))) {
                    valid++;
                }
            }

            while (right - left > s1.length()) {
                char d = s2.charAt(left);
                left++;

                if (need.containsKey(d)) {
                    if (Objects.equals(window.get(d), need.get(d))) {
                        valid--;
                    }

                    window.put(d, window.get(d) - 1);
                }
            }

            if (valid == need.size()) {
                return true;
            }
        }

        return false;
    }

}
