package problem201_250;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。
 * 传入函数的唯一参数为 要被删除的节点 。
 * <p>
 * 示例 1：
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，
 * 该链表应变为 4 -> 1 -> 9.
 *
 * @author hc
 */
public class Demo237 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {

        if (node.next == null) {
            node = null;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
