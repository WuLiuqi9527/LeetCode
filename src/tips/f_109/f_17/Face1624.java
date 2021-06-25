package tips.f_109.f_17;

import java.util.*;

/**
 * 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 * <p>示例 1:
 * 输入: nums = [5,6,5], target = 11
 * 输出: [[5,6]]
 * <p>示例 2:
 * 输入: nums = [5,6,5,6], target = 11
 * 输出: [[5,6],[5,6]]
 * <p>提示：
 * nums.length <= 100000
 *
 * @author hc
 */
public class Face1624 {

    public List<List<Integer>> pairSums(int[] nums, int target) {
        // 40 / 42 超时
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        boolean[] visited = new boolean[len];

        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }
            int complement = target - nums[i];
            for (int j = 0; j < len; j++) {
                if (visited[j] || j == i) {
                    continue;
                }
                if (nums[j] == complement) {
                    visited[i] = true;
                    visited[j] = true;
                    lists.add(Arrays.asList(target - complement, complement));
                    break;
                }
            }
        }
        return lists;
    }

    public List<List<Integer>> pairSums2(int[] nums, int target) {
        // 参考两数之和 使用 HashMap 优化
        List<List<Integer>> lists = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) > 0) {
                lists.add(Arrays.asList(nums[i], complement));
                map.put(complement, map.get(complement) - 1);
                continue;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return lists;
    }

    public List<List<Integer>> pairSums3(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //头尾指针
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (target == sum) {//刚好相等。两个指针都往中间移动
                list.add(Arrays.asList(nums[l], nums[r]));
                ++l;
                --r;
            } else if (target > sum) {//两数之和太小，左指针右移，让和变大
                ++l;
            } else {//两数之和太大，右指针左移，让和变小
                --r;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        new Face1624().pairSums(new int[]{5, 6, 5}, 11);
        new Face1624().pairSums(new int[]{5, 6, 5, 6}, 11);
    }
}
