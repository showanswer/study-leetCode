package primaryAlgorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author answer
 * @Description: <p>两个数组的交集 II</p>
 * @date 2022/12/14 22:32
 */
public class Intersect {

    /**
     * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
     * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
     *
     * @param args
     */
    public static void main(String[] args) {
        Intersect test = new Intersect();
        int [] nums1 =new int[]{4,9,5};
        int [] nums2 =new int[]{9,4,9,8,4};
        int[] res = test.intersect1(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    /**
     * nums1 = [1,2,2,1], nums2 = [2,2]=>[2,2]
     * nums1 = [4,9,5], nums2 = [9,4,9,8,4]=>[4,9]
     * 把相交集的数据存放到 新数组中返回
     *
     * @param nums1
     * @param nums2
     * @return
     * 思路：先数组排序遍历， 两个同时遍历，小的一方相加，相等则添加到数组中
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0;
        while (i<nums1.length && j <nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        // 交集数据取出后， 转为数组
        int[] res = new int[list.size()];
        for (int k = 0; k < res.length; k++) {
            res[k] = list.get(k);
        }
        return res;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        // 交集数据取出后， 转为数组
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }


    /**
     * 思路1: 使用map 实现数据遍历nums1中的所有元素，把它存放到map中，其中key就是nums1中的元素，value就是这个元素在数组nums1中出现的次数。
 *           遍历nums2中的所有元素，查看map中是否包含nums2的元素，如果包含，就把当前值加入到集合list中，然后对应的value要减1。
     * @param nums1
     * @param nums2
     * @return
     * 暴力破解法，双重循环不行， 如果nums1[2]， nums2[2,2] 这样返回的数据不好判断
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }

        for (int i = 0; i < nums2.length; i++) {
            // 存在有交集
            if (map.getOrDefault(nums2[i], 0) >0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
        // 交集数据取出后， 转为数组
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }

}
