package primaryAlgorithms.number;

/**
 * @author answer
 * @Description: <p>缺失数字</p>
 * @date 2023/1/22 18:43
 */
public class MissingNumber {

    /**
     * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
     * nums 中的所有数字都 独一无二
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * nums = [3,0,1] => 2; nums = [0,1] => 2;
     * nums = [9,6,4,2,3,5,7,0,1] => 8; nums = [0]=>1
     * @param nums
     * @return
     * 等差数列: 1+2+3+4+5+6+7+8+9 => (1+9)*9/2 = 45
     * 得到和之后, 挨个减去
     */
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sum = (length) * (length + 1) / 2;
        for (int i = 0; i < length; i++) {
            sum -= nums[i];
        }
        return sum;
    }

}
