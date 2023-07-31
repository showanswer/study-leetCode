package primaryAlgorithms.string;

import java.util.Arrays;

/**
 * @author answer
 * @Description: <p>给定任意两个数： 求数中间的数累加的总值</p>
 * @date 2022/12/23 21:55
 */
public class TwoNumAdd {

    public static void main(String[] args) {
        TwoNumAdd test = new TwoNumAdd();
        Integer res = test.twoNumAdd(-3, -6);
        System.out.println(res);
    }

    /**
     * [1, 4]=>(1+2+3+4)= 10; [-3, 2]=> (-3-2-1+0+1+2) =-3;  [-3, -6]=> (-3 -4 -5 -6)=-18
     *
     * @param num1
     * @param num2
     * @return 思路： 此题以下有三种情况：
     * [1,4]=>(4-1)=3中间隔离 3个值；(1+2+3+4)累加差四个值。
     * [-3,2]=>(2-（-3）)=5中间隔离 5个值； (-3-2-1+0+1+2)累加差五个值
     * [-3,-6]=>(-3-（-6）)=3中间隔离 3个值；(-3 -4 -5 -6)累加差四个值
     * 先判断大小， （大值-小值）刚好都是相减的值+1。在小值累加 可得到值
     */
    public Integer twoNumAdd(int num1, int num2) {
        int[] array = new int[]{num1, num2};
        // 排序 由小到大
        Arrays.sort(array);
        num1 = array[0];
        num2 = array[1];

        int result = num1;
        int len = num2 - num1;
        for (int i = 0; i < len; i++) {
            int temp = ++num1;
            result = result + temp;
        }
        return result;
    }

}
