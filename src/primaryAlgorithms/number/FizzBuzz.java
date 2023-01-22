package primaryAlgorithms.number;

import java.util.ArrayList;
import java.util.List;

/**
 * @author answer
 * @Description: <p>FizzBuzz</p>
 * @date 2023/1/18 19:45
 */
public class FizzBuzz {

    /**
     * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
     * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
     * answer[i] == "Fizz" 如果 i 是 3 的倍数。
     * answer[i] == "Buzz" 如果 i 是 5 的倍数。
     * answer[i] == i （以字符串形式）如果上述条件全不满足。
     * @param args
     */
    public static void main(String[] args) {
        FizzBuzz test = new FizzBuzz();
        List<String> list = test.fizzBuzz(5);
        for (String value : list) {
            System.out.println(value);
        }

    }

    /**
     * n = 3 => ["1","2","Fizz"]; n = 5 => ["1","2","Fizz","4","Buzz"]
     * n = 15 => ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
     *
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();

        // 初始全部 数字赋值
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }
        // 如果是3的倍数就为fizz
        for (int i = 1; i <= list.size(); i++) {

            if (i % 3 == 0) {
                list.set(i-1, "Fizz");
            }
            if (i % 5 == 0) {
                list.set(i-1, "Buzz");
            }
            if (i % 15 == 0) {
                list.set(i-1, "FizzBuzz");
            }
        }
        return list;
    }

}
