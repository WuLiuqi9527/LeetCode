package tips.f_109;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。
 * 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。
 * <p>示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出:
 * ["hit","hot","dot","lot","log","cog"]
 * <p>示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出: []
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 *
 * @author hc
 */
public class Face1722 {

    List<String> wordList;
    List<String> ans = new ArrayList<>();
    Set<String> vis = new HashSet<>();
    String endWord;

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.wordList = wordList;
        this.endWord = endWord;

        dfs(beginWord);

        return ans;

    }

    public boolean dfs(String s) {
        ans.add(s);
        vis.add(s);

        if (s.equals(endWord)) {
            return true;
        }

        for (String wd : wordList) {
            if (difCount(s, wd) && !vis.contains(wd)) {
                if (dfs(wd)) {
                    return true; // 找到一条路径立即返回
                }
            }
        }
        ans.remove(s);
        return false;

    }

    public boolean difCount(String s1, String s2) {
        int n = s1.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
                if (cnt > 1) { // 优化！！！
                    return false;
                }
            }
        }
        return cnt == 1;
    }
}
