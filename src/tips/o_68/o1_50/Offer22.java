package tips.o_68.o1_50;

import common.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第 k 个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。
 * 这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 *
 * @author hc
 */
public class Offer22 {

    public ListNode getKthFromEnd(ListNode head, int k) {

        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            ++len;
            cur = cur.next;
        }

        cur = head;
        len = len - k;
        while (len-- > 0) {
            cur = cur.next;
        }
        return cur;
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        // 快慢指针 快指针先走 k 步
        ListNode slow = head, fast = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            --k;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
