package primaryAlgorithms.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author answer
 * @Description: <p>只出现一次的数字</p>
 * @date 2022/12/14 22:12
 */
public class SingleNumber {

    /**
     * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
     *
     * @param args
     */
    public static void main(String[] args) {
        SingleNumber test = new SingleNumber();
        int[] nums = new int[]{4, 1, 2, 1, 2};
        int num = test.singleNumber1(nums);
        System.out.println(num);
    }

    /**
     * nums = [2,2,1]=>1, nums = [4,1,2,1,2]=>4, nums = [1]=>1
     *
     * @param nums
     * @return 思路1： 判断某个字符只出现一次， 可以haspMap key为字符， value为出现的次数
     */
    public int singleNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                set.remove(nums[i]);
            }
        }
        return (Integer) set.toArray()[0];
    }

    public int singleNumber(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value.equals(1)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 思路2： 利用set, 把数据存到set，如果之前一家存在就remove删除掉。 题中声明了其余元素只出现两次
     *
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return (Integer) set.toArray()[0];
    }

}
