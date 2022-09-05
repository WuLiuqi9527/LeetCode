package tips.p_1000.p151_200;

import common.ListNode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * @author hc
 */
public class Demo160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA, b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }

        return a;
    }
}
