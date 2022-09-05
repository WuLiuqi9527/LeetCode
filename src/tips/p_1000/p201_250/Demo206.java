package tips.p_1000.p201_250;

import common.ListNode;

/**
 * 反转一个单链表。
 * <p>示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @author hc
 */
public class Demo206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            // 维护 pre、cur 为下一次循环做准备
            pre = cur;
            cur = next;
        }

        return pre;
    }
}