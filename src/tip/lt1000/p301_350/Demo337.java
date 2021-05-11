package tip.lt1000.p301_350;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子 有且只有一个 “父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * 示例 1:
 * 输入: [3,4,5,1,3,null,1]
 * <p>
 *     3
 *    / \
 *   4   5
 *  / \   \
 * 1   3   1
 * <p>
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 * @author hc
 */
public class Demo337 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        int[] res = tryRob(root);
        return Math.max(res[0], res[1]);
    }

    private int[] tryRob(TreeNode root) {

        if (root == null) {
            return new int[2];
        }
        int[] dp = new int[2];

        int[] left = tryRob(root.left);
        int[] right = tryRob(root.right);

        /**
         * dp[0] 当前节点不偷  dp[1]  偷取当前节点
         * 1、当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
         * 2、当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
         */
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = left[0] + right[0] + root.val;

        return dp;
    }
}
