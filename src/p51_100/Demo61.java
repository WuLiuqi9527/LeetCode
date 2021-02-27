package p51_100;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * @author hc
 */
public class Demo61 {

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

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int count = 1;
        ListNode pre = head;
        while (pre.next != null) {
            pre = pre.next;
            ++count;
        }

        // k > count (链表的长度)
        k = k % count;
        if (k == 0) {
            return head;
        }

        pre.next = head;
        for (int i = 0; i < count - k; i++) {
            pre = pre.next;
        }

        ListNode res = pre.next;
        pre.next = null;

        return res;
    }
}
