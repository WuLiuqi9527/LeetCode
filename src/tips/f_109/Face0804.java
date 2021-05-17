package tips.f_109;

import java.util.ArrayList;
import java.util.List;

/**
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * 说明：解集不能包含重复的子集。
 *
 * @author hc
 */
public class Face0804 {

    List<List<Integer>> lists;
    List<Integer> list;

    public List<List<Integer>> subsets(int[] nums) {
        lists = new ArrayList<>();
        list = new ArrayList<>();
        dfs(nums, 0);
        return lists;
    }

    private void dfs(int[] nums, int cur) {
        lists.add(new ArrayList<>(list));

        int len = nums.length;
        for (int i = cur; i < len; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size()-1);
        }
    }
}
