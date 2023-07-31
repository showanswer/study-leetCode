package primaryAlgorithms.array;

/**
 * @author answer
 * @Description: <p>移动零</p>
 * @date 2022/12/15 21:53
 */
public class MoveZeroes {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     *
     * @param args
     */
    public static void main(String[] args) {
        MoveZeroes test = new MoveZeroes();
        int[] nums = new int[]{1, 0, 0, 3, 12};
        test.moveZeroes2(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * nums = [0,1,0,3,12]=>[1,3,12,0,0], nums = [0]=>[0]
     *
     * @param nums 思路： 如果为0就和索引>=该索引，最近的非0的相交换位置
     */
    public void moveZeroes2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }
        while (count < nums.length) {
            nums[count++] = 0;
        }
    }

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    /**
     * nums = [0,1,0,3,12]=>[1,3,12,0,0], nums = [0]=>[0]
     * 思路1： 把所有非0的往前移动就好，为0的最后数组填充
     *
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 记录非0的个数
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
