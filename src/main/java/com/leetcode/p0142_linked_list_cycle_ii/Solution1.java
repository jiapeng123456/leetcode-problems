/**
 * Leetcode - p0142_linked_list_cycle_ii
 */
package com.leetcode.p0142_linked_list_cycle_ii;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/**
 *
 * 书上的实现。实现的比较简洁。
 *
 */
class Solution1 implements Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // 如果没有环
        if (fast == null || fast.next == null) {
            return null;
        }

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
