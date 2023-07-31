package primaryAlgorithms.binaryTree;

import java.util.Stack;

/**
 * @author answer
 * @Description: <p>验证二叉搜索树</p>
 * @date 2022/12/25 18:05
 */
public class IsValidBST {

    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     * <p>
     * 有效 二叉搜索树定义如下：
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * @param args
     */
    public static void main(String[] args) {
        IsValidBST test = new IsValidBST();

        TreeNode node = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        node.left = node1;
        node.right = node2;
        node2.left = node3;
        node2.right = node4;
        boolean flag = test.isValidBST3(node);
        System.out.println(flag);
    }

    TreeNode prev;

    public boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        //访问左子树 加快遍历速度 false就一路往上返回
        if (!isValidBST3(root.left)) {
            return false;
        }
        //访问当前节点：如果当前节点小于等于中序遍历的前一个节点直接返回false。
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        //访问右子树
        if (!isValidBST3(root.right)) {
            return false;
        }
        return true;

    }

    /**
     * 中序遍历非递归
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val)
                return false;
            //保存前一个访问的结点
            pre = root;
            root = root.right;
        }
        return true;
    }

    /**
     * 判断每个节点何自己的父节点是否符合 要求。 但是字节的和父节点的父节点大小判断错误
     *
     * @param root
     * @return 需要优化： 字节的需要判断范围
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        boolean lf = left.val >= root.val;
        boolean rf = right.val <= root.val;
        if (left != null && lf || right != null && rf) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
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

    /**
     * 判断其是否是一个有效的二叉搜索树
     *
     * @param root
     * @return 有效 二叉搜索树定义如下：
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     */
    public boolean isValidBST2(TreeNode root) {
        return isValidBSTT(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTT(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }
        if (root.val <= minVal || root.val >= maxVal) {
            return false;
        }
        if (root.left != null && root.val <= root.left.val || root.right != null && root.val >= root.right.val) {
            return false;
        }
        return isValidBSTT(root.left, minVal, root.val) && isValidBSTT(root.right, root.val, maxVal);

    }
}
