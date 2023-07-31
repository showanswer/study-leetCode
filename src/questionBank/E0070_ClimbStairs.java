package questionBank;

/**
 * <p>
 * 爬楼梯
 * </p>
 *
 * @author answer
 * @date 2023/5/30 14:33
 */
public class E0070_ClimbStairs {

    public static void main(String[] args) {
        E0070_ClimbStairs test = new E0070_ClimbStairs();
        System.out.println(test.climbStairs(45));
    }

    /**
     * res = climbStairs(n-1) + climbStairs(n-2)
     * 但是这样 每次都要重新计算 每个数值都要重算。 可以把已经就算过的数据存到数组种，下次再取可以直接内存种取
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 2) {
            return 2;
        }
        if (n <= 1) {
            return 1;
        }
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    public int climbStairs1(int n) {
        int[] dp = new int[100];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        dp[5] = 8;
        dp[6] = 13;
        dp[7] = 21;
        dp[8] = 34;
        dp[9] = 55;
        dp[10] = 89;
        dp[11] = 144;
        dp[12] = 233;
        if (dp[n] > 0) {
            return dp[n];
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

}
