package primaryAlgorithms.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author answer
 * @Description: <p>存在重复元素</p>
 * @date 2022/12/14 22:00
 */
public class ContainsDuplicate {

    /**
     * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
     *
     * @param args
     */
    public static void main(String[] args) {
        ContainsDuplicate test = new ContainsDuplicate();
        int[] nums = new int[]{1, 2, 3, 4};
        boolean flag = test.containsDuplicate2(nums);
        System.out.println(flag);
    }

    /**
     * nums = [1,2,3,1] => true
     * nums = [1,2,3,4] => false
     * nums = [1,1,1,3,3,4,3,2,4,2] => true
     *
     * @param nums
     * @return 思路： 1. 只要有重复的数值就返回true，否则返回false， 用set可以直接解决
     */
    public boolean containsDuplicate3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 思路2： 暴力破解法： 直接双循环比较是否有相同的值
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 思路3: 可以先排序， 排序后在前后比较
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }
}
