package primaryAlgorithms.array;

import java.util.Arrays;

/**
 * @author 如果answer
 * @Description: <p>旋转数组</p>
 * @date 2022/10/8 23:41
 */
public class Rotate {

    /**
     * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     *
     * @param args
     */
    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        rotate.rotate2(a, 3);
    }

    /**
     * nums = [1,2,3,4,5,6,7], k = 3 => [5,6,7,1,2,3,4]
     * nums = [-1,-100,3,99], k = 2 =》[3,99,-1,-100]
     *
     * @param nums
     * @param k    思路： 1. 右轮旋转的话, 肯定是第一个字符 到最后一个字符。 再依次往前移。
     *             2.这里没说原数组。 可以加个临时数组。 把数组拆分成两部分 前一部分 和 后一部分。 新数组后的再前面，前的在后面
     *             这边需要修改 换种方式 执行
     */
    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        int[] tmp = Arrays.copyOf(nums, length);
        for (int i = 0; i < length; i++) {
            nums[(i+k)%length] = tmp[i];
        }
        for (int num : tmp) {
            System.out.print(num);
        }
    }
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int t = length - k;
        int[] tmp3 = new int[length];
        for (int i = 0; i < length; i++) {
            if (i < k) {
                tmp3[t + i] = nums[i];
            } else {
                tmp3[i - t] = nums[i];
            }
        }
      
        for (int num : tmp3) {
            System.out.print(num);
        }
    }

    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        int temp[] = new int[length];;
        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }
        for (int i = 0; i < length; i++) {
            nums[(i+k)%length] =  temp[i];
        }
    }

}
