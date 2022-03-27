/**
 * Leetcode - p0704_Binary_Search
 */
package com.leetcode.p0704_Binary_Search;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface Solution {

    // use this Object to print the log (call from slf4j facade)
    static Logger log = LoggerFactory.getLogger(Solution.class);

    int search(int[] nums, int target);
    
}
