package p51_100;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * @author hc
 */
public class Demo106 {

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return postIn(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder);
    }

    private TreeNode postIn(int lIn, int rIn, int lPost, int rPost, int[] inorder, int[] postorder) {

        if (lIn > rIn || lPost > rPost) {
            return null;
        }

        // 中序 {左子树，根节点，右子树} 后序 {左子树，右子树，根节点}
        TreeNode root = new TreeNode(postorder[rPost]);

        // 找到中序的根节点
        int rootIn = 0;
        while (rootIn <= rIn && inorder[rootIn] != postorder[rPost]) {
            ++rootIn;
        }

        int leftNum = rootIn - lIn;
        root.left = postIn(lIn, rootIn - 1, lPost, lPost + leftNum - 1, inorder, postorder);
        root.right = postIn(rootIn + 1, rIn, lPost + leftNum, rPost - 1, inorder, postorder);

        return root;
    }
}
