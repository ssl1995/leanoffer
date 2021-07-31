package tag刷题.C02_链表.剑指Offer24_反转链表;


import tag刷题.utils.ListNode;

public class Solution {
    // 法1:迭代法
    public ListNode reverseList1(ListNode head) {
        ListNode cur = head;
        // pre只是记录cur的前一个结点,不会使用到任何next结点
        ListNode pre = null;
        while (cur != null) {
            // 一定是先记录cur后一个节点
            ListNode next = cur.next;
            // 从cur开始改变指向
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 法2:递归法
    public ListNode reverseList2(ListNode head) {
        // base case：参数head为null，或者此时递归的head无下一个结点
        if (head == null || head.next == null) {
            return head;
        }
        // 开始递归，head.next为下一轮的head1，当head1.next=null递归停止
        // 此时head1位整个链表的末尾节点（反转链表后的头结点），这一轮的head为倒数第二个节点
        ListNode ret = reverseList2(head.next);
        // head为倒数第二个节点，开始反转最后的两个链表
        head.next.next = head;
        // 倒数第二个节点next判空,供上一层调用
        head.next = null;
        return ret;
    }


}
