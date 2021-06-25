package tips.f_109.f_17;

/**
 * 数组中占比超过一半的元素称之为主要元素。
 * 给定一个整数数组，找到它的主要元素。若没有，返回-1。
 * <p>示例 1：
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * <p>示例 2：
 * 输入：[3,2]
 * 输出：-1
 * <p>示例 3：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>说明：
 * 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
 *
 * @author hc
 */
public class Face1710 {

    public int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
                ++count;
            } else {
                count = num == res ? count + 1 : count - 1;
            }
        }

        // 验证是否存在众数
        if (count > 0) {
            int c = 0;
            for (int num : nums) {
                if (num == res) {
                    ++c;
                }
            }
            if (c > (nums.length >> 1)) {
                return res;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Face1710().majorityElement(new int[]{3, 2, 3}));
    }
}
