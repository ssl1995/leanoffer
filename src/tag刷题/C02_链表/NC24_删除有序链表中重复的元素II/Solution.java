package tag刷题.C02_链表.NC24_删除有序链表中重复的元素II;

import tag刷题.utils.ListNode;

public class Solution {
    // 题目：给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            // 没有后继||前后不一致，就加入pre后继
            if (cur.next == null || cur.val != cur.next.val) {
                pre.next = cur;
                pre = cur;
            }
            // 否则，就一直后移cur，让cur指向相同节点的最后一个节点
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            // 本题不保留重复结点，这里不用pre.next = cur
            // 相同节点的最后一个结点不保留，后移cur
            cur = cur.next;
        }
        pre.next = null;
        return dummy.next;
    }
}
