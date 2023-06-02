package questionBank;

/**
 * <p>
 * E0111_MinDepth
 * </p>
 *
 * @author answer
 * @date 2023/6/2 22:08
 */
public class E0111_MinDepth {

    public static void main(String[] args) {
        E0111_MinDepth test = new E0111_MinDepth();
        TreeNode root = new TreeNode();
        test.minDepth(root);
    }

    /**
     * 树的最小深度： 从根节点到叶子节点
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root==null) {
            return 0;
        } else if (root.left == null) {
            return minDepth(root.right)+1;
        }else if (root.right ==null) {
           return minDepth(root.left)+1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right))+1;
        }
    }

}
