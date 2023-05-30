package middleAlgorithms.arrayAndString.backtrack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <p>
 * FindKthLargest
 * </p>
 *
 * @author answer
 * @date 2023/4/17 21:00
 */
public class FindKthLargest {

    public static void main(String[] args) {
        FindKthLargest test = new FindKthLargest();
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(test.findKthLargest(nums, 2));
    }

    /**
     * [3,2,1,5,6,4], k = 2 => 5;
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }

}
