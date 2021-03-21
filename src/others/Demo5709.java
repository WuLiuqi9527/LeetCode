package others;

/**
 * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 * 子数组是数组中的一个连续数字序列。
 * <p>
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，
 * 则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
 *
 * @author hc
 */
public class Demo5709 {

    public int maxAscendingSum(int[] nums) {

        int res = nums[0], sum = nums[0];
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            if (nums[i - 1] < nums[i]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            res = Math.max(Math.max(res,nums[i]), sum);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo5709().maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
        System.out.println(new Demo5709().maxAscendingSum(new int[]{10, 20, 30, 40, 50}));
        System.out.println(new Demo5709().maxAscendingSum(new int[]{12, 17, 15, 13, 10, 11, 12}));
        System.out.println(new Demo5709().maxAscendingSum(new int[]{100, 10, 1}));
        System.out.println(new Demo5709().maxAscendingSum(new int[]{6,10,6}));
    }
}
