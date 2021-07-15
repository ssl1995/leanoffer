package tag刷题.C01_数组.NC32_求平方根;

public class Solution {
    public int sqrt(int x) {
        // base case：x是 0 or 1 时特殊判断
        if (x == 0 || x == 1) {
            return x;
        }
        // 一个数的平方根:[1,x/2]
        int left = 1;
        int right = x / 2;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // mid*mid会越界，但是/mid，mid不能为0，所以left从1开始，right不会超过x/2
            if (mid <= (x / mid)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
