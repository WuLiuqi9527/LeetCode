package tips.p_1000.p201_250;

import common.TreeNode;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：
 * 在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * @author hc
 */
public class Demo222 {

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        return leftDepth == rightDepth ? (1 << leftDepth)+countNodes(root.right):(1<< rightDepth)+countNodes(root.left);
    }

    private int depth(TreeNode node) {
        int depth = 0;

        while (node != null) {
            ++depth;
            // 完全二叉树 往左下搜
            node = node.left;
        }

        return depth;
    }
}
