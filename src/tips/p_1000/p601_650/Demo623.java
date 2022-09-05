package tips.p_1000.p601_650;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
 * 注意，根节点 root 位于深度 1 。
 * 加法规则如下:
 * 给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 * <p>示例 1:
 * 输入: root = [4,2,6,3,1,5], val = 1, depth = 2
 * 输出: [4,1,1,2,null,null,6,3,1,5]
 * <p>示例 2:
 * 输入: root = [4,2,null,3,1], val = 1, depth = 3
 * 输出:  [4,2,null,1,1,3,null,null,1]
 * <p>提示:
 * 节点数在 [1, 10^4] 范围内
 * 树的深度在 [1, 10^4]范围内
 * -100 <= Node.val <= 100
 * -10^5 <= val <= 10^5
 * 1 <= depth <= the depth of tree + 1
 */
public class Demo623 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode ans = new TreeNode(val);
            ans.left = root;
            return ans;
        }
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        int cur = 1;
        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                TreeNode poll = d.pollFirst();
                if (cur == depth - 1) {
                    TreeNode left = new TreeNode(val);
                    TreeNode right = new TreeNode(val);
                    left.left = poll.left;
                    right.right = poll.right;
                    poll.left = left;
                    poll.right = right;
                } else {
                    if (poll.left != null) {
                        d.addLast(poll.left);
                    }
                    if (poll.right != null) {
                        d.addLast(poll.right);
                    }
                }
            }
            cur++;
        }
        return root;
    }
}
