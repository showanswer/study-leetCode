package primaryAlgorithms.array;

/**
 * @author answer
 * @Description: <p>加一</p>
 * @date 2022/12/15 21:21
 */
public class PlusOne {

    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * @param args
     */
    public static void main(String[] args) {
        PlusOne solution = new PlusOne();
        int []nums = new int[]{9};
        int[] ints = solution.plusOne1(nums);
        for (int num : ints) {
            System.out.println(num);
        }

    }

    /**
     * digits = [1,2,3] =>[1,2,4],  digits = [4,3,2,1] =>[4,3,2,2], digits = [0]=>[1]
     * @param digits
     * @return
     * 思路：数组最后一个元素加1， 如果9+1=10， 则最后一位为0， 前一位+1
     */
    public int[] plusOne(int[] digits) {
        int length = digits.length;

        int add =0;
        for (int i = length-1; i >=0 ; i--) {
            int num = digits[i];
            if (i == length-1) {
                num = digits[i] + 1;
            }
            if (add !=0) {
                num =num +add;
                add = 0;
            }
            if (num ==10) {
                add =1;
                digits[i] =0;
            } else {
                digits[i] =num;
            }
        }
        if (add == 1) {
            int[]  res = new int[length+1];
            res[0] =1;
            for (int i = 1; i < res.length; i++) {
                res[i] = digits[i-1];
            }
            return res;
        }else {
            return digits;
        }
    }


    /**
     * 优化1
     * @param digits
     * @return
     */
    public int[] plusOne1(int[] digits) {
        int length = digits.length;
        for (int i = length-1; i >=0 ; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] =0;
            }
        }
        // 走到这里还没有返回那就是 9->10. 如果要扩容数组，那就是后面全为0了
        int[] temp = new int[length+1];
        temp[0] = 1;
        return temp;
    }

}
