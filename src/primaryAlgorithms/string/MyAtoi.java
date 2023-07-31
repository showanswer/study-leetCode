package primaryAlgorithms.string;

/**
 * @author answer
 * @Description: <p>字符串转换整数</p>
 * @date 2022/12/20 23:29
 */
public class MyAtoi {

    /**
     * 函数 myAtoi(string s) 的算法如下：
     * <p>
     * 读入字符串并丢弃无用的前导空格
     * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
     * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，
     * 大于 231 − 1 的整数应该被固定为 231 − 1 。
     * 返回整数作为最终结果。
     *
     * @param args
     */
    public static void main(String[] args) {
        MyAtoi test = new MyAtoi();
        int num = test.myAtoi1("21474836460");
        System.out.println(num);
    }

    /**
     * 思路：
     * 定义一个指针index 指向正在判断的字符
     * 先把空格去掉index++
     * 再判断是否有符号 index++ 并保留
     * 遇到非数字直接return
     * 先允许越界，越界后数据肯定和期望值不同，整除10后和原来的数比较即可，根据符号返回对应的最值
     * 返回结果时，带上符号
     *
     * @param s
     * @return
     */
    public int myAtoi2(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int index = 0;
        while (index < length && chars[index] == ' ') {
            index++;
        }
        // 极端情况 "  " 和""
        if (index >= length) {
            return 0;
        }
        // 判断符号, 有符号就index++， 这样索引就为第一个正式元素的下标了
        int sign = 1;
        if (chars[index] == '-') {
            sign = -1;
            index++;
        } else if (chars[index] == '+') {
            index++;
        }
        int result = 0;
        int temp = 0;
        while (index < length) {
            // 还要判断是否十数字 非数字就过滤掉
            int num = chars[index] - '0';
            if (num > 9 || num < 0) {
                break;
            }
            temp = result;
            result = result * 10 + num;
            if (result / 10 != temp) {
                if (sign > 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            index++;
        }
        return result * sign;
    }

    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int index = 0;
        // 前导空格去除 index索引为第一个非签到空格的字符
        while (index < length && chars[index] == ' ') {
            index++;
        }
        // 极端情况 "  " 和""
        if (index >= length) {
            return 0;
        }
        // 判断符号, 有符号就index++， 这样索引就为第一个正式元素的下标了
        int sign = 1;
        if (chars[index] == '-') {
            sign = -1;
            index++;
        } else if (chars[index] == '+') {
            index++;
        }
        int result = 0;
        int temp = 0;
        while (index < length) {
            // 还要判断是否十数字 非数字就过滤掉
            int num = chars[index] - '0';
            if (num > 9 || num < 0) {
                break;
            }
            temp = result;
            result = result * 10 + num;
            if (result / 10 != temp) {
                if (sign > 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            index++;
        }
        return result * sign;
    }

    public int myAtoi1(String s) {
        int length = s.length();
        int index = 0;
        while (index < length && s.charAt(index) == ' ') {
            index++;
        }
        // 极端情况 "  " 和""
        if (index >= length) {
            return 0;
        }
        // 符号
        int sign = 1;
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            if (s.charAt(index) == '-') {
                sign = -1;
            }
            index++;
        }
        // 循环遍历剩下 非前导空格
        int res = 0;
        int tmp = 0;
        while (index < length) {
            // 字符转为数字
            int num = s.charAt(index++) - '0';
            // 遇到非数字的字符就直接结束
            if (num > 9 || num < 0) {
                break;
            }
            tmp = res;
            res = res * 10 + num;
            // 超过了int的范围界限
            if (res / 10 != tmp) {
                if (sign == -1) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return sign * res;
    }
}
