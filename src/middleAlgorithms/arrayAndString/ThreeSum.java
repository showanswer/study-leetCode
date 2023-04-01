package middleAlgorithms.arrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author answer
 * @Description: <p>三数之和</p>
 * @date 2023/3/27 20:29
 */
public class ThreeSum {

    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
     * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
     *
     * @param args
     */
    public static void main(String[] args) {
        ThreeSum test = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        test.threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >0) {
                break;
            }
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left =i+1;
            int right =nums.length -1;
            int target =-nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left+1]){
                        left ++;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                } else  if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

}
