package tip.p51_100;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * @author hc
 */
public class Demo70 {

    public int climbStairs(int n) {

        /**
         * 递归
         */
        if (n == 1){return 1;}
        if (n == 2){return 2;}
//        return climbStairs(n-1)+climbStairs(n-2);

        /**
         * 类斐波那契额数列 记忆化搜索
         */
        int[] memo = new int[n];
        if (n>2){
            memo[n] = climbStairs(n-1)+ climbStairs(n-2);
        }

        /**
         * 自底向上 动态规划
         */
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i < n+1; i++) {
            memo[i] = memo[i-1]+memo[i-2];
        }


        return memo[n];
    }
}
