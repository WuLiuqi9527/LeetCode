package tip.p1_50;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * @author hc
 */
public class Demo5 {

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        // 保存起始位置
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {

            // 把回文看成中间的部分全是同一字符，左右部分相对称
            // 找到下一个与当前字符不同的字符
            // 对由相同字符构成的子串进行了特殊处理
            i = findLongest(str, i, range);
        }

        // substring() 左闭右开区间
        return s.substring(range[0], range[1] + 1);
    }

    public int findLongest(char[] str, int low, int[] range) {

        // 查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }

        // 定位中间部分的最后一个字符
        int ans = high;

        // 从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }

        // 记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Demo5().longestPalindrome("babad"));
    }
}
