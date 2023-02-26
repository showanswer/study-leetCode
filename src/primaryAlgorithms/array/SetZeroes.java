package primaryAlgorithms.array;

/**
 * @author answer
 * @Description: <p>零矩阵</p>
 * @date 2023/2/26 21:11
 */
public class SetZeroes {

    /**
     * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
     *
     * @param args
     */
    public static void main(String[] args) {
        SetZeroes test = new SetZeroes();
        int[][] nums = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        test.setZeroes(nums);
        System.out.println("*****");
    }


    /**
     * 遍历数组， 需要有个值记录哪一行那一列值为0
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int length = matrix.length;
        int length1 = matrix[0].length;
        int[] row = new int[length];
        int[] column = new int[length1];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length1; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }

        // 给行赋值0
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < length1; j++) {
                if (row[i] ==1 || column[j]==1) {
                    matrix[i][j] = 0;
                }
            }

        }


    }


}
