package leetCodeHot100;

import java.util.Arrays;

/**
 * @author answer
 * @date 2024年08月13日 23:37
 * <Description>
 * 移动零 : 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *  计算0 的个数
 * </Description>
 */
public class moveZeroes_004 {

    /**
     * nums = [0,1,0,3,12] =》[1,3,12,0,0]
     *
     * @param args
     * @author answer
     * @date 2024/8/13 23:40
     */
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }

    // 001312 130012
    public static void moveZeroes(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        Arrays.sort(nums);

        int zerLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[zerLen];
                nums[zerLen ++] = tmp;
            }
        }

    }

}
