package p51_100;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * @author hc
 */
public class Demo105 {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return preIn(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode preIn(int lPre, int rPre, int lIn, int rIn, int[] preorder, int[] inorder) {

        if (lPre > rPre || lIn > rIn) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[lPre]);

        // 寻找中序中 根节点位置
        int rootIn = lIn;
        while (rootIn <= rIn && inorder[rootIn] != preorder[lPre]) {
            ++rootIn;
        }

        // 左子树的节点个数
        int leftNum = rootIn - lIn;

        // 利用前序遍历重建二叉树 前序 {根节点，左子树，右子树}  中序 {左子树，根节点，右子树}
        // 左子树部分分到根节点的左子树 接续递归
        root.left = preIn(lPre + 1, lPre + leftNum, lIn, rootIn - 1, preorder, inorder);
        root.right = preIn(lPre + leftNum + 1, rPre, rootIn + 1, rIn, preorder, inorder);

        return root;
    }

    public static void main(String[] args) {
        new Demo105().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
