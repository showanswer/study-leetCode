package questionBank;

/**
 * <p>
 * 平衡二叉树
 * E0110_IsBalanced
 * </p>
 *
 * @author answer
 * @date 2023/6/1 23:31
 */
public class E0110_IsBalanced {

    /**
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     *
     * @param args
     */
    public static void main(String[] args) {
        E0110_IsBalanced test = new E0110_IsBalanced();

    }

    /**
     * 思路： 平衡二叉树： 每个节点的子节点深度差不超过1 ， 递归循环判断每一个节点， 有一个超过则失败
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

    }

    /**
     * 判断该节点的子节点高度差
     *
     * @param root
     * @return
     */
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

}
