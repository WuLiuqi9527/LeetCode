package tips.f_109.f_10;

import common.ListNode;

/**
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>进阶：
 * 你是否可以不用额外空间解决此题？
 *
 * @author hc
 */
public class Face0208 {

    public ListNode detectCycle(ListNode head) {
        // 快慢指针
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) {return null;}
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {break;}
        }

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return slow;
    }
}
