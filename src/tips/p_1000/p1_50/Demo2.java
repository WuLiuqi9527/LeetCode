package tips.p_1000.p1_50;

import java.util.ArrayList;

/**
 * @author hc
 * <p>
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Demo2 {

    public static class ListNode {

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

    /**
     * 1、转数字，求和，转回链表 (X) 链表可以很长，而 int long.. 取值范围有限，会溢出
     * 2、链表节点转数组，判断进位，再恢复链表, 费空间（笔试可以，面试最好不要）
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        ArrayList<Integer> arr3 = new ArrayList<>();
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {

            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;

            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;
            arr3.add(sumVal % 10);

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        for (int i = 0; i < arr3.size(); i++) {
            res.next = new ListNode(arr3.get(i));
            res = res.next;
        }
        return dummy.next;
    }

    /**
     * 3、直接处理链表
     * 为了处理方法统一，可以先建立一个虚拟头结点
     * 这个虚拟头结点的 next 指向真正的 head ，这样 head 就不需要单独处理，直接 while 循环即可
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            //cursor始终指向 new 出的新结点
            cursor = sumNode;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return root.next;
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        printNode(listNode1);
        printNode(listNode2);
        printNode(new Demo2().addTwoNumbers(listNode1, listNode2));
    }

    /**
     * 打印链表
     *
     * @param listNode
     */
    public static void printNode(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        String str = " " + listNode.val;
        while (listNode.next != null) {
            str += "->" + listNode.next.val;
            listNode = listNode.next;
        }
        System.out.println(str += " ");
    }
}
