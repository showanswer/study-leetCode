package primaryAlgorithms.dynamicProgramming;

/**
 * @author answer
 * @Description: <p>打家劫舍</p>
 * @date 2023/1/11 15:35
 */
public class Rob {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * @param args
     */
    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] nums = {2,1,1,2};
        int res = rob.rob1(nums);
        System.out.println(res);

    }

    /**
     * [1,2,3,1] => 4; [2,7,9,3,1]=>12; [2,1,1,2]=>4
     * @param nums
     * @return
     * 思路： 动态规划 两种方式： 偷的时候不一定隔一家,可能隔多家。 两种情况 偷或者不偷
     *      1: 确定状态 dp[i]：dp[length][2]， dp[i][0]表示第i+1家没偷得最大金额，dp[i][1]表示的是第i+1家偷的最大总金额
     *      2: 确定方程:
     *          当前这家没偷了得最大金额：dp[i][0]=max(dp[i-1][0],dp[i-1][1])； 如果这家没偷，那么上家有没有偷都是可以的
     *          当前这家偷了得最大金额：dp[i][1]= dp[i-1][0] + nums[i]； 如果这家偷了， 说明上家一定没偷
     *      3: 初始条件或边界：
     *         第一家没偷： dp[0][0]=0
     *         第一家偷了： dp[0][1]=nums[0]
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[][] dp = new int[length][2];
        dp[0][0]=0;
        dp[0][1]=nums[0];

        for (int i = 1; i < dp.length; i++) {
           dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
           dp[i][1] = dp[i-1][0] + nums[i];
        }

        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }

    /**
     * 上面定义了一个二维数组，但每次计算的时候都只是用二维数组的前一对值，在往前面的就永远使用不到了
     * 造成了空间浪费， 只需要定义两个变量代表不同状态下得前一天最大金额
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        //第1家没偷
        int dp0 = 0;
        //第1家偷了
        int dp1 = nums[0];
        for (int i = 1; i < length; i++) {
            //防止dp0被修改之后对下面运算造成影响，这里
            //使用一个临时变量temp先把结果存起来，计算完
            //之后再赋值给dp0
            int temp = Math.max(dp0, dp1);
            // 当前家偷， 前一家不偷 + 当前家得金额
            dp1 = dp0 + nums[i];
            // 当前这家不偷， 前一家可偷可不偷。 取前一家得最大值
            dp0 = temp;
        }
        //最后取最大值即可
        return Math.max(dp0, dp1);
    }
}
