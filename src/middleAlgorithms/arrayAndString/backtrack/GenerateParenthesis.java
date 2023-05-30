package middleAlgorithms.arrayAndString.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  括号生成
 * </p>
 *
 * @author answer
 * @date 2023/4/16 11:06
 */
public class GenerateParenthesis {

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     */
    public static void main(String[] args) {
        GenerateParenthesis test = new GenerateParenthesis();
        System.out.println(test.generateParenthesis(3));
    }

    /**
     * n = 3
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, n, n, "");
        return res;
    }
    private void dfs(List<String> res, int left, int right, String curStr) {
        if (left ==0 && right ==0) {
            res.add(curStr);
            return;
        }

        if (left < 0) {
            return;
        }
        if (right < left) {
            return;
        }
        dfs(res, left -1, right, curStr+"(");
        dfs(res, left, right-1, curStr+")");
    }


}
