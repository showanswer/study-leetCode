package questionBank;

import java.util.HashSet;

/**
 * <p>
 * E0136_SingleNumber
 * </p>
 *
 * @author answer
 * @date 2023/6/5 22:03
 */
public class E0136_SingleNumber {

    public static void main(String[] args) {
        E0136_SingleNumber test = new E0136_SingleNumber();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(test.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                set.remove(nums[i]);
            }
        }
        return (int) set.toArray()[0];

    }

}
