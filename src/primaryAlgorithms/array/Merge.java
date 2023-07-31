package primaryAlgorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author answer
 * @Description: <p>Merge</p>
 * @date 2023/1/29 16:29
 */
public class Merge {

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     *
     * @param args 1、对二维数组进行排序，按照第一列升序列排列
     *             2、借用临时空间，判断是否需要何合并集合当前值，当前集合是否放入结果集触发点
     */
    public static void main(String[] args) {
        Merge merge = new Merge();
        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge1 = merge.merge(nums);
        System.out.println("*****");
    }

    /**
     * intervals = [[1,3],[2,6],[8,10],[15,18]] => [[1,6],[8,10],[15,18]];
     * intervals = [[1,4],[4,5]] => [[1,5]];
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        //1、对二维数组按照第一列升序排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        //2、进行合并数组
        List<int[]> list = new ArrayList<>();
        //临时空间，1 判断是否需要合并集合，2 是否放入结果集
        int[] term = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            // 循环遍历： 后面每个数组元素的第一个值 比较 第一个数组的第二个值
            if (term[1] >= intervals[i][0]) {
                term[1] = Math.max(term[1], intervals[i][1]);
            } else {
                list.add(term);
                term = intervals[i];
            }
        }
        list.add(term);
        // 集合转为二维数组
        return list.toArray(new int[list.size()][2]);
    }

}
