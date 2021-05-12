package tips.p_1000.p151_200;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 注意数组中可能存在重复的元素。
 * <p>
 * 示例 1：
 * 输入: [1,3,5]
 * 输出: 1
 * <p>
 * 示例 2：
 * 输入: [2,2,2,0,1]
 * 输出: 0
 *
 * @author hc
 */
public class Demo154 {

    public int findMin(int[] nums) {

        // 二分查找
        int mid = 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                --right;
            }
        }
        return nums[mid];
    }

    public static void main(String[] args) {
//        System.out.println(new Demo154().findMin(new int[]{2, 2, 2, 0, 1}));
        System.out.println(new Demo154().findMin(new int[]{1, 1, 0, 1, 1, 1, 1}));
    }
}
