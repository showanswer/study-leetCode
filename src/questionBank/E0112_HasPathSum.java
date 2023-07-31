package questionBank;

/**
 * <p>
 * E0112_HasPathSum
 * </p>
 *
 * @author answer
 * @date 2023/6/2 22:38
 */
public class E0112_HasPathSum {

    public static void main(String[] args) {
        E0112_HasPathSum test = new E0112_HasPathSum();
        test.hasPathSum(new TreeNode(), 5);
    }


    /**
     * 思路： 这个是到根节点的, 判断根节点是否匹配即可
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.right, targetSum - root.val) || hasPathSum(root.left, targetSum - root.val);
    }
}
