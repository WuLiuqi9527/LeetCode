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

    public static class ListNode {
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

        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        int len = 1;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
            ++len;
        }

        // 滤去多余循环
        k = k % len;
        if (k == 0) {
            return head;
        }

        // 构造环形链表，直接找 last 将要指向的节点，其下一个节点即为头结点
        last.next = head;
        // 往前挪 k 位 相等于 往后挪 len-k 位
        for (int i = 0; i < len - k; i++) {
            last = last.next;
        }
        ListNode res = last.next;
        last.next = null;

        return res;
    }

    public static void main(String[] args) {
        new Demo61().rotateRight(new ListNode(0, new ListNode(1, new ListNode(2))), 4);
    }
}
