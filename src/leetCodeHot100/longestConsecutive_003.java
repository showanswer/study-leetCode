package leetCodeHot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author answer
 * @date 2024年08月12日 22:09
 * <Description>
 *      最长连续列： 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 要求：时间复杂度为 O(n)
 *
 * </Description>
 */
public class longestConsecutive_003 {

    /**
     * nums = [100,4,200,1,3,2] =》4 ； nums = [0,3,7,2,5,8,4,6,0,1] =》9
     * @author answer
     * @date 2024/8/12 22:14
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }


    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 去重，减少匹配次数
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longStreak = 0;
        for (Integer num : set) {
            // 为了减少 匹配次数， 既然该值前面还有值，就从该值的最小值开始算
            if (!set.contains(num-1)) {
                int curnum = num;
                int currentStreak = 1;

                while (set.contains(curnum + 1)) {
                    curnum += 1;
                    currentStreak += 1;
                }
                longStreak = Math.max(currentStreak, longStreak);
            }
        }
        return longStreak;
    }

}
