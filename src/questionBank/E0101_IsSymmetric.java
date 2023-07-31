package questionBank;


/**
 * <p>
 * E0101_IsSymmetric
 * </p>
 *
 * @author answer
 * @date 2023/5/31 10:11
 */
public class E0101_IsSymmetric {

    /**
     * 对称二叉树： 可以看作 两个树是否相同
     *
     * @param args
     */
    public static void main(String[] args) {
        E0101_IsSymmetric test = new E0101_IsSymmetric();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node11 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node22 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node33 = new TreeNode(4);
        root.left = node1;
        root.right = node11;
        node1.left = node2;
        node1.right = node3;
        node11.left = node22;
        node11.right = node33;
        test.isSymmetric(root);
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

}
