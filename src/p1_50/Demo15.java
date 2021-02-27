package p1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * 提示：
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * @author hc
 */
public class Demo15 {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (nums[i] > 0) {
                return lists;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int L = i + 1, R = len - 1;
            while (L < R) {
                int cur = nums[i] + nums[L] + nums[R];
                if (cur == 0) {
                    lists.add(Arrays.asList(nums[i], nums[L], nums[R]));

                    // 去重
                    while (L < R && nums[L + 1] == nums[L]) {
                        L++;
                    }
                    while (L < R && nums[R - 1] == nums[R]) {
                        R--;
                    }

                    L++;
                    R--;
                } else if (cur < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {

        System.out.println(new Demo15().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
