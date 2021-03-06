/**
 * Leetcode - p1094_car_pooling
 */
package com.leetcode.p1094_car_pooling;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface Solution {

    // use this Object to print the log (call from slf4j facade)
    static Logger log = LoggerFactory.getLogger(Solution.class);

    boolean carPooling(int[][] trips, int capacity);
    
}
