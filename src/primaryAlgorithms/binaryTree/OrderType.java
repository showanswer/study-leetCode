package primaryAlgorithms.binaryTree;

import java.util.Stack;

/**
 * @author answer
 * @Description: <p>OrderType</p>
 * @date 2022/12/31 22:41
 */
public class OrderType {

    public static void main(String[] args) {
        OrderType test = new OrderType();

        TreeNode node = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        node.left = node1;
        node.right = node2;
        node2.left = node3;
        node2.right = node4;

        OrderType.inOrderTraversal1(node);
    }

    /**
     * 递归前序遍历
     *
     * @param node
     */
    private static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 非递归实现
     *
     * @param node
     */
    private static void preOrder1(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> q1 = new Stack<>();
        // 入栈
        q1.push(node);
        while (!q1.isEmpty()) {
            //出栈
            TreeNode t1 = q1.pop();
            System.out.println(t1.val);
            if (t1.right != null) {
                q1.push(t1.right);
            }
            if (t1.left != null) {
                q1.push(t1.left);
            }

        }

    }


    /**
     * 中序遍历： 递归实现
     *
     * @param node
     */
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.val + "");
        inOrderTraversal(node.right);
    }

    /**
     * 中序遍历： 非递归写法
     *
     * @param tree
     */
    public static void inOrderTraversal1(TreeNode tree) {
        Stack<TreeNode> stack = new Stack<>();
        while (tree != null || !stack.isEmpty()) {
            while (tree != null) {
                stack.push(tree);
                tree = tree.left;
            }
            if (!stack.isEmpty()) {
                tree = stack.pop();
                System.out.println(tree.val);
                tree = tree.right;
            }
        }

    }


    /**
     * 后序遍历: 递归遍历
     *
     * @param tree
     */
    public static void postOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        postOrder(tree.left);
        postOrder(tree.right);
        System.out.println(tree.val);
    }

    /**
     * 后序遍历法： 非递归遍历1
     *
     * @param tree
     */
    public static void postOrder1(TreeNode tree) {
        if (tree == null) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(tree);
        while (!s1.isEmpty()) {
            tree = s1.pop();
            s2.push(tree);
            if (tree.left != null) {
                s1.push(tree.left);
            }
            if (tree.right != null) {
                s1.push(tree.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().val + " ");
        }
    }

    /**
     * 后序遍历法： 非递归遍历2
     *
     * @param tree
     */
    public static void postOrder2(TreeNode tree) {

        if (tree == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree);
        TreeNode c;
        while (!stack.isEmpty()) {
            c = stack.peek();
            if (c.left != null && tree != c.left && tree != c.right) {
                stack.push(c.left);
            } else if (c.right != null && tree != c.right) {
                stack.push(c.right);
            } else {
                System.out.print(stack.pop().val + " ");
                tree = c;
            }
        }

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
