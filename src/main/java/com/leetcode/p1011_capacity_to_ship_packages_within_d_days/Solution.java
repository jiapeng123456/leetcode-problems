/**
 * Leetcode - p1011_capacity_to_ship_packages_within_d_days
 */
package com.leetcode.p1011_capacity_to_ship_packages_within_d_days;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface Solution {

    // use this Object to print the log (call from slf4j facade)
    static Logger log = LoggerFactory.getLogger(Solution.class);

    int shipWithinDays(int[] weights, int days);
    
}
