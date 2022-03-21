/**
 * Leetcode - p0141_linked_list_cycle
 */
package com.leetcode.p0141_linked_list_cycle;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 *
 * 快慢指针法：自己实现
 *
 */
class Solution2 implements Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
