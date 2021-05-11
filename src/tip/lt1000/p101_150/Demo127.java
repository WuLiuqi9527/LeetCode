package tip.lt1000.p101_150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
 * <p>
 * 序列中第一个单词是 beginWord 。
 * 序列中最后一个单词是 endWord 。
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典 wordList 中的单词。
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。
 * 如果不存在这样的转换序列，返回 0。
 * <p>
 * 示例 1：
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 *
 * @author hc
 */
public class Demo127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        boolean[] marked = new boolean[wordList.size() + 1];

        //注意返回的是层数+1.所以这里直接放1了
        int layer = 1;
        while (!queue.isEmpty()) {
            //固定的层数记录形式
            layer++;
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if (marked[i]) {
                        continue;
                    }
                    String dic = wordList.get(i);
                    if (canChange(dic, cur)) {
                        if (dic.equals(endWord)) {
                            return layer;
                        }
                        queue.add(dic);
                        marked[i] = true;
                    }
                }
            }
        }
        return 0;
    }

    public boolean canChange(String s, String t) {
        int len = s.length();
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                diff++;
            }
        }
        // s, t 只有一位发生变化
        return diff == 1;
    }

    public static void main(String[] args) {

        System.out.println(new Demo127().ladderLength("hit", "cog", new ArrayList() {{
            add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
            add("cog");
        }}));
    }
}
