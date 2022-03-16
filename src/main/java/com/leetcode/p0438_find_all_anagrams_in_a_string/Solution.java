/**
 * Leetcode - p0438_find_all_anagrams_in_a_string
 */
package com.leetcode.p0438_find_all_anagrams_in_a_string;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface Solution {

    // use this Object to print the log (call from slf4j facade)
    static Logger log = LoggerFactory.getLogger(Solution.class);

    List<Integer> findAnagrams(String s, String p);
}
