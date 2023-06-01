package questionBank;


/**
 * <p>
 *      E0104_MaxDepth
 *       二叉树的最大深度
 * </p>
 *
 * @author answer
 * @date 2023/5/31 10:26
 */
public class E0104_MaxDepth {

    /**
     * 给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     * @param args
     */
    public static void main(String[] args) {
        E0104_MaxDepth test = new E0104_MaxDepth();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(test.maxDepth(root));
    }

    /**
     * 二叉树最大深度： max变量存储最长路径
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight)+1;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left)+1;
        int right = maxDepth(root.right)+1;
        return Math.max(left, right);
    }

}
