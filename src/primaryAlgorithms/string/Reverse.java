package primaryAlgorithms.string;

/**
 * @author answer
 * @Description: <p>整数反转</p>
 * @date 2022/12/19 22:50
 */
public class Reverse {

    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。 901000
     * @param args
     */
    public static void main(String[] args) {
        Reverse test = new Reverse();
        int reverse = test.reverse(901000);
        System.out.println(reverse);
    }

    /**
     * x = 123=>321, x = -123=>-321, x = 120=>21
     * @param x
     * @return
     * 思路： 通过除十求余得到末尾的值
     */
    public int reverse2(int x) {
        int res=0;
        while (x!=0) {
            int re = x%10;
            res = res*10 +re;
            if (res%10 != re) {
                res = 0;
            }
            x = x/10;
        }
        return res;
    }

    public int reverse(int x) {
        int res=0;
        while (x!=0) {
            int endNum = x % 10;
            res= res * 10 + endNum;
            if (res % 10 != endNum) {
                res = 0;
            }
            x = x/10;
        }
        return res;
    }

}
