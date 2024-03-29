package tips.p_1000.p151_200;

/**
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。
 * 每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。
 * 例如，2.5.33 和 0.1 都是有效的版本号。
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。
 * 也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。
 * 例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 * <p>返回规则如下：
 * 如果 version1 > version2 返回 1，
 * 如果 version1 < version2 返回 -1，
 * 除此之外返回 0。
 * <p>示例 1：
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
 * <p>示例 2：
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有指定下标为 2 的修订号，即视为 "0"
 * <p>示例 3：
 * 输入：version1 = "0.1", version2 = "1.1"
 * 输出：-1
 * 解释：version1 中下标为 0 的修订号是 "0"，version2 中下标为 0 的修订号是 "1" 。0 < 1，所以 version1 < version2
 * <p>示例 4：
 * 输入：version1 = "1.0.1", version2 = "1"
 * 输出：1
 * <p>示例 5：
 * 输入：version1 = "7.5.2.4", version2 = "7.5.3"
 * 输出：-1
 * <p>提示：
 * 1 <= version1.length, version2.length <= 500
 * version1 和 version2 仅包含数字和 '.'
 * version1 和 version2 都是 有效版本号
 * version1 和 version2 的所有修订号都可以存储在 32 位整数 中。
 *
 * @author hc
 */
public class Demo165 {

    public int compareVersion(String version1, String version2) {
        // ".$|()[{^?*+\\" 特殊字符前需要加转义字符
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len1 = v1.length, len2 = v2.length;
        int i = 0, j = 0;
        while (i < len1 || j < len2) {
            int a = 0, b = 0;
            if (i < len1) {
                a = Integer.parseInt(v1[i++]);
            }
            if (j < len2) {
                b = Integer.parseInt(v2[j++]);
            }
            if (a != b) {
                return a > b ? 1 : -1;
            }
        }
        return 0;
    }

    public int compareVersion2(String version1, String version2) {
        int lenV1 = version1.length();
        int lenV2 = version2.length();

        int v1 = 0, v2 = 0;
        while (v1 < lenV1 || v2 < lenV2) {
            int sum1 = 0;
            while (v1 < lenV1 && version1.charAt(v1) != '.') {
                sum1 = sum1 * 10 + (version1.charAt(v1) - '0');
                ++v1;
            }
            int sum2 = 0;
            while (v2 < lenV2 && version2.charAt(v2) != '.') {
                sum2 = sum2 * 10 + (version2.charAt(v2) - '0');
                ++v2;
            }

            if (sum1 != sum2) {
                return sum1 > sum2 ? 1 : -1;
            } else {
                ++v1;
                ++v2;
            }
        }
        return 0;
    }

    public int compareVersion3(String version1, String version2) {
        if (version1.equals(version2)) {
            return 0;
        }
        String[] version1Array = version1.split("[._]");
        String[] version2Array = version2.split("[._]");
        int index = 0;
        int minLen = Math.min(version1Array.length, version2Array.length);
        long diff = 0;

        while (index < minLen
                && (diff = Long.parseLong(version1Array[index])
                - Long.parseLong(version2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            for (int i = index; i < version1Array.length; i++) {
                if (Long.parseLong(version1Array[i]) > 0) {
                    return 1;
                }
            }

            for (int i = index; i < version2Array.length; i++) {
                if (Long.parseLong(version2Array[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Demo165().compareVersion3("0.1.0", "1.0"));
        System.out.println(new Demo165().compareVersion3("2.1.13", "1.20.0"));
        System.out.println(new Demo165().compareVersion3("2.1.0", "2.1.0"));
//        System.out.println(new Demo165().compareVersion2("7.5.2.4", "7.5.3"));
//        System.out.println(new Demo165().compareVersion2("1.01", "1.001"));
//        System.out.println(new Demo165().compareVersion2("1.0", "1.0.0"));
    }
}
