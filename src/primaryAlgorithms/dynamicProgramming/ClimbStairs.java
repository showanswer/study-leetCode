package primaryAlgorithms.dynamicProgramming;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * @author answer
 * @Description: <p>爬楼梯</p>
 * @date 2023/1/2 22:22
 */
public class ClimbStairs {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 1 <= n <= 45
     *
     * @param args
     */
    public static void main(String[] args) {
        ClimbStairs stairs = new ClimbStairs();
        int type = stairs.climbStairs(4);
        System.out.println(type);
    }

    public int climbStairsTest1(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;
        res[3] = 3;
        for (int i = 3; i < res.length; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    /**
     * n = 2 => 2; n = 3=>3
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
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

    /**
     * n = 2 => 2; n = 3=>3
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        return Fibonacci(n, 1, 1);
    }

    /**
     * 尾递归
     *
     * @param n
     * @param a
     * @param b
     * @return
     */
    public static int Fibonacci(int n, int a, int b) {
        if (n <= 1) {
            return b;
        }
        return Fibonacci(n - 1, b, a + b);
    }


    /**
     * n = 2 => 2; n = 3=>3
     *
     * @param n
     * @return 这种当n比较大的时候会超时
     */
    public int climbStairs1(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n < 3) {
            return n;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }


}
