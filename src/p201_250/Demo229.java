package p201_250;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 * <p>
 * 示例 3：
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 *
 * @author hc
 */
public class Demo229 {

    /**
     * 摩尔投票法：在任何数组中，出现次数大于该数组长度一半的值只能有一个；
     * 在任何数组中，出现次数大于该数组长度 1/3 的值只能有两个；
     * -> 记录出现频率排序的前两者 -> 看这两者是否达到了 1/3
     */
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> res = new ArrayList<>();
        int len = nums.length;

        int first = 0, second = 0;
        int fc = 0, sc = 0;
        for (int num : nums) {
            if (num == first) {
                ++fc;
            } else if (num == second) {
                ++sc;
            } else if (fc == 0) {
                first = num;
                ++fc;
            } else if (sc == 0) {
                second = num;
                ++sc;
            } else {
                --fc;
                --sc;
            }
        }

        fc = sc = 0;
        for (int num : nums) {
            if (num == first) {
                ++fc;
            } else if (num == second) {
                ++sc;
            }
        }

        if (fc > len / 3) {
            res.add(first);
        }
        if (sc > len / 3) {
            res.add(second);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo229().majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
        System.out.println(new Demo229().majorityElement(new int[]{0, 0, 0}));
    }
}
