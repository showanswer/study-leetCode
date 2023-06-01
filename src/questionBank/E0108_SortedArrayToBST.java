package questionBank;

/**
 * <p>
 *      E0108_SortedArrayToBST
 *       将有序数组转换为二叉搜索树
 * </p>
 *
 * @author answer
 * @date 2023/6/1 22:52
 */
public class E0108_SortedArrayToBST {

    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     * @param args
     */
    public static void main(String[] args) {
        E0108_SortedArrayToBST test = new E0108_SortedArrayToBST();

    }

    /**
     * 思路： 有序 升序的数组 遍历转为二叉树， 中序遍历就是有序升序的
     *         中序遍历的根节点，为数组的中心元素。 奇数的话可以直接取， 偶数则有两种， 中心两个元素左边的或者右边的作为根节点都可以
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0 , nums.length-1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) /2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid-1);
        root.right = helper(nums, mid+1, right);
        return root;
    }

}
