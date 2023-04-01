package primaryAlgorithms.string;

import javafx.scene.chart.NumberAxis;

/**
 * @author answer
 * @Description: <p>盛最多水的容器</p>
 * @date 2023/3/25 20:51
 */
public class MaxArea {

    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     *
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * @param args
     */
    public static void main(String[] args) {
        MaxArea test = new MaxArea();
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(test.maxArea(nums));
    }

    /**
     * [1,8,6,2,5,4,8,3,7] => 49;
     * height = [1,1] =>1;
     * @param height
     * @return
     *  1: 如果长板变得比短板还短，那么容积显然减少。
     *  2: 如果长板变得比短板长或相等，因为短板依旧未变。但距离减少，所以容积依旧减少。
     */
    public int maxArea(int[] height) {
        int left =0;
        int right = height.length-1;
        int max =0;
        while (left < right) {
            int len = right-left;
            int res = height[left] > height[right] ? height[right--] : height[left++];
            max = Math.max(len*res, max);
        }
        return max;
    }

}
