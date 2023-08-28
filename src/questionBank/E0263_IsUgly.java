package questionBank;

/**
 * <p>
 * E0263_IsUgly
 * 丑数
 * </p>
 *
 * @author answer
 * @date 2023/8/28 21:11
 */
public class E0263_IsUgly {

    /**
     * 丑数 就是只包含质因数 2、3 和 5 的正整数。
     * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false
     * @param args
     */
    public static void main(String[] args) {
        E0263_IsUgly test = new E0263_IsUgly();
        System.out.println(test.isUgly(1));
    }

    /**
     * n = 6, 1 =>true; 14=>false;
     * 思路： 如果为1 则直接为true. 判断n 能否被2、3、5 整除。 如果可以，则判断值是否可以被2、3、5整除
     *       如果不能被整除则为false。 知道可以被整除 n==1
     */
    public boolean isUgly(int n) {
        if (n ==0) {
            return false;
        }
        while ( n %2 ==0 || n %3 ==0 || n %5 ==0 ) {
            if (n %2 ==0) {
                n = n / 2;
            } else if ( n %3 ==0) {
                n = n / 3;
            } else if ( n %5 ==0) {
                n = n / 5;
            }
        }
        return n == 1;
    }

}
