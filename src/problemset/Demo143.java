package problemset;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * @author hc
 */
public class Demo143 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head) {

        Deque<ListNode> deque = new ArrayDeque<>();

        ListNode cur = head;
        while (cur != null) {
            deque.add(cur);
            cur = cur.next;
        }

        int k = 1;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (!deque.isEmpty()) {
            if (k % 2 == 1) {
                dummy.next = deque.pollFirst();
            } else if (k % 2 == 0) {
                dummy.next = deque.pollLast();
            }
            dummy = dummy.next;
            ++k;
        }

        dummy.next = null;
    }
}
