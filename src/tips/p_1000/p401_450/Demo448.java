package tips.p_1000.p401_450;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * <p>示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * <p>示例 2：
 * 输入：nums = [1,1]
 * 输出：[2]
 * <p>提示：
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗?
 * 你可以假定返回的数组不算在额外空间内。
 *
 * @author hc
 */
public class Demo448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 不使用额外空间
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }

        return res;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        boolean[] visited = new boolean[n + 1];
        for(int num : nums) {
            visited[num] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                res.add(i);
            }
        }
        return res;
    }

        public static void main(String[] args) {
        new Demo448().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }
}
