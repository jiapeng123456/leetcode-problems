/**
 * Leetcode - p0876_middle_of_the_linked_list
 */
package com.leetcode.p0876_middle_of_the_linked_list;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 *  官方实现
 */
class Solution1 implements Solution {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
