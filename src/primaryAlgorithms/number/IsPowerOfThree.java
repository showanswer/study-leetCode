package primaryAlgorithms.number;

/**
 * @author answer
 * @Description: <p>3的幂</p>
 * @date 2023/1/19 21:54
 */
public class IsPowerOfThree {

    /**
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
     * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
     *
     * @param args
     */
    public static void main(String[] args) {
        IsPowerOfThree test = new IsPowerOfThree();
        boolean powerOfThree = test.isPowerOfThree(27);
        System.out.println(powerOfThree);
    }

    /**
     * n = 27 => true; n = 45=>false; n = 0=>false
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n > 1) {
            while (n % 3 == 0) {
                n /= 3;
            }
        }
        return n == 1;
    }

}
