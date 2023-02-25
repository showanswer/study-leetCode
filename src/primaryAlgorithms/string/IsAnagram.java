package primaryAlgorithms.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author answer
 * @Description: <p>有效的字母异位词</p>
 * @date 2022/12/20 13:14
 */
public class IsAnagram {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     *
     * @param args
     */
    public static void main(String[] args) {
        IsAnagram test = new IsAnagram();
        boolean flag = test.isAnagram2("anagram", "nagaram");
        System.out.println(flag);
    }

    /**
     * s = "anagram", t = "nagaram"=> true; s = "rat", t = "car"=> false
     *
     * @param s
     * @param t
     * @return 思路： 先统计每个字符串中字符的个数， 在比较
     */
    public boolean isAnagram2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars1 = s.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            map.put(chars1[i], map.getOrDefault(chars1[i], 0)+1);
        }
        char[] chars2 = t.toCharArray();
        for (int i = 0; i < chars2.length; i++) {
            if (map.get(chars2[i]) != null) {
                map.put(chars2[i], map.get(chars2[i])-1);
            } else {
                return false;
            }
        }
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            count[chars[i] - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            int num = t.charAt(i) - 'a';
            // 如果元素不存在， 直接返回false
            if (count[num] == 0) {
                return false;
            }
            count[num]--;
        }
        return true;
    }

    /**
     * 先排序， 在直接比较
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }

}
