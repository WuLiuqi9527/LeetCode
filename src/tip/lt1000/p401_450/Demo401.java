package tip.lt1000.p401_450;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * <p>
 * 例如，上面的二进制手表读取 “3:25”。
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * <p>
 * 示例：
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * <p>
 * 提示：
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
 *
 * @author hc
 */
public class Demo401 {

    List<String> res;

    public List<String> readBinaryWatch(int num) {

        res = new ArrayList<>();
        int[] times = new int[]{8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
        backTrack(num, times, 0, 0, 0);

        return res;
    }

    private void backTrack(int num, int[] times, int index, int hour, int minute) {

        if (num == 0) {
            if (hour > 11 || minute > 59) {
                return;
            }
            StringBuilder str = new StringBuilder();
            str.append(hour);
            str.append(":");
            if (minute < 10) {
                str.append("0");
            }
            str.append(minute);
            res.add(new String(str));
            return;
        }

        for (int i = index; i < times.length; i++) {
            if (i < 4) {
                hour += times[i];
            } else {
                minute += times[i];
            }

            backTrack(num - 1, times, i + 1, hour, minute);

            if (i < 4) {
                hour -= times[i];
            } else {
                minute -= times[i];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Demo401().readBinaryWatch(1));
    }
}
