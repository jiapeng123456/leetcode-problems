/**
 * Leetcode - p0876_middle_of_the_linked_list
 */
package com.leetcode.p0876_middle_of_the_linked_list;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/**
 *
 * 自己实现：快慢指针法。
 */
class Solution2 implements Solution {

    public ListNode middleNode(ListNode head) {
        // 如果只有一个节点
        if (head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
