package middleAlgorithms.arrayAndString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author answer
 * @Description: <p>二叉树的锯齿形层次遍历</p>
 * @date 2023/4/4 20:09
 */
public class ZigzagLevelOrder {

    public static void main(String[] args) {
        ZigzagLevelOrder test = new ZigzagLevelOrder();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        test.zigzagLevelOrder(root);
    }

    /**
     * root = [3,9,20,null,null,15,7] => [[3],[20,9],[15,7]]
     *
     * @param root
     * @return 递归
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, 0, res);
        return res;
    }

    public void traverse(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (depth >= res.size()) {
            res.add(new ArrayList<Integer>());
        }
        if (depth % 2 == 0) {
            res.get(depth).add(root.val);
        } else {
            res.get(depth).add(0, root.val);
        }
        traverse(root.left, depth + 1, res);
        traverse(root.right, depth + 1, res);
    }

}
