package tip.lt1000.p851_900;

import java.util.ArrayList;
import java.util.List;

/**
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * <p>
 * <p>
 * <p>
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * <p>
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * <p>
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 * 示例 5：
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 * <p>
 * 提示：
 * 给定的两棵树可能会有 1 到 200 个结点。
 * 给定的两棵树上的值介于 0 到 200 之间。
 *
 * @author hc
 */
public class Demo872 {

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

    /**
     * 深度优先 dfs 递归
     * 怎么确定找到叶子节点 -> 左右子树均为 null
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        String s1 = dfs(root1, "");
        String s2 = dfs(root2, "");
        return s1.equals(s2);
    }

    private String dfs(TreeNode root, String str) {
        if (root == null) {
            return str;
        }

        if (root.left == null && root.right == null) {
            // 针对数字不一样的节点，用String来存储的话，有变成一样的可能性
            // 比如 7,14 和 71,4   -> 数字后加一个 分隔符
            str = str + root.val + '-';
            return str;
        }
        return dfs(root.left, str) + dfs(root.right, str);
    }

    /**
     * 优化思路 -> String底层调用的是 StringBuilder 方法，递归会产生多次初始化
     * -> 换成动态数组
     */
    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        dfs2(root1, arr1);
        dfs2(root2, arr2);
        if (arr1.size() != arr2.size()) {
            return false;
        }
        int size = arr1.size();
        for (int i = 0; i < size; i++) {
            if (!arr1.get(i).equals(arr2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void dfs2(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            arr.add(root.val);
        }
        if (root.left != null) {
            dfs2(root.left, arr);
        }
        if (root.right != null) {
            dfs2(root.right, arr);
        }
    }
}
