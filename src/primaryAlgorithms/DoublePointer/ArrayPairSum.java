package primaryAlgorithms.DoublePointer;

import java.util.Arrays;

/**
 * @author answer
 * @Description: <p>数组拆分 I</p>
 * @date 2023/3/1 14:38
 */
public class ArrayPairSum {

    /**
     * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
     * 使得从 1 到 n 的 min(ai, bi) 总和最大。
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayPairSum test = new ArrayPairSum();
        int[] nums = {6,2,6,5,1,2};
        System.out.println(test.arrayPairSum(nums));
    }

    /**
     * nums = [1,4,3,2] =>4;  nums = [6,2,6,5,1,2]=>9
     * @param nums
     * @return
     * 思路： 数组全拆分成2对的， 从小到大排序，
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res=0;
        for(int idx=0;idx<nums.length;idx++){
            if(idx%2==0) {
                res+=nums[idx];
            }
        }
        return res;
    }

}
