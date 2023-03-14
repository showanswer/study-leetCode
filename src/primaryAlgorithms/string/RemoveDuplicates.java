package primaryAlgorithms.string;

/**
 * @author answer
 * @Description: <p>删除排序数组中的重复项</p>
 * @date 2023/3/14 20:11
 */
public class RemoveDuplicates {

    /**
     * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持一致 。
     * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。
     * 更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
     *
     * 将最终结果插入 nums 的前 k 个位置后返回 k 。
     * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * @param args
     */
    public static void main(String[] args) {
        RemoveDuplicates test = new RemoveDuplicates();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(test.removeDuplicates(nums));
    }

    /**
     * nums = [1,1,2] => 2, nums = [1,2];
     * nums = [0,0,1,1,1,2,2,3,3,4] => 5, nums = [0,1,2,3,4]
     * @param nums
     * @return
     * 思路：重复元素计数
     *
     */
    public int removeDuplicates1(int[] nums) {
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[start]) {
                nums[++start] = nums[i];
            }
        }
        return start + 1;
    }

    /**
     * 优化
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int count =0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                count++;
            } else {
                nums[i-count] = nums[i];
            }
        }
        return nums.length - count;
    }

}
