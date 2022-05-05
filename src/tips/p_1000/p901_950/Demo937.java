package tips.p_1000.p901_950;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个日志数组 logs。每条日志都是以空格分隔的字串，其第一个字为字母与数字混合的 标识符 。
 * 有两种不同类型的日志：
 * 字母日志：除标识符之外，所有字均由小写字母组成
 * 数字日志：除标识符之外，所有字均由数字组成
 * 请按下述规则将日志重新排序：
 * 所有 字母日志 都排在 数字日志 之前。
 * 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
 * 数字日志 应该保留原来的相对顺序。
 * 返回日志的最终顺序。
 * <p>示例 1：
 * 输入：logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * 输出：["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * 解释：
 * 字母日志的内容都不同，所以顺序为 "art can", "art zero", "own kit dig" 。
 * 数字日志保留原来的相对顺序 "dig1 8 1 5 1", "dig2 3 6" 。
 * <p>示例 2：
 * 输入：logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * 输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 * <p>提示：
 * 1 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] 中，字与字之间都用 单个 空格分隔
 * 题目数据保证 logs[i] 都有一个标识符，并且在标识符之后至少存在一个字
 *
 * @author hc
 */
public class Demo937 {

    public static String[] reorderLogFiles(String[] logs) {
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();

        for (String log : logs) {
            char c = log.charAt(log.length() - 1);
            boolean isDig = Character.isDigit(c);
            if (!isDig) {
                l1.add(log);
            } else {
                l2.add(log);
            }
        }
        l1.sort((o1, o2) -> {
            String s1 = o1.substring(o1.indexOf(' '));
            String s2 = o2.substring(o2.indexOf(' '));
            if (s1.equals(s2)) {
                // 如果内容相同时，直接比较原log字符串
                return o1.compareTo(o2);
            } else {
                // 否则，按内容字母顺序排序
                return s1.compareTo(s2);
            }
        });
        l1.addAll(l2);
        return l1.toArray(new String[0]);
    }

    public static void main(String[] args) {
        reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"});
    }
}
