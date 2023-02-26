package primaryAlgorithms.array;

/**
 * @author answer
 * @Description: <p>对角线遍历</p>
 * @date 2023/2/26 21:57
 */
public class FindDiagonalOrder {

    /**
     * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
     * @param args
     */
    public static void main(String[] args) {
        FindDiagonalOrder test = new FindDiagonalOrder();
        int[][] nums = {{1,2}, {3,4}};
        test.findDiagonalOrder(nums);
        System.out.println("*******");
    }

    /**
     * mat = [[1,2,3],[4,5,6],[7,8,9]] => [1,2,4,7,5,3,6,8,9]
     * mat = [[1,2],[3,4]] => [1,2,3,4]
     * @param mat
     * @return
     * [0,0],[0,1],[1,0],[1,1]
     * [0,0],[0,1],[1,0],[2,0],[1,1],[0,2],[2,1],[2,2]
     *
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] result = new int[n*m];

        for(int i = 0,idx=0;i<n+m-1;i++){
            //偶数对角线 ，从下往上遍历
            if(i%2==0){
                for(int x=Math.min(i,n-1);x>=Math.max(0,i-m+1);x--){
                    result[idx++] = mat[x][i-x];
                }
            } else {
                //奇数对角线 ，从上往下遍历
                for(int x=Math.max(0,i-m+1);x<=Math.min(i,n-1);x++){
                    result[idx++] = mat[x][i-x];
                }
            }
        }
        return result;
    }

}
