package tip.lt1000.p551_600;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中 和为 k 的 连续 的子数组的个数。
 * <p>示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * <p>说明 :
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * @author hc
 */
public class Demo560 {

    public int subarraySum(int[] nums, int k) {
        // 数组无序，不是滑窗
        int[] sum = sum(nums);
        int res = 0;
        int len = sum.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (sum[j] - sum[i] == k) {
                    ++res;
                }
            }
        }
        return res;
    }

    private int[] sum(int[] nums) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        if (len > 0) {
            for (int i = 0; i < len; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }
        return sum;
    }

    public int subarraySum2(int[] nums, int k) {
        // 前缀和 + hashmap<前缀和, 出现次数> 类似 两数之和
        HashMap<Integer, Integer> map = new HashMap<>();
        // 表示 和为0的从index=0开始连续子序列有 1 个（就是没有任何元素的空序列情况）
        map.put(0, 1);
        int preNum = 0;
        int res = 0;
        for (int num : nums) {
            preNum += num;
            if (map.containsKey(preNum - k)) {
                res += map.get(preNum - k);
            }
            map.put(preNum, map.getOrDefault(preNum, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo560().subarraySum2(new int[]{1, 1, 1}, 2));
        System.out.println(new Demo560().subarraySum2(new int[]{1, 1, 0}, 2));
    }

}
