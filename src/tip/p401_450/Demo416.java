package tip.p401_450;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * <p>
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 * @author hc
 */
public class Demo416 {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int len = nums.length;
        // c 背包重量
        int c = sum / 2;
        boolean[] memo = new boolean[c + 1];

        for (int i = 0; i <= c; i++) {
            memo[i] = (nums[0] == i);
        }

        // 压缩到一维，采用逆序
        for (int i = 1; i < len; i++) {
            for (int j = c; j >= nums[i]; j--) {
                memo[j] = memo[j] || memo[j - nums[i]];
            }
        }

        return memo[c];
    }

    public static void main(String[] args) {
        System.out.println(new Demo416().canPartition(new int[]{1, 5, 11, 5}));
    }
}
