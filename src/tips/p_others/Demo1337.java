package tips.p_others;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * <p>示例 1：
 * 输入：mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 2
 * 行 4 -> 5
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 * <p>示例 2：
 * 输入：mat =
 * [[1,0,0,0],
 * [1,1,1,1],
 * [1,0,0,0],
 * [1,0,0,0]],
 * k = 2
 * 输出：[0,2]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 1
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 1
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 * <p>提示：
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] 不是 0 就是 1
 *
 * @author hc
 */
public class Demo1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] power = new int[m][2];
        for (int i = 0; i < m; i++) {
            int num = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    ++num;
                }
            }
            power[i][0] = num;
            power[i][1] = i;
        }
        Arrays.sort(power, (o1, o2) -> o1[0] - o2[0]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = power[i][1];
        }
        return res;
    }

    public int[] kWeakestRows2(int[][] mat, int k) {
        // 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前 -> 有序 -> 二分
        // 战斗力最弱的 k行 -> 升序 -> 大顶堆 poll()删除队首元素
        int m = mat.length, n = mat[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);

        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + ((r - l) >> 1);
                if (mat[i][mid] == 0) {
                    r = mid;
                } else if (mat[i][mid] == 1) {
                    l = mid + 1;
                }
            }
            int cur = mat[i][l] >= 1 ? l + 1 : l;
            if (q.size() == k && q.peek()[0] > cur) {
                q.poll();
            }
            if (q.size() < k) {
                q.add(new int[]{cur, i});
            }
        }
        int[] res = new int[k];
        int index = k - 1;
        while (!q.isEmpty()) {
            res[index--] = q.poll()[1];
        }
        return res;
    }

    public static void main(String[] args) {
        new Demo1337().kWeakestRows2(new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 1}}, 3);
    }
}
