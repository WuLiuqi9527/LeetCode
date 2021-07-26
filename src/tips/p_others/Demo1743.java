package tips.p_others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
 * 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，
 * 其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
 * 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，
 * 存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。
 * 这些相邻元素对可以 按任意顺序 出现。
 * 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
 * <p>示例 1：
 * 输入：adjacentPairs = [[2,1],[3,4],[3,2]]
 * 输出：[1,2,3,4]
 * 解释：数组的所有相邻元素对都在 adjacentPairs 中。
 * 特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
 * <p>示例 2：
 * 输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * 输出：[-2,4,1,-3]
 * 解释：数组中可能存在负数。
 * 另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
 * <p>示例 3：
 * 输入：adjacentPairs = [[100000,-100000]]
 * 输出：[100000,-100000]
 * <p>提示：
 * nums.length == n
 * adjacentPairs.length == n - 1
 * adjacentPairs[i].length == 2
 * 2 <= n <= 10^5
 * -10^5 <= nums[i], ui, vi <= 10^5
 * 题目数据保证存在一些以 adjacentPairs 作为元素对的数组 nums
 *
 * @author hc
 */
public class Demo1743 {

    public int[] restoreArray(int[][] aps) {
        int m = aps.length, n = m + 1;
        Map<Integer, Integer> cnts = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] ap : aps) {
            int a = ap[0], b = ap[1];
            cnts.put(a, cnts.getOrDefault(a, 0) + 1);
            cnts.put(b, cnts.getOrDefault(b, 0) + 1);
            List<Integer> alist = map.getOrDefault(a, new ArrayList<>());
            alist.add(b);
            map.put(a, alist);
            List<Integer> blist = map.getOrDefault(b, new ArrayList<>());
            blist.add(a);
            map.put(b, blist);
        }
        int start = -1;
        for (int i : cnts.keySet()) {
            if (cnts.get(i) == 1) {
                start = i;
                break;
            }
        }
        int[] ans = new int[n];
        ans[0] = start;
        ans[1] = map.get(start).get(0);
        for (int i = 2; i < n; i++) {
            int x = ans[i - 1];
            List<Integer> list = map.get(x);
            for (int j : list) {
                if (j != ans[i - 2]) {
                    ans[i] = j;
                }
            }
        }
        return ans;
    }

    class Node {
        public int value;
        public Node n1 = null;
        public Node n2 = null;

        public Node(int value) {
            this.value = value;
        }
    }

    public int[] restoreArray2(int[][] adjacentPairs) {
        int[] ret = new int[adjacentPairs.length + 1];
        Map<Integer, Node> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            Node a = map.get(pair[0]);
            if (a == null) {
                a = new Node(pair[0]);
                map.put(pair[0], a);
            }
            Node b = map.get(pair[1]);
            if (b == null) {
                b = new Node(pair[1]);
                map.put(pair[1], b);
            }
            if (a.n1 == null) {
                a.n1 = b;
            } else {
                a.n2 = b;
            }
            if (b.n1 == null) {
                b.n1 = a;
            } else {
                b.n2 = a;
            }
        }
        Node p = null;
        for (Node n : map.values()) {
            if (n.n2 == null) {
                p = n;
                break;
            }
        }
        ret[0] = p.value;
        Node pre = p;
        p = p.n1;
        for (int i = 1; i < ret.length; i++) {
            ret[i] = p.value;
            if (p.n1 == pre) {
                pre = p;
                p = p.n2;
            } else {
                pre = p;
                p = p.n1;
            }
        }
        return ret;
    }
}
