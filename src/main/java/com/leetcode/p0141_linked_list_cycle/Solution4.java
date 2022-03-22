/**
 * Leetcode - p0141_linked_list_cycle
 */
package com.leetcode.p0141_linked_list_cycle;

import com.ciaoshen.leetcode.util.ListNode;

/** 
 *
 * test for fast step is more than 2.
 */
class Solution4 implements Solution {

    /**
     * slow and fast first step is cycle start node
     * @param head
     * @return
     */
//    public boolean hasCycle(ListNode head) {
//        ListNode slow = head.next;
//        ListNode fast = head.next;
//
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//            if (slow == fast) {
//                return true;
//            }
//        }
//
//        return false;
//    }

    /*
    fast step is 5
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null
                && fast.next.next != null
                && fast.next.next.next != null
                && fast.next.next.next.next != null) {
            slow = slow.next.next;
            fast = fast.next.next.next.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
