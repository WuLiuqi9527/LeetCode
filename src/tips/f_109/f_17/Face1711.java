package tips.f_109.f_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
 * 如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 * <p>示例：
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 * <p>提示：
 * words.length <= 100000
 *
 * @author hc
 */
public class Face1711 {

    public int findClosest(String[] words, String word1, String word2) {

        Map<String, List<Integer>> map = new HashMap<>();
        map.put(word1, new ArrayList<>());
        map.put(word2, new ArrayList<>());

        int len = words.length;
        for (int i = 0; i < len; i++) {
            if (words[i].equals(word1)) {
                map.get(word1).add(i);
            }
            if (words[i].equals(word2)) {
                map.get(word2).add(i);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int one : map.get(word1)) {
            for (int two : map.get(word2)) {
                res = Math.min(res, Math.abs(one - two));
            }
        }
        return res;
    }

    public int findClosest2(String[] words, String word1, String word2) {

        int res = Integer.MAX_VALUE;
        int len = words.length;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < len; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            }
            if (words[i].equals(word2)) {
                index2 = i;
            }
            if (index1 >= 0 && index2 >= 0) {
                res = Math.min(res, Math.abs(index1 - index2));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Face1711().findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"}, "a", "student"));
    }
}
