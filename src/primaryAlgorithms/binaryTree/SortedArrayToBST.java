package primaryAlgorithms.binaryTree;

/**
 * @author answer
 * @Description: <p>将有序数组转换为二叉搜索树</p>
 * @date 2023/1/2 14:08
 */
public class SortedArrayToBST {

    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     * @param args
     */
    public static void main(String[] args) {
        SortedArrayToBST test = new SortedArrayToBST();
        int[] nums = {-10,-3,0,5,9};
        test.sortedArrayToBST(nums);
    }

    /**
     * nums = [-10,-3,0,5,9]=> [0,-3,9,-10,null,5]  |  [0,-10,5,null,-3,null,9]
     * @param nums
     * @return
     * 思路： 将数组转为平衡二叉树。 数组改为有序数组， 取出数组得中间值作为二叉树得根节点， 左侧就为左叉树得节点， 右侧元素为右叉树得节点
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);
        return root;
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
