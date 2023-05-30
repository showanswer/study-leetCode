package questionBank;

import sun.applet.Main;

/**
 * <p>
 *  x 的平方根
 * </p>
 *
 * @author answer
 * @date 2023/5/30 14:16
 */
public class E0069_MySqrt {

    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * @param args
     */
    public static void main(String[] args) {
        E0069_MySqrt sqrt = new E0069_MySqrt();
        System.out.println(sqrt.mySqrt(8));
    }

    /**
     * 思路： 二分查找遍历
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int l=0, r = x, ans = 0;
        while (l <= r) {
            int mid = l + (r -l) /2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid +1;
            } else {
                r = mid -1;
            }
        }
        return ans;
    }

}
