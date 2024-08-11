package leetCodeHot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author answer
 * @date 2024年08月11日 12:09
 * <Description>
 * 两数之和 ：
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现
 * 思路：
 * 数组里不存在相同的元素， 可以用Map，set存储 key为元素。
 * </Description>
 */
public class TwoSum_001 {


    public static void main(String[] args) {
        int[] nums = {2, 11, 7, 15};
        int[] ints = twoSum(nums, 9);
        for (int anInt : ints) {
            System.out.print(anInt);
        }
    }

    /**
     * 集合解法
     * @author answer
     * @date  12:47
     * @param nums
     * @param target
     * @return int[]
     */
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }


    /**
     *  暴力破解
     * @author answer
     * @date 2024/8/11 12:48
     * @param nums
     * @param target
     * @return int[]
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
               if (nums[i] + nums[j] == target) {
                   return new int[]{i, j};
               }
            }
        }
        return new int[]{0, 0};
    }
}
