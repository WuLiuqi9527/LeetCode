package tips.f_109.f_17;

import java.util.ArrayList;
import java.util.List;

/**
 * 在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。
 * 每个数字映射到0至4个字母。给定一个数字序列，实现一个算法来返回匹配单词的列表。
 * 你会得到一张含有有效单词的列表。映射如下图所示：
 * <p>示例 1:
 * 输入: num = "8733", words = ["tree", "used"]
 * 输出: ["tree", "used"]
 * <p>示例 2:
 * 输入: num = "2", words = ["a", "b", "c", "d"]
 * 输出: ["a", "b", "c"]
 * <p>提示：
 * num.length <= 1000
 * words.length <= 500
 * words[i].length == num.length
 * num中不会出现 0, 1 这两个数字
 *
 * @author hc
 */
public class Face1620 {

    private final int[] key = new int[]{2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};

    public List<String> getValidT9Words(String num, String[] words) {
        // String.charAt()底层也是转换成数组来取对应索引的
        // 所以 num 转换乘 int[] 可以加快速度
        int len = num.length();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = num.charAt(i) - '0';
        }

        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (isValid(word, nums)) {
                list.add(word);
            }
        }
        return list;
    }

    private boolean isValid(String word, int[] nums) {
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (nums[i] != key[word.charAt(i) - 'a']) {
                return false;
            }
        }
        return true;
    }
}
