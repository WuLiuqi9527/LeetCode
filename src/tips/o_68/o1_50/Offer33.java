package tips.o_68.o1_50;

/**
 * 输入一个整数数组，判断该数组是不是某 二叉搜索树 的 后序遍历 结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 * <p>示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 * <p>提示：
 * 数组长度 <= 1000
 *
 * @author hc
 */
public class Offer33 {

    /**
     * 二叉搜索树是 left < root < right 的，后序遍历的顺序是 left->right->root
     * postorder[len - 1] -> root
     * [1,3,2 | 6 | 5] 分三段
     */
    public boolean verifyPostorder(int[] postorder) {
        return dfs(postorder, 0, postorder.length - 1);
    }

    private boolean dfs(int[] postorder, int l, int r) {
        // l >= r 说明已经遍历完，都成立
        if (l >= r) {
            return true;
        }

        int root = postorder[r];
        int rStart = l;
        while (rStart < r && postorder[rStart] < root) {
            ++rStart;
        }
        for (int i = rStart; i <= r; i++) {
            if (postorder[i] < root) {
                return false;
            }
        }

        if (!dfs(postorder, l, rStart - 1)) {
            return false;
        }
        if (!dfs(postorder, rStart, r - 1)) {
            return false;
        }
        return true;
    }
}
