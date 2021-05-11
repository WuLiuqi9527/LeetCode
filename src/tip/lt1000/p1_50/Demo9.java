package tip.lt1000.p1_50;

/**
 * @author hc
 * <p>
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 如 121、12321，就是回文数
 * 如 -121、10， 就不是回文数
 */

public class Demo9 {

    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        // x == reversed x由偶数位数字组成
        // x == reversed / 10 x由奇数位数字组成
        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {
        System.out.println(new Demo9().isPalindrome(1221));
        System.out.println(new Demo9().isPalindrome(121));
        System.out.println(new Demo9().isPalindrome(10));
        System.out.println(new Demo9().isPalindrome(-123));
    }
}
