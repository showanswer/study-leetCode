package middleAlgorithms.arrayAndString;

/**
 * @author answer
 * @Description: <p>SetZeroes</p>
 * @date 2023/3/30 21:32
 */
public class SetZeroes {

    public static void main(String[] args) {
        SetZeroes test = new SetZeroes();
        int[][] nums = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        test.setZeroes(nums);
    }

    /**
     * matrix = [[1,1,1],[1,0,1],[1,1,1]] => [[1,0,1],[0,0,0],[1,0,1]]
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

}
