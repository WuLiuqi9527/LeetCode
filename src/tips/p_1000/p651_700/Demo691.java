package tips.p_1000.p651_700;

import java.util.Arrays;

/**
 * 我们有 n 种不同的贴纸。每个贴纸上都有一个小写的英文单词。
 * 您想要拼写出给定的字符串 target ，方法是从收集的贴纸中切割单个字母并重新排列它们。
 * 如果你愿意，你可以多次使用每个贴纸，每个贴纸的数量是无限的。
 * 返回你需要拼出 target 的最小贴纸数量。如果任务不可能，则返回 -1 。
 * 注意：在所有的测试用例中，所有的单词都是从 1000 个最常见的美国英语单词中随机选择的，并且 target 被选择为两个随机单词的连接。
 * <p>示例 1：
 * 输入： stickers = ["with","example","science"], target = "thehat"
 * 输出：3
 * 解释：
 * 我们可以使用 2 个 "with" 贴纸，和 1 个 "example" 贴纸。
 * 把贴纸上的字母剪下来并重新排列后，就可以形成目标 “thehat“ 了。
 * 此外，这是形成目标字符串所需的最小贴纸数量。
 * <p>示例 2:
 * 输入：stickers = ["notice","possible"], target = "basicbasic"
 * 输出：-1
 * 解释：我们不能通过剪切给定贴纸的字母来形成目标“basicbasic”。
 * <p>提示:
 * n == stickers.length
 * 1 <= n <= 50
 * 1 <= stickers[i].length <= 10
 * 1 <= target <= 15
 * stickers[i] 和 target 由小写英文单词组成
 *
 * @author hc
 */
public class Demo691 {

    int N = 20, M = 1 << 20, INF = 50;
    int[] f = new int[M];
    int res;
    String[] ss;
    String t;

    public int minStickers(String[] stickers, String target) {
        ss = stickers;
        t = target;
        Arrays.fill(f, -1);
        res = dfs(0);
        return res == INF ? -1 : res;
    }

    int dfs(int state) {
        int n = t.length();
        if (state == ((1 << n) - 1)) {
            return 0;
        }
        if (f[state] != -1) {
            return f[state];
        }
        res = INF;
        for (String s : ss) {
            //当前状态
            int nstate = state;
            for (char c : s.toCharArray()) {
                for (int i = 0; i < n; i++) {
                    //字符相等，且状态位为0就置1,然后退出循环,因为字符c只能用一次
                    if (t.charAt(i) == c && ((nstate >> i) & 1) == 0) {
                        nstate |= (1 << i);
                        break;
                    }
                }
            }
            //比较完之后 当前状态情况再dfs继续填充状态
            if (nstate != state) {
                res = Math.min(res, dfs(nstate) + 1);
            }
        }
        return f[state] = res;
    }
}
