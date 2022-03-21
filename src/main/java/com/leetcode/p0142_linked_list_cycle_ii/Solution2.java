/**
 * Leetcode - p0142_linked_list_cycle_ii
 */
package com.leetcode.p0142_linked_list_cycle_ii;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/**
 *
 * 自己实现
 */
class Solution2 implements Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                break;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        // 如果没有环
        if (fast == null || fast.next == null) {
            return null;
        }

        // 把其中一个指针设置成边表的开始节点
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }



}