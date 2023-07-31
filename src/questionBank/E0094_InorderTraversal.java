package questionBank;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * E0094_InorderTraversal
 * </p>
 *
 * @author answer
 * @date 2023/5/31 9:13
 */
public class E0094_InorderTraversal {

    public static void main(String[] args) {
        E0094_InorderTraversal test = new E0094_InorderTraversal();
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode root3 = new TreeNode(1);
        root.right = root3;
        root3.left = node2;
        node2.left = node1;
        test.inorderTraversal(root);
    }

    /**
     * 中序遍历有两种方式： 递归 和  非递归
     *
     * @param root
     * @return 思路： 递归的话： 左-中-右
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }

    public void traverse(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        traverse(root.left, res);
        res.add(root.val);
        traverse(root.right, res);
    }


    /**
     * 非递归：需要用栈 先进后出。 把左侧的一直存入栈中，这样最下的一个左节点会出栈入列表
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (root.left != null) {
            root = root.left;
            stack.push(root);
        }
        while (stack.size() > 0) {
            root = stack.pop();
            res.add(root.val);
            if (root.right != null) {
                root = root.right;
                stack.push(root);
                while (root.left != null) {
                    root = root.left;
                    stack.push(root);
                }
            }
        }
        return res;
    }

}
