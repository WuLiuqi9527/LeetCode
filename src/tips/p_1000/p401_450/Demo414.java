package tips.p_1000.p401_450;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * <p>示例 1：
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * <p>示例 2：
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * <p>示例 3：
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 * <p>提示：
 * 1 <= nums.length <= 10^4
 * -231 <= nums[i] <= 2^31 - 1
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 *
 * @author hc
 */
public class Demo414 {

    /**
     * 使用 java优先队列，维护一个大小为 3 的优先队列；队列中元素个数不为 3 时将数组元素加入，
     * 大于 3 时若队首元素小于数组元素，则弹出队首元素并将数组元素入队直到循环完数组。此时队首元素为第三大数字
     * PriorityQueue<Integer> queue = new PriorityQueue<>(); //建立小根堆
     * Set<Integer> set = new HashSet<>(); //去除重复元素
     */
    public int thirdMax(int[] nums) {
        // TreeSet 自动升序排列 且去重
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.pollFirst();
            }
        }
        if (set.size() < 3) {
            return set.pollLast();
        } else {
            return set.pollFirst();
        }
    }
}
