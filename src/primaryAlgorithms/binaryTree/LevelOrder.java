package primaryAlgorithms.binaryTree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author answer
 * @Description: <p>二叉树的层序遍历</p>
 * @date 2023/1/1 22:44
 */
public class LevelOrder {

    /**
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     *
     * @param args
     */
    public static void main(String[] args) {
        LevelOrder test = new LevelOrder();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        List<List<Integer>> lists = test.levelOrder(treeNode1);
    }

    /**
     * root = [3,9,20,null,null,15,7] => [[3],[9,20],[15,7]]
     *
     * @param root
     * @return 把每层得值存入到队列中, 记录遍历完一个值后出队一个
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 把当前节点加进队列中
        queue.offer(root);
        // 队列不为空， 有元素没有被遍历完
        while (!queue.isEmpty()) {
            // 记录每层有多少个节点
            int size = queue.size();
            // 新建子list，存储当前层得节点元素值
            List<Integer> list = new ArrayList<>(size);
            // 该层所有节点都要遍历完
            while (size-- > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
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
