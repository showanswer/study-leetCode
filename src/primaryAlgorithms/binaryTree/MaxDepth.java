package primaryAlgorithms.binaryTree;

import javax.swing.tree.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author answer
 * @Description: <p>二叉树的最大深度</p>
 * @date 2022/12/24 20:08
 */
public class MaxDepth {

    /**
     * 给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * @param args
     */
    public static void main(String[] args) {
        MaxDepth test = new MaxDepth();
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node.left = node1;
        node.right = node2;
        node2.left = node3;
        node2.right = node4;
        int depth = test.maxDepth2(node);
        System.out.println(depth);
    }

    /**
     * BFS的实现原理就是一层层遍历，统计一下总共有多少层，我们来画个图分析一下。
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //创建一个队列
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int count = 0;
        while (!deque.isEmpty()) {
            //每一层的个数
            int size = deque.size();
            while (size-- > 0) {
                TreeNode cur = deque.pop();
                if (cur.left != null) {
                    deque.addLast(cur.left);
                }
                if (cur.right != null) {
                    deque.addLast(cur.right);
                }
            }
            count++;
        }
        return count;
    }

    /**
     * [3,9,20,15,7] => 3
     *
     * @param root
     * @return 思路： 递归实现
     */
    public int maxDepth(TreeNode root) {
        int num = root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return num;
    }

    /**
     * 思路： 递归实现
     *
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth1(root.left) + 1;
        int right = maxDepth1(root.right) + 1;
        return Math.max(left, right);
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
