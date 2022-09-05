package tips.p_1000.p1_50;

import common.ListNode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * @author hc
 */
public class Demo25 {

    public ListNode reverseKGroup(ListNode head, int k) {

        // 取 k 个元素
        int listNum = 0;
        ListNode check = head;
        while (listNum < k && check != null) {
            check = check.next;
            ++listNum;
        }

        if (listNum == k) {

            int count = 0;
            ListNode pre = null;
            ListNode cur = head;
            ListNode next = null;
            while (count < k && cur != null) {

                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;

                ++count;
            }
            if (next != null) {
                head.next = reverseKGroup(next, k);
            }
            return pre;
        } else {
            return head;
        }
    }
}
