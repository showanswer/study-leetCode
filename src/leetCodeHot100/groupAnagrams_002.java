package leetCodeHot100;

import java.util.*;

/**
 * @author answer
 * @date 2024年08月11日 22:32
 * <Description>
 *      字母异位词
 *      把单词组成字符相同的即 字母异位词。需要根据某种特征识别进行归类的，应该用散列表。字母异位词具有 单词的字符组成相同的特征， 并最后进行 放在一起归类返回。
 *      1: 利用 排序 进行确认是否字母异位词。
 *      2：根据单词中字符的出现次数。
 * </Description>
 */
public class groupAnagrams_002 {

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     *  strs = ["eat", "tea", "tan", "ate", "nat", "bat"] => [["bat"],["nat","tan"],["ate","eat","tea"]]
     * @author answer
     * @date 2024/8/11 22:35
     * @param args
     */
    public static void main(String[] args) {
        String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(list);
        for (List<String> res : lists) {
            for (String re : res) {
                System.out.print(re);
            }
            System.out.println("*********");
        }
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        // 判断 字符组成 是否相同， 可以先进行排序， 在判断是否相同
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 对组成元素进行排序
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String words = String.valueOf(charArray);
            if (!map.containsKey(words)) {
                map.put(words, new ArrayList<String>());
            }
            map.get(words).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        // 判断 字符组成 是否相同， 可以先进行排序， 在判断是否相同
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            // 数组初始化填充， 初始都为0
            Arrays.fill(count, 0);
            // 对单词中每个字符出现的次数进行统计
            for (char c : str.toCharArray()) {
                // 每个字符 - ‘a’ 就是对应的数字。 从0开始
                count[c- 'a'] ++;
            }
            // 构建key
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                // 每个字符前加‘#’ 防止重复
                sb.append("#");
                sb.append(count[i]);
            }
            String words = sb.toString();
            if (!map.containsKey(words)) {
                map.put(words, new ArrayList<String>());
            }
            map.get(words).add(str);
        }
        return new ArrayList<>(map.values());
    }

}
