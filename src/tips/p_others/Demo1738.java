package tips.p_others;

import java.util.PriorityQueue;

/**
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]
 * （下标从 0 开始计数）执行异或运算得到。
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 * <p>示例 1：
 * 输入：matrix = [[5,2],[1,6]], k = 1
 * 输出：7
 * 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
 * <p>示例 2：
 * 输入：matrix = [[5,2],[1,6]], k = 2
 * 输出：5
 * 解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。
 * <p>示例 3：
 * 输入：matrix = [[5,2],[1,6]], k = 3
 * 输出：4
 * 解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。
 * <p>示例 4：
 * 输入：matrix = [[5,2],[1,6]], k = 4
 * 输出：0
 * 解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。
 * <p>提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 0 <= matrix[i][j] <= 10^6
 * 1 <= k <= m * n
 *
 * @author hc
 */
public class Demo1738 {

    public int kthLargestValue(int[][] matrix, int k) {

        int row = matrix.length;
        int col = matrix[0].length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = dp[i][j - 1] ^ dp[i - 1][j] ^ dp[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                queue.add(dp[i][j]);
            }
        }

        k = k - 1;
        while (k > 0) {
            queue.poll();
            --k;
        }
        return queue.poll();
    }

    public int kthLargestValue2(int[][] matrix, int k) {

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = dp[i][j - 1] ^ dp[i - 1][j] ^ dp[i - 1][j - 1] ^ matrix[i - 1][j - 1];
            }
        }

        int idx = 0;
        int[] nums = new int[row * col];
        for (int i = 1; i <= row; ++i) {
            for (int j = 1; j <= col; ++j) {
                nums[idx++] = dp[i][j];
            }
        }

        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int left = start;
        int right = end;
        int pivot = nums[start + (end - start) / 2];
        while (left <= right) {
            if (nums[left] < pivot) {
                left++;
            } else if (nums[right] > pivot) {
                right--;
            } else {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = temp;
            }
        }
        if (start + k - 1 <= right) {
            return quickSelect(nums, start, right, k);
        }
        if (start + k - 1 >= left) {
            return quickSelect(nums, left, end, start + k - left);
        }
        return nums[right + 1];
    }

    public static void main(String[] args) {
        System.out.println(new Demo1738().kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 3));
    }
}
