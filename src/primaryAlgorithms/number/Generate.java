package primaryAlgorithms.number;

import java.util.ArrayList;
import java.util.List;

/**
 * @author answer
 * @Description: <p>杨辉三角</p>
 * @date 2023/1/22 19:35
 */
public class Generate {

    /**
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     *
     * @param args
     */
    public static void main(String[] args) {
        Generate generate = new Generate();
        List<List<Integer>> list = generate.generate(5);
        System.out.println("********");
    }

    /**
     * numRows = 5=> [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]; numRows = 1=> [[1]];
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        //结果值
        List<List<Integer>> res = new ArrayList<>();
        //每一行的元素
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            //下面一行都会比上面一行多一个元素，我们在第一个位置给他加个1
            row.add(0, 1);
            for (int j = 1; j < row.size()-1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            //把结果存放到res中
            res.add(new ArrayList<>(row));
        }
        return res;
    }

    /**
     * 思路：
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate1(int numRows) {
        //结果值
        List<List<Integer>> res = new ArrayList<>();
        //每一行的元素
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            //下面一行都会比上面一行多一个元素，我们在第一个位置给他加个1
            row.add(0,1);
            for (int j = 1; j < row.size()-1; j++) {
                row.set(j, row.get(j)+row.get(j+1));
            }
            //把结果存放到res中
            res.add(new ArrayList<>(row));
        }
        return res;
    }

}
