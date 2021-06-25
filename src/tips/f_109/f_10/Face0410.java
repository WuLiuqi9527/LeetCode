package tips.f_109.f_10;

/**
 * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 * 注意：此题相对书上原题略有改动。
 * <p>示例1:
 * 输入：t1 = [1, 2, 3], t2 = [2]
 * 输出：true
 * <p>示例2:
 * 输入：t1 = [1, null, 2, 4], t2 = [3, 2]
 * 输出：false
 * <p>提示：
 * 树的节点数目范围为[0, 20000]。
 *
 * @author hc
 */
public class Face0410 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return false;
        }
        return dfs(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    private boolean dfs(TreeNode t1, TreeNode t2) {
        // 深度遍历,树 节点比较
        // t2先遍历完, t2是t1的子树
        if (t2 == null) {
            return true;
        }
        // t1先遍历完,t2不是t1的子树
        if (t1 == null) {
            return false;
        }
        return t1.val == t2.val && dfs(t1.left, t2.left) && dfs(t1.right, t2.right);
    }
}
