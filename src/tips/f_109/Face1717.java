package tips.f_109;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个较长字符串 big 和一个包含较短字符串的数组 bsmalls，
 * 设计一个方法，根据 smalls 中的每一个较短字符串，对 big 进行搜索。
 * 输出 smalls 中的字符串在 big 里出现的所有位置 positions，
 * 其中 positions[i] 为 smalls[i] 出现的所有位置。
 * <p>示例：
 * 输入：
 * big = "mississippi"
 * smalls = ["is","ppi","hi","sis","i","ssippi"]
 * 输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
 * <p>提示：
 * 0 <= len(big) <= 1000
 * 0 <= len(smalls[i]) <= 1000
 * smalls的总字符数不会超过 100000。
 * 你可以认为smalls中没有重复字符串。
 * 所有出现的字符均为英文小写字母。
 *
 * @author hc
 */
public class Face1717 {

    public int[][] multiSearch(String big, String[] smalls) {

        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < smalls.length; i++) {
            List<Integer> list = new LinkedList<>();
            if (smalls[i].length() == 0) {
                lists.add(list);
                continue;
            }

            int index = big.indexOf(smalls[i]);

            if (index == -1 || smalls[i] == ""){
                lists.add(list);
            }else {
                while (index != -1) {
                    list.add(index);
                    index = big.indexOf(smalls[i], index + 1);
                }
                lists.add(list);
            }
        }

        // List<List<Integer>> 转 int[][]
        int size = lists.size();
        int[][] res = new int[size][];
        for (int i = 0; i < size; i++) {
            List<Integer> list = lists.get(i);
            if (list == null) {
                res[i] = new int[0];
                continue;
            }
            int len = list.size();
            res[i] = new int[len];
            for (int j = 0; j < len; j++) {
                res[i][j] = list.get(j);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        new Face1717().multiSearch("abc", new String[]{""});
//        new Face1717().multiSearch("mississippi", new String[]{"is", "ppi", "hi", "sis", "i", "ssippi"});
//        new Face1717().multiSearch("abc", new String[]{""});
    }
}
