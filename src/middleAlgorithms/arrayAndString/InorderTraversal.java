package middleAlgorithms.arrayAndString;

import jdk.nashorn.internal.runtime.regexp.joni.constants.Traverse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author answer
 * @Description: <p>InorderTraversal</p>
 * @date 2023/4/4 23:10
 */
public class InorderTraversal {
    public static void main(String[] args) {
        InorderTraversal test = new InorderTraversal();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;
        test.inorderTraversal(root);
    }

    /**
     * 非递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root ==null) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (root.left != null) {
            root=  root.left;
            stack.push(root);
        }
        while (stack.size()>0){
            root = stack.pop();
            res.add(root.val);
            if (root.right != null) {
                root = root.right;
                stack.push(root);
                while (root.left != null){
                    root = root.left;
                    stack.push(root);
                }
            }
        }
        return res;
    }

    /**
     * root = [1,null,2,3] => [1,3,2]
     * @param root
     * @return
     *
     * 递归
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }

    public void traverse(TreeNode root, List<Integer> res) {
        if (root ==null) {
            return;
        }
        traverse(root.left, res);
        res.add(root.val);
        traverse(root.right,res);
    }


}
