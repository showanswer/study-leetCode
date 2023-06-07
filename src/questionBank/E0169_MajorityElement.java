package questionBank;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * E0169_MajorityElement
 * 多数元素
 * </p>
 *
 * @author answer
 * @date 2023/6/7 21:58
 */
public class E0169_MajorityElement {

    public static void main(String[] args) {
        E0169_MajorityElement test = new E0169_MajorityElement();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(test.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value > length /2 ) {
                return key;
            }
        }
        return 0;
    }

}
