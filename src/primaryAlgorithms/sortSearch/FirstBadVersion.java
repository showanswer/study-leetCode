package primaryAlgorithms.sortSearch;

/**
 * @author answer
 * @Description: <p>第一个错误的版本</p>
 * @date 2023/1/2 21:38
 */
public class FirstBadVersion {

    /**
     * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
     * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
     * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
     * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     *
     * @param args
     */
    public static void main(String[] args) {
        FirstBadVersion test = new FirstBadVersion();
        int version = test.firstBadVersion(5);
        System.out.println(version);
    }

    /**
     * n = 5, bad = 4 => 4; n = 1, bad = 1=>1
     *
     * @param n
     * @return 思路： 二分查找，先从中间版本开始调用api测试
     */
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }


    boolean isBadVersion(int version) {
        return true;
    }

    ;
}
