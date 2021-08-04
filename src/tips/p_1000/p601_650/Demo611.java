package tips.p_1000.p601_650;

import java.util.Arrays;

/**
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * <p>示例 1:
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 注意:
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 *
 * @author hc
 */
public class Demo611 {

    public int triangleNumber(int[] nums) {
        // 超时 1000 O(n^3)
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (check(nums[i], nums[j], nums[k])) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }

    public int triangleNumber2(int[] nums) {
        // 排序 倒序遍历 第二、三个for合一
        Arrays.sort(nums);
        int len = nums.length;
        int count = 0;
        for (int i = len - 1; i >= 2; i--) {
            int k = 0;
            int j = i - 1;
            while (k < j) {
                // a为最长边,只需满足 b+c > a 即可
                if (nums[k] + nums[j] > nums[i]) {
                    // k满足, k ~ j-1 都满足
                    count += j - k;
                    --j;
                } else {
                    ++k;
                }
            }
        }
        return count;
    }

    private boolean check(int a, int b, int c) {
        if (a < 0 || b < 0 || c < 0) {
            return false;
        }
        return a + b > c && a + c > b && b + c > a;
    }

    public static void main(String[] args) {
        System.out.println(new Demo611().triangleNumber(new int[]{2, 2, 3, 4}));
    }
}
