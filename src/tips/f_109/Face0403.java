package tips.f_109;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表
 * （比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 * <p>示例：
 * 输入：[1,2,3,4,5,null,7,8]
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 * @author hc
 */
public class Face0403 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(tree);
        List<ListNode> list = new LinkedList<>();
        ListNode dummyHead = new ListNode(-1);
        while (!deque.isEmpty()) {
            int count = deque.size();
            ListNode cur = dummyHead;
            for (int i = 0; i < count; i++) {
                TreeNode root = deque.poll();
                cur.next = new ListNode(root.val);
                cur = cur.next;
                if (root.left != null) {
                    deque.add(root.left);
                }
                if (root.right != null) {
                    deque.add(root.right);
                }
            }
            list.add(dummyHead.next);
        }

        int size = list.size();
        ListNode[] res = new ListNode[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
