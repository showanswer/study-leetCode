package questionBank;

/**
 * <p>
 * E0231_isPowerOfTwo
 * 2 的幂
 * </p>
 *
 * @author answer
 * @date 2023/8/13 11:47
 */
public class E0231_IsPowerOfTwo {

    /**
     * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
     * @param args
     */
    public static void main(String[] args) {
        E0231_IsPowerOfTwo test = new E0231_IsPowerOfTwo();
        System.out.println(test.isPowerOfTwo(8));
    }

    /**
     * 思路： 判断是否时偶数即可
     * @param n
     * @return
     */
    public boolean isPowerOfTwo1(int n) {
        return (n>0) && (n & (n-1)) ==0;
    }

    public boolean isPowerOfTwo(int n) {
        if (n <1) {
            return false;
        }
        while (n !=1) {
            if (n % 2 != 0) {
                return false;
            }
            n = n/2;
        }
        return true;
    }

}
