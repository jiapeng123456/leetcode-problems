/**
 * Leetcode - p0167_two_sum_ii
 */
package com.leetcode.p0167_two_sum_ii;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface Solution {

    // use this Object to print the log (call from slf4j facade)
    static Logger log = LoggerFactory.getLogger(Solution.class);

    int[] twoSum(int[] numbers, int target);
}
