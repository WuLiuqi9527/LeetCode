package tips.f_109.f_10;

import common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
 * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
 * 分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 * <p>示例:
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 *
 * @author hc
 */
public class Face0204 {

    public ListNode partition(ListNode head, int x) {
        ListNode cur = head, dummy = new ListNode(-1);
        Deque<Integer> lower = new ArrayDeque<>();
        Deque<Integer> higher = new ArrayDeque<>();
        while (cur != null) {
            if (cur.val < x) {
                lower.push(cur.val);
            } else {
                higher.push(cur.val);
            }
            cur = cur.next;
        }
        cur = dummy;
        while (!lower.isEmpty()) {
            cur.next = new ListNode(lower.pop());
            cur = cur.next;
        }
        while (!higher.isEmpty()) {
            cur.next = new ListNode(higher.pop());
            cur = cur.next;
        }

        return dummy.next;
    }

    public ListNode partition2(ListNode head, int x) {
        // 双指针拼接
        ListNode lower = new ListNode(-1), lowerCur = lower;
        ListNode higher = new ListNode(-1), higherCur = higher;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                lowerCur.next = cur;
                lowerCur = lowerCur.next;
            } else {
                higherCur.next = cur;
                higherCur = higherCur.next;
            }
            cur = cur.next;
        }

        lowerCur.next = higher.next;
        higherCur.next = null;
        return lower.next;
    }
}
