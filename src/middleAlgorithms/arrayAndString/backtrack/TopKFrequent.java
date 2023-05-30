package middleAlgorithms.arrayAndString.backtrack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <p>
 * TopKFrequent
 * </p>
 *
 * @author answer
 * @date 2023/4/17 20:43
 */
public class TopKFrequent {

    public static void main(String[] args) {
        TopKFrequent test = new TopKFrequent();
        int[] nums = {1,1,1,2,2,3};
        test.topKFrequent(nums, 2);
    }

    /**
     * nums = [1,1,1,2,2,3], k = 2 => [1,2]
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll()[0];
        }
        return res;
    }

}
