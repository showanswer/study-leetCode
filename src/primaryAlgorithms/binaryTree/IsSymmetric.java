package primaryAlgorithms.binaryTree;

/**
 * @author answer
 * @Description: <p>对称二叉树</p>
 * @date 2023/1/1 22:26
 */
public class IsSymmetric {

    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     *
     * @param args
     */
    public static void main(String[] args) {
        IsSymmetric test = new IsSymmetric();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(4);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode6;
        treeNode3.right = treeNode5;
        treeNode3.left = treeNode7;
        boolean flag = test.isSymmetric(treeNode1);
        System.out.println(flag);
    }

    /**
     * root = [1,2,2,3,4,4,3] => true; root = [1,2,2,null,3,null,3]=>false
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 从两个子节点开始判断
        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        //如果当前节点只有一个子节点或者有两个子节点，但两个子节点的值不相同，直接返回false
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        boolean leftFlag = isSymmetricHelper(left.left, right.right);
        boolean rightFlag = isSymmetricHelper(left.right, right.left);
        return leftFlag && rightFlag;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
