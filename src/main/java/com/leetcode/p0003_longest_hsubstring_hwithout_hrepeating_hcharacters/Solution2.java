/**
 * Leetcode - p0003_longest_hsubstring_hwithout_hrepeating_hcharacters
 */
package com.leetcode.p0003_longest_hsubstring_hwithout_hrepeating_hcharacters;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 * 使用滑动窗口模板的实现
 *
 */
class Solution2 implements Solution {

    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 1) {
            return 1;
        }

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : s.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
            window.put(c, 0);
        }

        int left = 0, right = 0;
        int maxLen = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            window.put(c, window.get(c) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }

            // 左边窗口收缩时，代表字符串长度要减少重复字符。
            // 所以在减少后，再总记录长度。
            maxLen = Integer.max(right - left, maxLen);
        }

        return maxLen;
    }

}
