package tip.lt1000.p301_350;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * @author hc
 */
public class Demo350 {

    public int[] intersect(int[] nums1, int[] nums2) {

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : nums1) {
            if (!treeMap.containsKey(num)) {
                treeMap.put(num, 1);
            } else {
                treeMap.put(num, treeMap.get(num) + 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (treeMap.containsKey(num)) {
                list.add(num);
                treeMap.put(num, treeMap.get(num) - 1);
                if (treeMap.get(num) == 0){
                    treeMap.remove(num);
                }
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
