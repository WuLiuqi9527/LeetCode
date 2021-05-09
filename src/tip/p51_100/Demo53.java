package tip.p51_100;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的 连续子数组
 * （子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * @author hc
 */
public class Demo53 {

    public int maxSubArray(int[] nums) {

        int res = nums[0];
        int sumCur = 0;
        for (int num : nums) {
            // sumCur如果小于 0, 则对于当前 num 起副作用, 重新从 num 处开始计算连续和
            // res 记录曾出现的计和的最大值
            sumCur = sumCur < 0 ? num : sumCur + num;

            res = Math.max(res, sumCur);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo53().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
