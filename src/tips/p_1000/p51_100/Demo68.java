package tips.p_1000.p51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词数组和一个长度maxWidth，重新排版单词，使其成为每行恰好有maxWidth个字符，且左右两端对齐的文本。
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格' '填充，使得每行恰好有 maxWidth个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>说明:
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于maxWidth。
 * 输入单词数组 words至少包含一个单词。
 * <p>示例:
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 * "This  is  an",
 * "example of text",
 * "justification. "
 * ]
 * <p>示例2:
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 * "What  must  be",
 * "acknowledgment ",
 * "shall be    "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 * 因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * <p>示例3:
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 * "Science is what we",
 * "understand   well",
 * "enough to explain to",
 * "a computer. Art is",
 * "everything else we",
 * "do         "
 * ]
 *
 * @author hc
 */
public class Demo68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; ) {
            list.clear();
            list.add(words[i]);
            int cur = words[i].length();
            int j = i + 1;
            while (j < n && cur + 1 + words[j].length() <= maxWidth) {
                cur += 1 + words[j].length();
                list.add(words[j++]);
            }
            i = j;

            // 开始处理添加空格
            // 当前行为最后一行,特殊处理为左对齐
            if (i == n) {
                StringBuilder sb = new StringBuilder(list.get(0));
                for (int k = 1; k < list.size(); k++) {
                    sb.append(" ").append(list.get(k));
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
                ans.add(sb.toString());
                break;
            }

            // 当前行只有一个word,特殊处理为左对齐
            int cnt = list.size();
            if (cnt == 1) {
                StringBuilder str = new StringBuilder(list.get(0));
                while (str.length() != maxWidth) {
                    str.append(" ");
                }
                ans.add(str.toString());
                continue;
            }

            // 一般情况
            int wordLen = cur - (cnt - 1);
            int spaceLen = maxWidth - wordLen;
            int spaceItemLen = spaceLen / (cnt - 1);
            StringBuilder spaceItem = new StringBuilder();
            for (int k = 0; k < spaceItemLen; k++) {
                spaceItem.append(" ");
            }
            StringBuilder sb = new StringBuilder();
            for (int k = 0, sum = 0; k < cnt; k++) {
                String item = list.get(k);
                sb.append(item);
                if (k == cnt - 1) {
                    break;
                }
                sb.append(spaceItem);
                sum+= spaceItemLen;
                int remain = cnt - k - 1 - 1;
                if (remain * spaceItemLen + sum < spaceLen) {
                    sb.append(" ");
                    ++sum;
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
