/**
 * Leetcode - p0141_linked_list_cycle
 */
package com.leetcode.p0141_linked_list_cycle;

import com.ciaoshen.leetcode.util.ListNode;

/** 
 *
 * for execise
 */
class Solution3 implements Solution {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
