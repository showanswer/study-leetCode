package questionBank;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * E0144_PreorderTraversal
 * 二叉树的前序遍历
 * </p>
 *
 * @author answer
 * @date 2023/6/5 22:17
 */
public class E0144_PreorderTraversal {

    public static void main(String[] args) {
        E0144_PreorderTraversal test = new E0144_PreorderTraversal();
        test.preorderTraversal(null);
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preHelper(res, root);
        return res;
    }

    private void preHelper(List<Integer> res, TreeNode root){
        if (root == null) {
            return;
        }
        res.add(root.val);
        preHelper(res, root.left);
        preHelper(res, root.right);
    }
}
