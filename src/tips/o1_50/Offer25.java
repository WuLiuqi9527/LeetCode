package tips.o1_50;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>示例 1 ：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>限制：
 * 0 <= 链表长度 <= 1000
 *
 * @author hc
 */
public class Offer25 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            cur.next = l2;
        } else if (l2 == null) {
            cur.next = l1;
        }
        return dummy.next;
    }
}
