package tips.p_1000.p601_650;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * <p>示例：
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * <p>提示：
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 *
 * @author hc
 */
public class Demo643 {

    public double findMaxAverage(int[] nums, int k) {
        double res = 0, tem = 0;
        for (int i = 0; i < k; i++) {
            res += (double) nums[i] / k;
        }
        tem = res;

        int l = 1, r = k;
        int len = nums.length;
        while (r < len) {
            tem += (double) (nums[r] - nums[l - 1]) / k;
            res = Math.max(res, tem);
            ++l;
            ++r;
        }
        return res;
    }

    public double findMaxAverage2(int[] nums, int k) {
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < len; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }


    public static void main(String[] args) {
        System.out.println(new Demo643().findMaxAverage(new int[]{0, 4, 0, 3, 2}, 1));
        System.out.println(new Demo643().findMaxAverage(new int[]{0, 1, 1, 3, 3}, 4));
        System.out.println(new Demo643().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }
}
