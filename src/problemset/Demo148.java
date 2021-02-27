package problemset;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * @author hc
 */
public class Demo148 {

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

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // 快慢指针找出中位点
        ListNode slowP = head, fastP = head.next.next, l, r;
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }

        // 对右半部分进行归并排序
        r = mergeSort(slowP.next);
        // 链表判断结束的标志：末尾节点.next==null
        slowP.next = null;
        // 对左半部分进行归并排序
        l = mergeSort(head);
        return mergeList(l, r);
    }

    private ListNode mergeList(ListNode l, ListNode r) {
        // 临时头节点
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        while (l != null && r != null) {
            if (l.val < r.val) {
                p.next = l;
                l = l.next;
            } else {
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }
        p.next = l == null ? r : l;
        return dummyHead.next;
    }
}
