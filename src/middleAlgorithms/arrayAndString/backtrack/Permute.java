package middleAlgorithms.arrayAndString.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 全排列
 * </p>
 *
 * @author answer
 * @date 2023/4/16 16:22
 */
public class Permute {

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * @param args
     */
    public static void main(String[] args) {
        Permute test = new Permute();
        int[] nums = {1,2,3};
        System.out.println(test.permute(nums));
    }

    /**
     * nums = [1,2,3] =>  [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, new ArrayList<>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(res, nums, tempList);
        }
    }

}
