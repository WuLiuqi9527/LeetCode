package tips.o_68.o1_50;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>限制：
 * 0 <= 节点个数 <= 5000
 *
 * @author hc
 */
public class Offer7 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return preIn(0, preorder.length-1, 0, inorder.length-1, preorder, inorder);
    }

    private TreeNode preIn(int lPre, int rPre, int lIn, int rIn, int[] preorder, int[] inorder) {

        if (lPre > rPre || lIn > rIn) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[lPre]);
        // 找到中序遍历中的根节点，以此划分左子树和右子树
        int rootIn = lIn;
        while (rootIn <= rIn && preorder[lPre] != inorder[rootIn]) {
            ++rootIn;
        }

        int leftNum = rootIn - lIn;
        root.left = preIn(lPre + 1, lPre + leftNum, lIn, rootIn - 1, preorder, inorder);
        root.right = preIn(lPre + 1 + leftNum, rPre, rootIn + 1, rIn, preorder, inorder);

        return root;
    }
}
