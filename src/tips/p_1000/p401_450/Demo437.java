package tips.p_1000.p401_450;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * @author hc
 */
public class Demo437 {

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

    public int pathSum(TreeNode root, int sum) {

        if (root == null){return 0;}

        int res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);

        return res;
    }

    private int findPath(TreeNode node, int num) {
        if (node == null ){return 0;}

        int res = 0;
        if (node.val == num){
            res += 1;
        }

        res += findPath(node.left, num - node.val);
        res += findPath(node.right, num - node.val);

        return res;
    }
}
