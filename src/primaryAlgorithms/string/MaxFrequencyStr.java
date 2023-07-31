package primaryAlgorithms.string;

import java.util.HashMap;

/**
 * @author answer
 * @Description: <p>给定一个字符串，返回该字符中出现频率最多的字符的出现次数</p>
 * @date 2022/12/24 16:18
 */
public class MaxFrequencyStr {

    /**
     * 给定一个字符串，返回该字符中出现频率最多的字符的出现次数
     * 注1： 大小写不区分
     * 注2： 字符串中 只包含字母或数字
     *
     * @param args
     */
    public static void main(String[] args) {
        MaxFrequencyStr test = new MaxFrequencyStr();
        int num = test.maxFrequencyStr2("aabbcde");
        System.out.println(num);
    }

    /**
     * "abcde" =>1; "aabbcde" =>2; "aAl1" =>1
     *
     * @param str
     * @return 思路： 利用hashMap 进行存储， key为字符， value为出现的次数
     */
    public int maxFrequencyStr2(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        Integer integer = map.values().stream().max(Integer::compareTo).get();
        return integer;

    }

    public int maxFrequencyStr(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = Character.toLowerCase(chars[i]);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Integer num = map.values().stream().max(Integer::compareTo).get();
        return num;
    }

}
