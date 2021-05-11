package tip.lt1000.p201_250;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * <p>
 * 示例 1：
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 * @author hc
 */
public class Demo228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!(i + 1 < len && nums[i] == nums[i + 1] - 1)) {
                if (str.length() > 0) {
                    str.append("->");
                }
                str.append(nums[i]);
                res.add(str.toString());
                str = new StringBuilder();
            } else {
                if (str.length() == 0) {
                    str.append(nums[i]);
                }
            }
        }

        return res;
    }

    public List<String> summaryRanges2(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int len = nums.length;

        for (int j = 0; j < len; j++) {
            if (j + 1 == len || nums[j] + 1 != nums[j + 1]) {
                StringBuilder str = new StringBuilder();
                str.append(nums[i]);
                if (i != j) {
                    str.append("->").append(nums[j]);
                }
                res.add(str.toString());
                i = j+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Demo228().summaryRanges2(new int[]{0, 1, 2, 4, 5, 7});
    }
}
