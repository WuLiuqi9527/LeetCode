package tips.p_1000.p151_200;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。
 * 指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 * <p>
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 *
 * @author hc
 */
public class Demo173 {

    /**
     * 实现迭代器 中序遍历二叉搜索树
     * 二叉搜索树的中序遍历 升序
     * 为实现平均时间复杂度 O(1) 采用分段中序遍历 左子树寻找最小值
     * 构造函数中 压入左子树 next函数中 压入右子树
     */
    class BSTIterator {

        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            // 一直将左子树压栈，弹出的是左子树最小值 符合中序遍历
            // 如果其右孩子不为空，需要维护栈 右子树的最小值
            TreeNode tem = stack.pop();
            int res = tem.val;
            tem = tem.right;
            while (tem != null) {
                stack.push(tem);
                tem = tem.left;
            }
            return res;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    class BSTIterator2 {

        // 利用线性空间降低时间复杂度
        List<Integer> list;
        int index = 0;

        public BSTIterator2(TreeNode root) {
            list = new ArrayList<>();
            addList(list, root);
        }

        private void addList(List<Integer> list, TreeNode root) {
            if (root != null) {
                return;
            }
            // 中序遍历
            addList(list, root.left);
            list.add(root.val);
            addList(list, root.right);
        }

        public int next() {
            int res = list.get(index);
            ++index;
            return res;
        }

        public boolean hasNext() {
            return index < list.size();
        }
    }
}
