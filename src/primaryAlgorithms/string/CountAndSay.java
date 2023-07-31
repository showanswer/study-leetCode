package primaryAlgorithms.string;

/**
 * @author answer
 * @Description: <p>外观数列</p>
 * @date 2022/12/21 21:09
 */
public class CountAndSay {

    /**
     * 给定一个正整数 n ，输出外观数列的第 n 项。「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
     * 你可以将其视作是由递归公式定义的数字字符串序列：
     * countAndSay(1) = "1"
     * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
     *
     * @param args
     */
    public static void main(String[] args) {
        CountAndSay test = new CountAndSay();
        String s = test.countAndSay1(4);
        System.out.println(s);
    }

    /**
     * n = 4 => "1211"; n = 1=>1
     *
     * @param n
     * @return 先确立递归出口 n = 1时 为1
     * 对上一个结果进行遍历获取值
     * 设定计数器，计算同一个数字出现的次数
     * 如果数字相同，计数器加一
     * 若当前不满足，则将上次的值记录下，并重置计数器，重置需要判断是否重复的字符
     * 将最后的结果也追加到字符串上
     */
    public String countAndSay2(int n) {
        if (n == 1) {
            return "1";
        }
        String s1 = countAndSay2(n - 1);
        StringBuilder res = new StringBuilder();
        char local = s1.charAt(0);
        int count = 1;
        for (int i = 1; i < s1.length(); i++) {
            if (s1.charAt(i) == local) {
                count++;
            } else {
                res.append(count);
                res.append(local);
                count = 1;
                local = s1.charAt(i);
            }
        }
        res.append(count);
        res.append(local);
        return res.toString();
    }


    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        // 假设我们获得上一次的结果为 s1 = 112213
        String lastRes = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        // 对s1遍历处理获取值, local 上一层的第一个元素
        char local = lastRes.charAt(0);
        int count = 0;
        for (int i = 0; i < lastRes.length(); i++) {
            // 设定计数器 计算同一个数字出现的次数 count
            if (lastRes.charAt(i) == local) {
                count++;
            } else {
                // 不符合，记录下
                result.append(count);
                result.append(local);
                count = 1;
                local = lastRes.charAt(i);
            }
        }
        result.append(count);
        result.append(local);
        return result.toString();

    }


    /**
     * n = 4 => "1211"; n = 1=>1
     *
     * @param n
     * @return 先确立递归出口 n = 1时 为1
     * 对上一个结果进行遍历获取值
     * 设定计数器，计算同一个数字出现的次数
     * 如果数字相同，计数器加一
     * 若当前不满足，则将上次的值记录下，并重置计数器，重置需要判断是否重复的字符
     * 将最后的结果也追加到字符串上
     */
    public String countAndSay1(int n) {
        if (n == 1) {
            return "1";
        }
        String s1 = countAndSay1(n - 1);
        StringBuilder result = new StringBuilder();
        // 获取返回值的第一个值
        char local = s1.charAt(0);
        // 每个元素的数量
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == local) {
                count++;
            } else {
                result.append(count);
                result.append(local);
                count = 1;
                local = s1.charAt(i);
            }
        }
        result.append(count);
        result.append(local);
        return result.toString();
    }

}
