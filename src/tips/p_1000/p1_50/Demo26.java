package tips.p_1000.p1_50;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组
 * 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @author hc
 */
public class Demo26 {

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 1) {
            return nums.length;
        }

        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]){
                j++;
            }else {
                nums[++i] = nums[j++];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        System.out.println(new Demo26().removeDuplicates(new int[]{1, 1, 2}));
    }
}
