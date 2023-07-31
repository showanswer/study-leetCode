package middleAlgorithms.arrayAndString;

import java.util.HashMap;

/**
 * @author answer
 * @Description: <p>无重复字符的最长子串</p>
 * @date 2023/3/30 22:36
 */
public class LengthOfLongestSubstring {


    public static void main(String[] args) {
        LengthOfLongestSubstring test = new LengthOfLongestSubstring();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * 思路： 无重复字符的最长子串
     * 无重复： 判断重复肯定要有个标识来判断是否重复， 可以用map，判断key是否存在
     * 最长字串：需要有索引来标识， 需要两个索引得到两者之间的距离， 需要一个参数保存这个而最大值
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int length = s.length();
        int max = 0;

        for (int i = 0, j = 0; i < length; i++) {
            // 如果遇见重复的， 那就从起点索引的下一个开始算
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

}
