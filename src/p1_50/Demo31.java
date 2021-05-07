package p1_50;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * @author hc
 */
public class Demo31 {

    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            --i;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                --j;
            }
            swap(nums, i, j);
        }
    }

    private void up(int[] nums, int index) {
        int start = index;
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            ++start;
            --end;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }

    public static void main(String[] args) {
        new Demo31().nextPermutation(new int[]{1, 2, 3});
    }
}
