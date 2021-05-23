package tips.p_others;

import java.util.Arrays;

/**
 * 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
 * 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。
 * 换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。
 * 如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
 * 返回一个整数数组 answer 作为查询的答案，
 * 其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。
 * <p>示例 1：
 * 输入：nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
 * 输出：[3,3,7]
 * 解释：
 * 1) 0 和 1 是仅有的两个不超过 1 的整数。0 XOR 3 = 3 而 1 XOR 3 = 2 。二者中的更大值是 3 。
 * 2) 1 XOR 2 = 3.
 * 3) 5 XOR 2 = 7.
 * <p>示例 2：
 * 输入：nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
 * 输出：[15,-1,5]
 * <p>提示：
 * 1 <= nums.length, queries.length <= 10^5
 * queries[i].length == 2
 * 0 <= nums[j], xi, mi <= 10^9
 *
 * @author hc
 */
public class Demo1707 {

    class Trie {
        private Trie[] child;

        Trie() {
            child = new Trie[2];
        }

        public void add(int num) {
            Trie root = this;
            for (int i = 30; i >= 0; i--) {
                int val = (num >> i) & 1;
                if (root.child[val] == null) {
                    root.child[val] = new Trie();
                }
                root = root.child[val];
            }
        }

        public int query(int num) {
            Trie root = this;
            int res = 0;
            for (int i = 30; i >= 0; i--) {
                int val = (num >> i) & 1;
                if (root.child[val ^ 1] != null) {
                    res += (1 << i);
                    root = root.child[val ^ 1];
                } else {
                    root = root.child[val];
                }
            }
            return res;
        }
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[][] q = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }
        Arrays.sort(nums);
        Arrays.sort(q, (o1, o2) -> o1[1] - o2[1]);
        int[] res = new int[queries.length];
        Trie root = new Trie();
        int index = 0;
        for (int i = 0; i < q.length; i++) {
            while (index < nums.length && nums[index] <= q[i][1]) {
                root.add(nums[index++]);
            }
            if (index == 0) {
                res[q[i][2]] = -1;
                continue;
            } else {
                res[q[i][2]] = root.query(q[i][0]);
            }
        }
        return res;
    }
}

