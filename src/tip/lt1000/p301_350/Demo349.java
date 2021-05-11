package tip.lt1000.p301_350;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 * 说明：
 * 输出结果中的每个元素一定是唯一的。    -> *集合 TreeSet
 * 我们可以不考虑输出结果的顺序。
 * @author hc
 */
public class Demo349 {

    public int[] intersection(int[] nums1, int[] nums2) {

        TreeSet treeSet = new TreeSet();
        for (int num:nums1){
            treeSet.add(num);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int num:nums2){
            if (treeSet.contains(num)){
                list.add(num);
                treeSet.remove(num);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
