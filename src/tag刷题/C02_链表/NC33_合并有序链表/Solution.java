package tag刷题.C02_链表.NC33_合并有序链表;

import tag刷题.utils.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            // cur要记得后移
            cur = cur.next;
        }
        // cur指向还未非空的链表
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
