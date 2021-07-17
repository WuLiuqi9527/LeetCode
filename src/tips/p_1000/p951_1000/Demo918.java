package tips.p_1000.p951_1000;

/**
 * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。
 * （形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 C[i+A.length] = C[i]）
 * 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。
 * （形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, k2 <= j
 * 其中 k1 % A.length = k2 % A.length）
 * <p>示例 1：
 * 输入：[1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 * <p>示例 2：
 * 输入：[5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 * <p>示例 3：
 * 输入：[3,-1,2,-1]
 * 输出：4
 * 解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
 * <p>示例 4：
 * 输入：[3,-2,2,-3]
 * 输出：3
 * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 * <p>示例 5：
 * 输入：[-2,-3,-1]
 * 输出：-1
 * 解释：从子数组 [-1] 得到最大和 -1
 * <p>提示：
 * -30000 <= A[i] <= 30000
 * 1 <= A.length <= 30000
 *
 * @author hc
 */
public class Demo918 {

    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // 情况一：子数组未跨首尾两端 等同 p53
        int maxSum = nums[0];
        int sum = 0, S = 0;
        for (int num : nums) {
            sum = sum < 0 ? num : sum + num;
            maxSum = Math.max(maxSum, sum);

            S += num;
        }
        // 情况二：子数组跨首尾两端 最大子数组必定包含A[0]、A[A.length-1]两首尾元素，
        // 此时数组最大和 = 数组A所有元素之和 - 子数组[1~A.length-2]的最小子序和
        int minSum = Integer.MAX_VALUE;
        sum = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            sum = sum > 0 ? nums[i] : sum + nums[i];
            minSum = Math.min(minSum, sum);
        }

        return Math.max(maxSum, S - minSum);
    }

    public static void main(String[] args) {
        System.out.println(new Demo918().maxSubarraySumCircular(new int[]{5, -3, 5}));
        System.out.println(new Demo918().maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(new Demo918().maxSubarraySumCircular(new int[]{3, -1, 2, -1}));
        System.out.println(new Demo918().maxSubarraySumCircular(new int[]{3, -2, 2, -3}));
        System.out.println(new Demo918().maxSubarraySumCircular(new int[]{-2, -3, -1}));
    }
}
