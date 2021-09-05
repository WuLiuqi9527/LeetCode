package tips.p_1000.p451_500;

/**
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，
 * 试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 * 不要使用系统的 Math.random() 方法。
 * <p>示例 1:
 * 输入: 1
 * 输出: [7]
 * <p>示例 2:
 * 输入: 2
 * 输出: [8,4]
 * <p>示例 3:
 * 输入: 3
 * 输出: [8,1,10]
 * <p>提示:
 * rand7 已定义。
 * 传入参数: n 表示 rand10 的调用次数。
 * <p>进阶:
 * rand7()调用次数的 期望值 是多少 ?
 * 你能否尽量少调用 rand7() ?
 *
 * @author hc
 */
public class Demo470 {

    public int rand7(){return (int) (Math.random() * 7);}

    public int rand10() {
        int res;
        while(true) {
            res = (rand7() - 1) * 7 + rand7();
            if(res <= 40) {break;}
        }
        return res % 10 + 1;
    }
}
