package p101_150;

/**
 * 对链表进行插入排序。
 * 从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 * 示例 1：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * @author hc
 */
public class Demo147 {

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

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre;
        ListNode cur = head;
        while (cur != null && cur.next != null) {

            if (cur.val <= cur.next.val) {
                cur = cur.next;
                continue;
            }

            pre = dummy;
            while (pre.next.val < cur.next.val){
                pre = pre.next;
            }

            // 调整链表指向 排序
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}
