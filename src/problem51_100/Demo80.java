package problem51_100;

/**
 * 给定一个 增序 排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 你不需要考虑数组中超出新长度后面的元素。
 *
 * @author hc
 */
public class Demo80 {

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length <= 2) {
            return nums.length;
        }

        int duplicateNum = 2;
        int len = 0;
        for (int num : nums) {
            if (len < 2 || num > nums[len - duplicateNum]) {
                nums[len++] = num;
            }
        }

        return len;
    }

    public static void main(String[] args) {
        System.out.println(new Demo80().removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }
}
