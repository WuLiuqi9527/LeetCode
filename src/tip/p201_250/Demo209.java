package tip.p201_250;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组
 * <p>
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * @author hc
 */
public class Demo209 {

    public int minSubArrayLen(int target, int[] nums) {

        /**
         * 双索引指针 滑动窗口
         */
        int l = 0, r = -1;
        int sum = 0;
        int res = nums.length + 1;

        while (l < nums.length) {
            if (sum < target && r+1 < nums.length) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }
            if (sum >= target){
                res = Math.min(res, r-l+1);
            }
        }

        if (res == nums.length+1){
            return 0;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
