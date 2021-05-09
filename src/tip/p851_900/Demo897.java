package tip.p851_900;

/**
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
 * 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * <p>提示：
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 *
 * @author hc
 */
public class Demo897 {

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

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.right = increasingBST(root.right);
        if (root.left != null) {
            TreeNode node = root.left;
            TreeNode head = node;
            root.left = null;
            while (node.right != null) {
                node = node.right;
            }
            node.right = root;
            return increasingBST(head);
        } else {
            return root;
        }
    }
}
