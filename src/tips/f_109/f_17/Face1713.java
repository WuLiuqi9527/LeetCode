package tips.f_109.f_17;

/**
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。
 * 像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。
 * 在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。
 * 假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 * <p>示例：
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * <p>提示：
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 *
 * @author hc
 */
public class Face1713 {

    public int respace(String[] dictionary, String sentence) {

        if (sentence == null || sentence.length() == 0) {
            return 0;
        }
        if (dictionary == null || dictionary.length == 0) {
            return sentence.length();
        }

        int len = sentence.length();
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + 1;
            for (String word : dictionary) {
                int wLen = word.length();
                if (i >= wLen && sentence.substring(i - wLen, i).equals(word)) {
                    dp[i] = Math.min(dp[i], dp[i - wLen]);
                }
            }
        }

        return dp[len];
    }
}