/**
 * Leetcode - p0567_permutation_in_string
 */
package com.leetcode.p0567_permutation_in_string;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/**
 *
 * 自己实现：根据滑动窗口原理的实现
 * 和官方不一样：
 * - 官方是根据长度，缩小窗口。
 * - 自己实现，是合法的字母数量，进行缩小窗口。

 */
class Solution2 implements Solution {

    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
            window.put(c, 0);
        }


        int left = 0, right = 0;
        int valid = 0;
        int slen = s2.length();

        char ch;
        while (right < slen) {
            ch = s2.charAt(right);
            right++;

            if (need.containsKey(ch)) {

                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (Objects.equals(window.get(ch), need.get(ch))) {
                    valid++;
                }

                while (window.get(ch).compareTo(need.get(ch)) > 0) {
                    char d = s2.charAt(left);
                    left++;

                    if (Objects.equals(window.get(d), need.get(d))) {
                        valid--;
                    }

                    window.put(d, window.get(d) - 1);
                }


                if (valid == need.size()) {
                    return true;
                }

            } else {
                // TODO: 2022/3/15 每次都 clear，效率不高
                window.clear();
                valid = 0;
                left = right;
                // clear vars
            }
        }

        return false;
    }

}
