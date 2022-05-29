/**
 * Leetcode - p1109_corporate_flight_bookings
 */
package com.leetcode.p1109_corporate_flight_bookings;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface Solution {

    // use this Object to print the log (call from slf4j facade)
    static Logger log = LoggerFactory.getLogger(Solution.class);

    int[] corpFlightBookings(int[][] bookings, int n);
    
}
