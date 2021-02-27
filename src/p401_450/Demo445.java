package p401_450;

import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶：
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例：
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * @author hc
 */
public class Demo445 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stackOne = new Stack<>();
        Stack<Integer> stackTwo = new Stack<>();

        while (l1 != null) {
            stackOne.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stackTwo.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode res = null;
        while (!stackOne.isEmpty() || !stackTwo.isEmpty() || carry != 0) {

            // carry 进位
            int one = stackOne.isEmpty() ? 0 : stackOne.pop();
            int two = stackTwo.isEmpty() ? 0 : stackTwo.pop();
            int cur = one + two + carry;
            carry = cur / 10;
            cur = cur % 10;
            ListNode node = new ListNode(cur);
            node.next = res;
            res = node;
        }

        return res;
    }
}
