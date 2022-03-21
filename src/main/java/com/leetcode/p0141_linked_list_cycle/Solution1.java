/**
 * Leetcode - p0141_linked_list_cycle
 */
package com.leetcode.p0141_linked_list_cycle;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/**
 * 快慢指针法：书上的实现。
 * 优点：代码比较简洁。
 *
 */
class Solution1 implements Solution {

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
