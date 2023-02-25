package primaryAlgorithms.array;

/**
 * @author 如果answer
 * @Description: <p>删除数重重复项</p>
 * @date 2022/10/8 22:52
 */
public class RemoveDuplicates {

    /**
     * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
     * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
     * @param args
     */
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();

        int [] a ={0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicates.removeDuplicates(a);
        System.out.println(i);
        System.out.println(a);
    }

    /**
     * nums = [0,0,1,1,1,2,2,3,3,4] =》5, nums = [0,1,2,3,4]
     * @param nums
     * @return
     * 思路： 双指针实现。 因为需要在数组直接操作。 两个指针一前一后， 指向对象相同， 就记录相同的个数。 不同就把后指针的值存在倩指针后一个位置
     * 同个当前索引 - 相同的个数就可以实现
     */
    public int removeDuplicates2(int[] nums) {
        int count =0;
        for (int i = 1; i < nums.length; i++) {
             if(nums[i] == nums[i-1]) {
                 count++;
             } else {
                 nums[i-count] = nums[i];
             }
        }
        return nums.length - count;
    }

    public int removeDuplicates(int[] nums) {
        int count =0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) {
                count ++;
            } else {
                nums[i-count] = nums[i];
            }
        }
        return nums.length - count;
    }
}
