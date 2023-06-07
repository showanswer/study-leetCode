package questionBank;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * E0154_PostorderTraversal
 * 二叉树的后序遍历
 * </p>
 *
 * @author answer
 * @date 2023/6/5 22:27
 */
public class E0154_PostorderTraversal {

    public static void main(String[] args) {
        E0154_PostorderTraversal test = new E0154_PostorderTraversal();
        System.out.println(test.postorderTraversal(null));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postHelper(root,res);
        return res;
    }

    private void postHelper(TreeNode root, List<Integer> res) {
        if (root ==null) {
            return;
        }
        postHelper(root.left, res);
        postHelper(root.right, res);
        res.add(root.val);
    }

}
