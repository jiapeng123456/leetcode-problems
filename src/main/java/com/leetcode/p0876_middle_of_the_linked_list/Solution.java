/**
 * Leetcode - p0876_middle_of_the_linked_list
 */
package com.leetcode.p0876_middle_of_the_linked_list;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface Solution {

    // use this Object to print the log (call from slf4j facade)
    static Logger log = LoggerFactory.getLogger(Solution.class);

    ListNode middleNode(ListNode head);
}
