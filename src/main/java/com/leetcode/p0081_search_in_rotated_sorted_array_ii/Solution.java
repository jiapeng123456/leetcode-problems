/**
 * Leetcode - p0081_search_in_rotated_sorted_array_ii
 */
package com.leetcode.p0081_search_in_rotated_sorted_array_ii;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface Solution {

    // use this Object to print the log (call from slf4j facade)
    static Logger log = LoggerFactory.getLogger(Solution.class);

    boolean search(int[] nums, int target);
}
