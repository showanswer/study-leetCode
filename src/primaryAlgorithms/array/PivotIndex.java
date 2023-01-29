package primaryAlgorithms.array;

/**
 * @author answer
 * @Description: <p>PivotIndex</p>
 * @date 2023/1/29 15:33
 */
public class PivotIndex {

    /**
     * 给你一个整数数组 nums ，请计算数组的 中心下标 。
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
     * @param args
     *
     * 先求得数组中所有元素之和sum；
     * 遍历数组，取当前下标左边的元素之和left_sum，同时sum减去已遍历元素，比较二者是否相等，相等则返回当前下标；
     * 遍历结束，代表没有中心索引，返回-1；
     *
     */
    public static void main(String[] args) {
        PivotIndex test = new PivotIndex();
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(test.pivotIndex(nums));
    }

    /**
     * nums = [1, 7, 3, 6, 5, 6] =>3;nums = [1, 2, 3] => -1;nums = [2, 1, -1] => 0
     *
     * @param nums
     * @return
     * 思路： 先计算数字累计和，再减去当前数值， 减去后的总和就是该数右侧数据总和。 判断左右两侧是否相同，不同左侧累加。继续循环
     */
    public int pivotIndex(int[] nums) {
        int sum =0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int left_sum =0;
        for (int i=0;i<nums.length;i++) {
            sum -= nums[i];
            if(left_sum == sum){
                return i;
            }
            left_sum += nums[i];
        }
        return -1;
    }
}
