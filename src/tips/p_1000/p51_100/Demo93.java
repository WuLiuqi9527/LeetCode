package tips.p_1000.p51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * <p>
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 *
 * @author hc
 */
public class Demo93 {

    public List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();
        StringBuilder ip = new StringBuilder();

        int len = s.length();
        for (int i = 1; i < 4; ++i) {
            for (int j = 1; j < 4; ++j) {
                for (int k = 1; k < 4; ++k) {
                    for (int l = 1; l < 4; l++) {
                        if (i + j + k + l == len) {
                            int n1 = Integer.parseInt(s.substring(0, i));
                            int n2 = Integer.parseInt(s.substring(i, i+j));
                            int n3 = Integer.parseInt(s.substring(i+j, i+j+k));
                            int n4 = Integer.parseInt(s.substring(i+j+k));
                            if (n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255) {
                                ip.append(n1).append('.').append(n2)
                                        .append('.').append(n3).append('.').append(n4);
                                if (ip.length() == s.length() + 3) {
                                    res.add(ip.toString());
                                }
                                ip.delete(0, ip.length());
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo93().restoreIpAddresses(new String("010010")));
    }
}
