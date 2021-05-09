package tip.p101_150;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。
 * 即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历
 *
 * @author hc
 */
public class Demo107 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> lists = new LinkedList<>();

        if (root == null) {
            return lists;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();

            // list 内元素个数 使用 count 维护
            while (count > 0) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                --count;
            }
            lists.add(0,list);
        }

        return lists;
    }
}
