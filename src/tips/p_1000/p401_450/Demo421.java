package tips.p_1000.p401_450;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 * <p>示例 1：
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 * <p>示例 2：
 * 输入：nums = [0]
 * 输出：0
 * <p>示例 3：
 * 输入：nums = [2,4]
 * 输出：6
 * <p>示例 4：
 * 输入：nums = [8,10,2]
 * 输出：10
 * <p>示例 5：
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 * <p>提示：
 * 1 <= nums.length <= 2 * 10^4
 * 0 <= nums[i] <= 2^31 - 1
 *
 * @author hc
 */
public class Demo421 {

    public int findMaximumXOR(int[] nums) {
        // 暴力法 O(n^2) -> 超时
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                res = Math.max(res, nums[i] ^ nums[j]);
            }
        }
        return res;
    }

    public int findMaximumXOR2(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int depth = 32 - Integer.numberOfLeadingZeros(max);

        Set<Integer> prefix = new HashSet<>();
        int res = 0;
        for (int i = depth - 1; i >= 0; --i) {
            res <<= 1;
            int curPrefix = res | 1;
            prefix.clear();
            for (int num : nums) {
                prefix.add(num >> i);
                if (prefix.contains(num >> i ^ curPrefix)) {
                    res |= 1;
                    break;
                }
            }
        }
        return res;
    }

    public int findMaximumXOR3(int[] nums) {
        Arrays.sort(nums);
        int res = 0, tem;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                // 如果用相加会越界
                if (nums[i] <= (res - nums[j])) {
                    break;
                }
                tem = nums[i] ^ nums[j];
                if (tem > res) {
                    res = tem;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo421().findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
        System.out.println(new Demo421().findMaximumXOR(new int[]{0}));
        System.out.println(new Demo421().findMaximumXOR(new int[]{2, 4}));
        System.out.println(new Demo421().findMaximumXOR(new int[]{8, 10, 2}));
        System.out.println(new Demo421().findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}));
    }
}
