package tips.p_1000.p201_250;

import common.TreeNode;

/**
 * 翻转一棵二叉树。
 *
 * @author hc
 */
public class Demo226 {

    public TreeNode invertTree(TreeNode root) {

        if (root == null){return null;}

        TreeNode left = invertTree(root.left);
        TreeNode right= invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
