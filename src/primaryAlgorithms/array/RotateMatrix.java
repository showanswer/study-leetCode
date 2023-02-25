package primaryAlgorithms.array;

/**
 * @author answer
 * @Description: <p>RotateMatrix</p>
 * @date 2022/12/19 21:07
 */
public class RotateMatrix {

    /**
     * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     * @param args
     */
    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        int [][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        rotateMatrix.rotate(nums);
        System.out.println("***");
    }

    /**
     * matrix = [[1,2,3],[4,5,6],[7,8,9]] =>[[7,4,1],[8,5,2],[9,6,3]]
     * matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]] => [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
     * @param matrix
     * 思路： 矩阵旋转， 先上下交换(整个层级进行交换的)， 然后在对角线交换（对应元素）
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length/2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[length -1 -i];
            matrix[length -1 -i] = temp;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }


    /**
     * 思路2： 直接交换元素对象
     * @param matrix
     */
    public void rotate1(int[][] matrix) {
        int length = matrix.length;

        for (int i = 0; i < length/2; i++) {
            for (int j = i; j < length -i -1; j++) {
                int temp = matrix[i][j];
                int m = length - j - 1;
                int n = length - i - 1;
                matrix[i][j] = matrix[m][i];
                matrix[m][i] = matrix[n][m];
                matrix[n][m] = matrix[j][n];
                matrix[j][n] = temp;
            }

        }
    }

}
