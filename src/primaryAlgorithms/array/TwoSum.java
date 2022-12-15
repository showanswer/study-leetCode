package primaryAlgorithms.array;

import java.util.HashMap;

/**
 * @author answer
 * @Description: <p>两数之和</p>
 * @date 2022/12/15 22:15
 */
public class TwoSum {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。你可以按任意顺序返回答案。
     *
     * @param args
     */
    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        int [] nums= new int[]{3,2,4};
        int[] ints = test.twoSum1(nums, 6);
        for (int num : ints) {
            System.out.println(num);
        }
    }

    /**
     * nums = [2,7,11,15], target = 9 => [0,1]; nums = [3,2,4], target = 6=>[1,2];nums = [3,3], target = 6=>[0,1]
     * @param nums
     * @param target
     * @return
     * 思路：利用hashMap, 已知元素不能重复，则元素值为key， 索引为value。 判断target-元素值，是否在map中存在
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                if (map.get(target-nums[i]) != i) {
                    return new int[]{i,map.get(target-nums[i])};
                }
            }
        }
        return new int[]{0};
    }

    /**
     * 暴力破解法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0};
    }

}
