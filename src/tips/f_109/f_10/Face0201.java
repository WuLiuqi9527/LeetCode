package tips.f_109.f_10;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>示例1:
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * <p>示例2:
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * <p>提示：
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 *
 * @author hc
 */
public class Face0201 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeDuplicateNodes(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        int[] arr = new int[20001];
        arr[head.val] = 1;
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            if (arr[cur.val] == 0) {
                arr[cur.val] = 1;
                pre = cur;
                cur = cur.next;
            } else {
                pre.next = cur.next;
                cur.next = null;
                cur = pre.next;
            }
        }
        return head;
    }
}
