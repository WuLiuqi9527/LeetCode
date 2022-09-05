package tips.p_1000.p101_150;

import common.TreeNode;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，
 * 其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 *
 * 解法：
 *      1、将左子树插入到右子树的地方
 *      2、将原来的右子树接到左子树的最右边节点
 *      3、考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
 * @author hc
 */
public class Demo114 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // 将根节点的左子树变成链表
        flatten(root.left);
        // 将根节点的右子树变成链表
        flatten(root.right);

        TreeNode tem = root.right;
        // 把左子树挂接到根节点 right 上
        root.right = root.left;
        // 原左子树置空
        root.left = null;

        // 找到树的最右边的节点
        // 将前面分开的右子树挂接到由左子树新生成的树上
        while (root.right != null) {
            root = root.right;
        }
        root.right = tem;
    }
}
