package primaryAlgorithms.design;

import java.util.Random;

/**
 * @author answer
 * @Description: <p>打乱数组</p>
 * @date 2023/1/13 17:03
 */
public class Shuffle {

    int[] nums;

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Shuffle shuffle = new Shuffle(nums);
        int[] reset = shuffle.reset();
        System.out.println(reset);
        int[] shuffle1 = shuffle.shuffle();
        System.out.println(shuffle1);
        reset = shuffle.reset();
        System.out.println(reset);
    }

    /**
     * 使用整数数组 nums 初始化对象
     *
     * 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
     * @param nums
     */
    public Shuffle(int[] nums) {
        this.nums = nums;
    }

    /**
     * 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
     * @return
     */
    public int[] reset() {
        return nums;
    }

    /**
     * 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
     * @return
     */
    public int[] shuffle() {
        if (nums == null) {
            return null;
        }
        int[] a = nums.clone();
        Random random = new Random();
        for (int j = 1; j < a.length; j++) {
            int i = random.nextInt(j + 1);
            swap(a, i, j);
        }

        return a;
    }

    /**
     * 交换两个数字的值
     * @param a
     * @param i
     * @param j
     */
    private void swap(int[] a, int i, int j) {
        if (i != j) {
            a[i] = a[i] + a[j];
            a[j] = a[i] - a[j];
            a[i] = a[i] - a[j];
        }
    }

}
