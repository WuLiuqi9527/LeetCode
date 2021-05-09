package tip.p1_50;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * @author hc
 */
public class Demo34 {

    public int[] searchRange(int[] nums, int target) {

        int[] res = new int[]{-1, -1};
        if (nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) {
            return res;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                int temL =  mid, temR = mid;
                while (temL >= 0 && nums[temL] == target) {
                    res[0] = temL--;
                }
                while (temR <= nums.length-1 && nums[temR] == target) {
                    res[1] = temR++;
                }
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Demo34().searchRange(new int[]{1}, 1);
    }
}
