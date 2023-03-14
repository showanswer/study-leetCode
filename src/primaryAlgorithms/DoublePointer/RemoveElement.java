package primaryAlgorithms.DoublePointer;

/**
 * @author answer
 * @Description: <p>双指针-移除元素</p>
 * @date 2023/3/1 21:20
 */
public class RemoveElement {

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * @param args
     */
    public static void main(String[] args) {
        RemoveElement test = new RemoveElement();
        int[] nums ={0,1,2,2,3,0,4,2};
        System.out.println(test.removeElement(nums, 2));
    }

    /**
     * nums = [0,1,2,2,3,0,4,2], val = 2 => 5, nums = [0,1,4,0,3]
     * @param nums
     * @param val
     * @return
     * 思路： 统计不等于target值的数
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == val){
                continue;
            }
            nums[left++] = nums[i];
        }
        return left;
    }


    /**
     * 统计等于target值的数
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {
        int j=0;
        for (int i = 0; i < nums.length; i++) {
           if (nums[i] == val) {
               j++;
           } else {
               nums[i-j] = nums[i];
           }
        }
        return nums.length-j;
    }

}
