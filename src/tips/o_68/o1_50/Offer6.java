package tips.o_68.o1_50;

import common.ListNode;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>限制：
 * 0 <= 链表长度 <= 10000
 *
 * @author hc
 */
public class Offer6 {

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.add(cur.val);
            cur = cur.next;
        }
        int len = stack.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    public int[] reversePrint2(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            ++len;
            cur = cur.next;
        }

        cur = head;
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; --i) {
            res[i] = cur.val;
            cur = cur.next;
        }
        return res;
    }
}
