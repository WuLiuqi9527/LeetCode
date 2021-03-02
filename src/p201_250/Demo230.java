package p201_250;

import java.util.ArrayList;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * @author hc
 */
public class Demo230 {

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

    int res;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {

        if (root == null) {
            return -1;
        }

        inOrder(root, k);
        return res;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inOrder(root.left, k);
        ++count;
        if (count == k) {
            res = root.val;
            return;
        }
        inOrder(root.right, k);
    }
}