package tip.p51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @author hc
 */
public class Demo77 {

    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }

        List<Integer> c = new ArrayList<>();
        generateCombinations(n, k, 1, c);

        return res;
    }

    private void generateCombinations(int n, int k, int index, List<Integer> c) {

        if (c.size() == k) {
            res.add(new ArrayList<>(c));
            return;
        }

        /**
         * 一旦选定 i ，还有 k - c.size() 个位置
         * [1, .., n] 之间至少要有 k - c.size() 个元素
         * 即 n - i + 1 >= k - c.size()
         * -> i 最多为 n - (k - c.size()) + 1
         * n - (k - c.size()) + 1 剪枝
         */
        for (int i = index; i <= n - (k - c.size()) + 1; i++) {
            c.add(i);
            generateCombinations(n, k, i + 1, c);
            c.remove(c.size() - 1);
        }
        return;
    }

    public static void main(String[] args) {
        System.out.println(new Demo77().combine(4, 2));
    }
}
