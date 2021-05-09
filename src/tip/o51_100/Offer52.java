package tip.o51_100;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * @author hc
 */
public class Offer52 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        ListNode h1 = headA, h2 = headB;
        while (h1 != h2) {
            h1 = h1 != null ? h1.next : headB;
            h2 = h2 != null ? h2.next : headA;
        }
        return h1;
    }
}
