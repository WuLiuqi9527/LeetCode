package tips.f_109;

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * <p>示例：
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 * <p>示例：
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *
 * @author hc
 */
public class Face0205 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode l3 = new ListNode(-1), cur = l3;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int one = 0;
            int two = 0;
            if (l1 != null) {
                one = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                two = l2.val;
                l2 = l2.next;
            }
            int sum = one + two + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }

        if (carry != 0) {
            if (carry < 10) {
                cur.next = new ListNode(carry);
            } else {
                while (carry % 10 != 0) {
                    cur.next = new ListNode(carry % 10);
                    cur = cur.next;
                    carry = carry / 10;
                }
            }
        }
        return l3.next;
    }
}
