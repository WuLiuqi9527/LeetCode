package tips.p_1000.p1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 * @author hc
 */
public class Demo18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> lists = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return lists;
        }

        Arrays.sort(nums);

        int len = nums.length;

        for (int i = 0; i < len - 3; i++) {

            /**
             * 剪枝
             */
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < len - 2; j++) {

                /**
                 * 剪枝
                 */
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) {
                    continue;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int L = j + 1, R = len - 1;
                while (L < R) {
                    int cur = nums[i] + nums[j] + nums[L] + nums[R];
                    if (cur == target) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        while (L < R && nums[L + 1] == nums[L]) {
                            L++;
                        }
                        while (L < R && nums[R - 1] == nums[R]) {
                            R--;
                        }
                        L++;
                        R--;
                    } else if (cur < target) {
                        L++;
                    } else {
                        R--;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new Demo18().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
