/**
 * Leetcode - p0076_minimum_window_substring
 */
package com.leetcode.p0076_minimum_window_substring;

import java.util.*;

/**
 * 滑动窗口（使用 Map 来实现记数）
 * （比较好理解，但速度不是最快的。如果把 Map 换成数组，速度能更快。）
 *
 */
class Solution1 implements Solution {

    public String minWindow(String s, String t) {

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
            window.put(c, 0);
        }

        int slen = s.length();

        int left = 0, right = 0;
        int len = Integer.MAX_VALUE;
        int valid = 0;
        // mininum str start position
        int start = 0;

        char ch;
        while (right < slen) {
            ch = s.charAt(right);
            right++;
            if (window.containsKey(ch)) {
                window.put(ch, window.get(ch) + 1);
                // 为什么要使用等于呢，不用大于等于？
                // 因为窗口内某个字符个数，可能会超过合法的字符个数
                if (Objects.equals(window.get(ch), need.get(ch))) {
                    valid++;
                }
            }


            while (need.size() == valid) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                ch = s.charAt(left);
                left++;
                if (window.containsKey(ch)) {
                    if (Objects.equals(window.get(ch), need.get(ch))) {
                        valid--;
                    }
                    window.put(ch, window.get(ch) - 1);
                }
            }
        }


        if (len != Integer.MAX_VALUE) {
            return s.substring(start, start + len);
        }

        return "";
    }
}
