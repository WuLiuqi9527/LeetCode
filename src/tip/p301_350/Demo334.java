package tip.p301_350;

/**
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，
 * 使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 * <p>示例 1：
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 * <p>进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？
 *
 * @author hc
 */
public class Demo334 {

    /**
     * 始终记录最小元素 min，同时使 b[第二大的数] 尽可能的小
     * 看是否找到比 b 大的数
     */

    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) {return false;}

        int min = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int num : nums){
            if (num <= min) {
                min = num;
            }else if (num <= second) {
                second = num;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Demo334().increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Demo334().increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(new Demo334().increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
    }
}
