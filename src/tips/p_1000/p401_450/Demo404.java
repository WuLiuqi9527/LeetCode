package tips.p_1000.p401_450;

import common.TreeNode;

/**
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * @author hc
 */
public class Demo404 {

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // 左叶子
        int res = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }

        return res + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
