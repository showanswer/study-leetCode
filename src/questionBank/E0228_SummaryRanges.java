package questionBank;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * E0228_SummaryRanges
 * </p>
 *
 * @author answer
 * @date 2023/7/31 19:49
 */
public class E0228_SummaryRanges {

    public static void main(String[] args) {
        E0228_SummaryRanges test = new E0228_SummaryRanges();
        int[] nums = {0,1,2,4,5,7};
        System.out.println(test.summaryRanges(nums));
    }

    /**
     *  从右往左遍历，差值大于一就 就找到一个区间
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int i =0;
        int n =nums.length;
        while (i<n) {
            int low = i;
            i++;
            while (i<n && nums[i] == nums[i-1]+1) {
                i++;
            }
            int high =i-1;
            StringBuilder sb = new StringBuilder(String.valueOf(nums[low]));
            if (low < high) {
                sb.append("->");
                sb.append(String.valueOf(nums[high]));
            }
            list.add(sb.toString());
        }
        return list;
    }

}
