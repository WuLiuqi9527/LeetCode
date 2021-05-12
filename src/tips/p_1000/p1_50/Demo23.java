package tips.p_1000.p1_50;

import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * @author hc
 */
public class Demo23 {

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

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        // 比较头结点的 val
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) {
                // 取头结点 剩下的扔回优先队列
                queue.add(p.next);
            }
        }
        return dummy.next;
    }
}
