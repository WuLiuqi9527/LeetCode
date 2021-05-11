package tip.lt1000.p51_100;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @author hc
 */
public class Demo92 {

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

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 遍历到 left 前一个节点 left 从1开始
        ListNode superior = dummyHead;
        for (int i = 1; i < left; i++) {
            superior = superior.next;
        }

        ListNode pre = null;
        ListNode cur = superior.next;
        for (int i = 0; i <= right - left; i++) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // right 后接上
        superior.next.next = cur;
        // left 前接上
        superior.next = pre;

        return dummyHead.next;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        // left 是从 1 开始计算的
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        head = pre.next;
        for (int i = left; i < right; i++) {
            ListNode next = head.next;

            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;
    }
}
