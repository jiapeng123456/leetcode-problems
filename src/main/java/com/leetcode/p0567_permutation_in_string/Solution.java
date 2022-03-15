/**
 * Leetcode - p0567_permutation_in_string
 */
package com.leetcode.p0567_permutation_in_string;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface Solution {

    // use this Object to print the log (call from slf4j facade)
    static Logger log = LoggerFactory.getLogger(Solution.class);

    boolean checkInclusion(String s1, String s2);
}
