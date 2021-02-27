package problemset;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * 示例 1：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 *
 * @author hc
 */
public class Demo86 {

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

    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode listNodeOne = new ListNode(-1000);
        ListNode listNodeTwo = new ListNode(-1000);

        ListNode listOne = listNodeOne;
        ListNode listTwo = listNodeTwo;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                listOne.next = cur;
                cur = cur.next;
                listOne = listOne.next;
                listOne.next = null;
            } else {
                listTwo.next = cur;
                cur = cur.next;
                listTwo = listTwo.next;
                listTwo.next = null;
            }
        }

        listOne.next = listNodeTwo.next;

        return listNodeOne.next;
    }
}
