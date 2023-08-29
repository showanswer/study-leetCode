package questionBank;

/**
 * <p>
 * E0278_FirstBadVersion
 * 第一个错误的版本
 * </p>
 *
 * @author answer
 * @date 2023/8/29 20:56
 */
public class E0278_FirstBadVersion {

    public static void main(String[] args) {
        E0278_FirstBadVersion test = new E0278_FirstBadVersion();
        System.out.println(test.firstBadVersion(5));

    }

    /**
     * n = 5, bad = 4 =>4
     * 思路： 判断第一个错误的版本，从中间进行判断， 如果
     */
    public int firstBadVersion(int n) {
        int left =0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) /2;
            if (isBadVersion(mid)) {
               right = mid;
            } else {
                left = mid +1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int n) {
        if (n >= 4) {
            return true;
        }
        return false;
    }

}
