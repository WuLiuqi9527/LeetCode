package tips.o_68.o1_50;

import common.TreeNode;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>例如输入：
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * <p>镜像输出：
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>限制：
 * 0 <= 节点个数 <= 1000
 *
 * @author hc
 */
public class Offer27 {

    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
