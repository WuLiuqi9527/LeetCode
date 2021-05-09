package tip.p251_300;

import java.util.HashSet;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 * 进阶：
 * 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 *
 * 示例 1：
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 10^4
 * 0 <= nums[i] <= n
 * nums 中的所有数字都 独一无二
 *
 * 思路：1、sum越界 2、两次异或【一次 num[i], 一次 i】 3、哈希表
 * @author hc
 */
public class Demo268 {

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int res = nums.length;
        for (int i = 0; i < len; i++) {
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }

    public int missingNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int len = nums.length;
        for (int i = 0; i <= len; i++) {
            if (!set.contains(i)){
                return i;
            }
        }
        return -1;
    }

        public static void main(String[] args) {
        System.out.println(new Demo268().missingNumber2(new int[]{3,0,1}));
    }
}
