package middleAlgorithms.arrayAndString.dynamic;

/**
 * <p>
 * 跳跃游戏
 * </p>
 *
 * @author answer
 * @date 2023/4/18 19:34
 */
public class CanJump {

    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     */
    public static void main(String[] args) {
        CanJump test = new CanJump();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(test.canJump(nums));
    }

    /**
     * nums = [2,3,1,1,4] => true
     * nums = [3,2,1,0,4] => false
     * 思路： 从i 开始最多可以往后跳几步
     * dp[i] = Max(dp[i-1]-1, nums[i])
     * 结束条件： dp[i] + i + 1 >= nums.len (返回true) 或者 dp[i]==0 (返回false)
     */
    public boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max >= i) {
                 max = Math.max(max, nums[i]+i);
            }
        }
        return max >= nums.length-1;
    }

    public boolean canJump1(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + i - 1 > max) {
                max = nums[i - 1] + i - 1;
            }
            if (max + i >= nums.length - 1) {
                return true;
            } else if (max == 0) {
                return false;
            }


        }
        return false;
    }

}
