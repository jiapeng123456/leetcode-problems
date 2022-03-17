/**
 * Leetcode - p0438_find_all_anagrams_in_a_string
 */
package com.leetcode.p0438_find_all_anagrams_in_a_string;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 * 使用滑动窗口模板的实现.
 *
 */
class Solution2 implements Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> rtn = new ArrayList<>();

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
            window.put(c, 0);
        }

        int left = 0, right = 0;
        int valid = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.get(c) + 1);

                if (Objects.equals(window.get(c), need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    rtn.add(left);
                }

                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (Objects.equals(window.get(d), need.get(d))) {
                        valid--;
                    }

                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return rtn;
    }


}
