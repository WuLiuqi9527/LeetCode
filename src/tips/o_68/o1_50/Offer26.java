package tips.o_68.o1_50;

import common.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>示例 1：
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * <p>示例 2：
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * <p>限制：
 * 0 <= 节点个数 <= 10000
 *
 * @author hc
 */
public class Offer26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 空树不是任意一个树的子结构
        if (A == null || B == null) {
            return false;
        }
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean dfs(TreeNode A, TreeNode B) {
        // 终止条件
        // 当节点 B 为空: 说明树 B 已匹配完成(越过叶子节点),因此返回 true;
        if (B == null) {
            return true;
        }
        // 当节点 A 为空: 说明已经越过树 A 叶子节点, 即匹配失败，返回 false;
        if (A == null) {
            return false;
        }
        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}
