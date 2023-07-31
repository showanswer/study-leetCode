package questionBank;


/**
 * <p>
 * E0100_IsSameTree
 * </p>
 *
 * @author answer
 * @date 2023/5/31 9:51
 */
public class E0100_IsSameTree {

    /**
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *
     * @param args
     */
    public static void main(String[] args) {
        E0100_IsSameTree test = new E0100_IsSameTree();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        TreeNode roots = new TreeNode(1);
        TreeNode nodes1 = new TreeNode(2);
        TreeNode nodes2 = new TreeNode(3);
        roots.left = nodes1;
        roots.right = nodes2;
        test.isSameTree(root, roots);
    }

    /**
     * 判断结构是否相同： 就是判断节点是否为空
     * 判断值是否相同： 直接比较值
     *
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

}
