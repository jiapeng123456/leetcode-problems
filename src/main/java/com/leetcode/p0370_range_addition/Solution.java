/**
 * Leetcode - p0370_range_addition
 */
package com.leetcode.p0370_range_addition;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface Solution {

    // use this Object to print the log (call from slf4j facade)
    static Logger log = LoggerFactory.getLogger(Solution.class);

    int[] getModifiedArray(int length, int[][] updates);
}
