package tips.p_1000.p751_800;

/**
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如 "RXXLRXRXL"）中进行移动操作。
 * 一次移动操作指用一个 "LX" 替换一个"XL"，或者用一个 "XR" 替换一个 "RX"。
 * 现给定起始字符串 start 和结束字符串 end ，请编写代码，
 * 当且仅当存在一系列移动操作使得 start 可以转换成 end 时， 返回 True。
 * <p>示例 :
 * 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * 输出: True
 * 解释:
 * 我们可以通过以下几步将start转换成end:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * <p>提示：
 * 1 <= len(start) = len(end) <= 10000。
 * start和end中的字符串仅限于'L', 'R'和'X'。
 */
public class Demo777 {

    /**
     * 可以看成是 字符串的 R, L 的移动, R 向右移, L 向左移
     */
    public boolean canTransform(String start, String end) {
        if (start.equals(end)) {
            return true;
        }
        if (start.length() != end.length()) {
            return false;
        }
        int n = start.length(), i = 0, j = 0;
        while (i < n || j < n) {
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && end.charAt(j) == 'X') j++;

            if (i == n || j == n) return i == j;
            if (start.charAt(i) != end.charAt(j)) return false;
            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;
            i++;
            j++;
        }
        return true;
    }
}
