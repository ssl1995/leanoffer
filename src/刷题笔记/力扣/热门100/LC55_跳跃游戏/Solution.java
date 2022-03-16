package 刷题笔记.力扣.热门100.LC55_跳跃游戏;

/**
 * @author SongShengLin
 * @date 2022/1/26 8:58 AM
 * @description
 */
public class Solution {
    /**
     * 跳跃游戏
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。判断你是否能够到达最后一个下标。
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        int n = nums.length;
        int mostRight = nums[0];
        for (int i = 0; i < n; i++) {
            // 失败：i一旦越过最长距离，就false
            if (i > mostRight) {
                return false;
            }
            // 最长距离为i+nums[i]中的最大值
            mostRight = Math.max(mostRight, i + nums[i]);

            // 成功：一旦最长距离包含数组最后一个下标，返回true
            if (mostRight >= n - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(solution.canJump(nums));
    }
}
