package questionBank;

import jdk.nashorn.internal.runtime.regexp.joni.constants.Traverse;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * E0268_MissingNumber
 * 丢失的数字
 * </p>
 *
 * @author answer
 * @date 2023/8/28 21:32
 */
public class E0268_MissingNumber {

    /**
     * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
     */
    public static void main(String[] args) {
        E0268_MissingNumber test = new E0268_MissingNumber();
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(test.missingNumber(nums));
    }

    /**
     * nums = [3,0,1] => 2; nums = [0,1]=>2; nums = [9,6,4,2,3,5,7,0,1] =>8
     * 思路： 从0 开始 到 nums的长度 len， 找中间缺少哪个
     *
     */
    public int missingNumber(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i <= len; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 这时从0 开始连续的数组， 可以全部相加求和得sum， sum再诸葛减去nums的值最终的结果就是缺少的
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
        int length = nums.length;
        int sum = (length) * (length + 1) / 2;
        for (int i = 0; i < length; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
