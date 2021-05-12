package tips.p_1000.p151_200;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给你一个输入数组 nums，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * <p>
 * 注：对于所有有效的 i 都有 nums[i] != nums[i + 1]
 *
 * @author hc
 */
public class Demo162 {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        int mid;
        while (left < right){
            mid = left + ((right - left) >> 1);
            // 局部极值
            if (nums[mid] > nums[mid + 1]){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Demo162().findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(new Demo162().findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
