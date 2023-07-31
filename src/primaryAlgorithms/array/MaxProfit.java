package primaryAlgorithms.array;

/**
 * @author 如果answer
 * @Description: <p>买卖股票的最佳时机 II</p>
 * @date 2022/10/8 23:04
 */
public class MaxProfit {

    /**
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     *
     * @param args
     */
    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] a = {7, 1, 5, 3, 6, 4};
        int i = maxProfit.maxProfit1(a);
        System.out.println(i);
    }

    /**
     * prices = [7,1,5,3,6,4]=>7
     * prices = [1,3,2,4,5] =>4
     * prices = [7,6,4,3,1] => 0
     *
     * @param prices
     * @return 思路： 只能持有 或者不持有 把每天持有的情况和不持有的情况 都进行计算。 每天都取最大利润
     * 由于我们已经能够提前知道每一天股票的价格，那么只要判断出来后一天的价钱比前一天的高，那么我们就执行这次买卖操作，并记录获得的收益。
     */
    public int maxProfit2(int[] prices) {
        int length = prices.length;
        if (length < 2 || prices == null) {
            return 0;
        }

        int[][] left = new int[length][2];
        int[][] right = new int[length][2];
        left[0][0] = 0;
        right[0][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            // 第1+n天不持有分两种情况 (前一天不持有，今天也不持有 或者 前一天持有， 今卖掉了)
            left[i][0] = Math.max(left[i - 1][0], right[i - 1][1] + prices[i]);
            //前一持有，今不卖 或者 前一天不持有， 今天买入
            right[i][1] = Math.max(right[i - 1][1], left[i - 1][0] - prices[i]);
        }
        return Math.max(left[length - 1][0], right[length - 1][1]);
    }

    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] left = new int[length][2];
        int[][] right = new int[length][2];
        // 第一天持有 或 不持有可得出
        left[0][0] = 0;
        right[0][1] = -prices[0];
        // 从第二天开始算
        for (int i = 1; i < prices.length; i++) {
            // 第1+n天不持有分两种情况 (前一天不持有，今天也不持有 或者 前一天持有， 今卖掉了)
            left[i][0] = Math.max(left[i - 1][0], right[i - 1][1] + prices[i]);
            // 第1+n天持有分两种情况 (前一持有，今不卖 或者 前一天不持有， 今天买入)
            right[i][1] = Math.max(right[i - 1][1], left[i - 1][0] - prices[i]);
        }

        return Math.max(left[length - 1][0], right[length - 1][1]);


    }

    /**
     * 贪心算法是指，在对问题求解时，总是做出在当前看来是最好的选择。也就是说，不从整体最优上加以考虑，算法得到的是在某种意义上的局部最优解。
     * 这是从已知结果的情况下 开始考虑。 已经知道股票上升或者下降才可操作
     * 思路2： 只有前一天小， 后一天大 才能盈利。 股票升区间时，才会盈利
     * 盈利的最大值： 把所有升区间相加 - 所有降区间之和 => 后一个值 - 前一个值 。 累计相加
     */
    public int maxProfit1(int[] prices) {
        int length = prices.length;
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < prices.length; i++) {
            int i1 = prices[i] - prices[i - 1];
            if (i1 > 0) {
                count += i1;
            }
        }

        return count;
    }

}
