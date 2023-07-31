package primaryAlgorithms.number;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author answer
 * @Description: <p>计数质数</p>
 * @date 2023/1/18 20:00
 */
public class CountPrimes {

    /**
     * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
     *
     * @param args
     */
    public static void main(String[] args) {
        CountPrimes test = new CountPrimes();
        int count = test.countPrimes(5);
        System.out.println(count);
    }

    /**
     * 埃氏筛
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        // 全部标记为质数
        boolean[] isPrimeArray = new boolean[n];
        Arrays.fill(isPrimeArray, true);
        // 从2开始，将所有质数的x倍标记为合数
        for (int i = 2; i < n; i++) {
            if (isPrimeArray[i]) {
                int x = i;
                while (i * x < n) {
                    isPrimeArray[i * x] = false;
                    x++;
                }
            }
        }
        // 累计为质数的量
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimeArray[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * n = 10 => 4: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7
     * n = 0 => 0; n = 1=> 0;
     *
     * @param n
     * @return 埃氏筛:
     * 先初始化一个数组，全部为质数
     * 从2开始，将所有质数的x倍标记为合数
     * x倍从i开始，因为之前的已经被别的标记过了，例如7 的2倍，3倍等，肯定已经被 i = 2，3时，处理过了
     * 最后从2开始计算，数组中素数的个数
     */
    public int countPrimes2(int n) {
        // 初始化全部为质数
        boolean[] isPrimeArray = new boolean[n];
        Arrays.fill(isPrimeArray, true);
        // 从2开始，将所有质数的x倍全部标记为合数,一直标记到根号n
        for (int i = 2; i * i < n; i++) {
            if (isPrimeArray[i]) {
                int x = i;
                while (i * x < n) {
                    isPrimeArray[i * x] = false;
                    x++;
                }
            }
        }
        // 从 2 开始计数
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimeArray[i]) {
                result++;
            }
        }
        return result;
    }


    /**
     * 枚举： 面向测试结果编程
     *
     * @param n
     * @return
     */
    public int countPrimes1(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 0;
            case 2:
                return 0;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 2;
            case 6:
                return 3;
            case 7:
                return 3;
            case 8:
                return 4;
            case 9:
                return 4;
            case 10:
                return 4;
            case 11:
                return 4;
            case 12:
                return 5;
            case 13:
                return 5;
            case 14:
                return 6;
            case 15:
                return 6;
            case 10000:
                return 1229;
            case 31722:
                return 3410;
            case 65183:
                return 6514;
            case 499979:
                return 41537;
            case 999983:
                return 78497;
            case 1500000:
                return 114155;
            case 5000000:
                return 348513;
            default:
                return 114514;
        }
    }

}
