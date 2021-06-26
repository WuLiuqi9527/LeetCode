package tips.f_109.f_17;

import java.util.*;

/**
 * 给定一个放有字符和数字的数组，找到最长的子数组，且包含的字符和数字的个数相同。
 * 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
 * <p>示例 1:
 * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 * <p>示例 2:
 * 输入: ["A","A"]
 * 输出: []
 * <p>提示：
 * array.length <= 100000
 *
 * @author hc
 */
public class Face1705 {

    /**
     * 类似 p_525 前缀和 + HashMap
     */
    public String[] findLongestSubarray(String[] array) {

        int l = 0, r = 0;
        int len = array.length;
        // count维护前缀和
        int count = 0;
        // Map<num[i], 第一次出现num[i]下标> -> map<0, i> map<-1, j>
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(array[i].charAt(0))) {
                ++count;
            } else {
                --count;
            }
            if (map.containsKey(count)) {
                int index = map.get(count);
                if (i - index > r - l) {
                    l = index;
                    r = i;
                }
            } else {
                map.put(count, i);
            }
        }
        return Arrays.copyOfRange(array, l + 1, r + 1);
    }
}
