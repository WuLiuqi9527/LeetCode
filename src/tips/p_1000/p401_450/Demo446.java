package tips.p_1000.p401_450;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。
 * 如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。
 * 例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
 * 再例如，[1, 1, 2, 5, 7] 不是等差序列。
 * 数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。
 * 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
 * 题目数据保证答案是一个 32-bit 整数。
 * <p>示例 1：
 * 输入：nums = [2,4,6,8,10]
 * 输出：7
 * 解释：所有的等差子序列为：
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 * <p>示例 2：
 * 输入：nums = [7,7,7,7,7]
 * 输出：16
 * 解释：数组中的任意子序列都是等差子序列。
 * <p>提示：
 * 1 <= nums.length <= 1000
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 * @author hc
 */
public class Demo446 {

    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        int len = nums.length;

        // maps[i] 为考虑下标不超过 i 的所有数，并且以 nums[i] 为结尾的等差序列的个数
        Map<Long, Integer>[] maps = new Map[len];
        for (int i = 0; i < len; i++) {
            maps[i] = new HashMap<>();
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                long d = (long) nums[i] - nums[j];
                int cnt = maps[j].getOrDefault(d, 0);
                res += cnt;
                maps[i].put(d, maps[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return res;
    }

    public int numberOfArithmeticSlices2(int[] nums) {
        int res = 0;
        int len = nums.length;
        int[][] dp = new int[len][len];
        HashMap<Long, List<Integer>> checkup = new HashMap<>();
        for (int i = 0; i < len; i++) {
            long num = nums[i];
            if (!checkup.containsKey(num)) {
                checkup.put(num, new LinkedList<>());
            }
            checkup.get(num).add(i);
        }
        for (int i = 2; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                List<Integer> indexList = checkup.getOrDefault((2L * nums[j] - nums[i]), null);
                if (indexList != null) {
                    for (int index : indexList) {
                        if (index < j) {
                            dp[i][j] += dp[j][index] + 1;
                        }
                    }
                }
                res += dp[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo446().numberOfArithmeticSlices2(new int[]{2, 4, 6, 8, 10}));
    }
}
