package 刷题笔记.力扣.热门100.LC19_删除链表的倒数第N个结点;

import 学习笔记.剑指Offer.utils.ListNode;

public class Solution {

    /**
     * 删除链表的倒数第N个结点
     * 注意:建立dummy节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (n > 0) {
            // 这一步其实不用验证，题目保证n在链表长度内
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        // 返回是哑结点的后继 != head,因为删除倒数第n个节点时，head已被删除
        return dummy.next;
    }

}
