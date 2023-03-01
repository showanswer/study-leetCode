package primaryAlgorithms.DoublePointer;

/**
 * @author answer
 * @Description: <p>TwoSum</p>
 * @date 2023/3/1 15:32
 */
public class TwoSum {

    /**
     * 给你一个下标从1开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。
     * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
     * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
     * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
     *
     * @param args
     */
    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        int[] nums = {2,7,11,15};
        int[] ints = test.twoSum(nums, 9);
        System.out.println("***");
    }

    /**
     * numbers = [2,7,11,15], target = 9 =>[1,2];  numbers = [2,3,4], target = 6=>[1,3]
     * numbers = [-1,0], target = -1 => [1,2]
     * @param numbers
     * @param target
     * @return
     * 基本思路:
     *  由于数组从小到大排列, 双指针分别指向首部和尾部;
     *  首部尾部相加等于目标值，返回结果集
     *  首部尾部相加小于目标值，首部后移变大
     *  首部尾部相加大于目标值，尾部前移变小
     *
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] res=new int[]{-1,-1};
        int left=0,right=numbers.length-1;
        while (left<right) {
            if(numbers[left]+numbers[right]==target){
                res[0]=left+1;
                res[1]=right+1;
                break;
            } else if(numbers[left]+numbers[right]<target){
                left++;
            } else {
                right --;
            }
        }
        return res;
    }

}
