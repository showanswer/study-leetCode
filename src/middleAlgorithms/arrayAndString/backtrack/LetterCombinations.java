package middleAlgorithms.arrayAndString.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author answer
 * @Description: <p>电话号码的字母组合</p>
 * @date 2023/4/16 10:06
 */
public class LetterCombinations {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     */
    public static void main(String[] args) {
        LetterCombinations test = new LetterCombinations();
        System.out.println(test.letterCombinations("23").toString());
    }

    /**
     * digits = "23" => ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     */
    public List<String> letterCombinations(String digits) {
        // 队列 先进先出
        LinkedList<String> res = new LinkedList<>();
        if (digits ==null || digits.length() ==0) {
            return  res;
        }

        char[][] tb = {{'a', 'b','c'},{'d', 'e','f'},{'g', 'h','i'},
                {'j', 'k','l'},{'m', 'n','o'},{'p', 'q','r','s'},{'t', 'u','v'},{'w', 'x','y','z'}};

        res.add("");
        while (res.peek().length() != digits.length()) {
            String remove = res.poll();
            char[] chars = tb[digits.charAt(remove.length()) - '2'];
            for (int i = 0; i < chars.length; i++) {
                res.add(remove+chars[i]);
            }
        }
        return res;
    }

}
