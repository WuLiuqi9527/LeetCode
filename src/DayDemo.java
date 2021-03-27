import p51_100.Demo97;

import java.util.ArrayList;

/**
 * @author hc
 */
public class DayDemo {

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

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        ArrayList<ListNode> mem = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            mem.add(node);
            node = node.next;
        }

        int len = mem.size();
        for (int i = 0; i < k; i++) {
            int pre = len - 2;
            int last = len - 1;
            mem.get(pre).next = null;
            mem.get(last).next = head;
            head = mem.get(last);
        }
        return head;
    }

    public static void main(String[] args) {
        new DayDemo().rotateRight(new ListNode(0,new ListNode(1,new ListNode(2))), 4);
    }
}
