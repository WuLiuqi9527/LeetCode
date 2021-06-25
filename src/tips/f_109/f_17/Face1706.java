package tips.f_109.f_17;

/**
 * 编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
 * <p>示例:
 * 输入: 25
 * 输出: 9
 * 解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
 * <p>提示：
 * n <= 10^9
 *
 * @author hc
 */
public class Face1706 {

    /** 超时 */
    public int numberOf2sInRange9(int n) {

        int count = 0;
        for (int i = 0; i <= n; i++) {
            char[] ch = String.valueOf(i).toCharArray();
            for(char c : ch){
                if (c == '2'){
                    ++count;
                }
            }
        }
        return count;
    }

    public int numberOf2sInRange(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0){
            if (cur < 2) {
                res += high * digit;
            }else if (cur == 2){
                res += high * digit + low +1;
            }else {
                res += (high+1)*digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

        public static void main(String[] args) {
        System.out.println(new Face1706().numberOf2sInRange(25));
    }
}
