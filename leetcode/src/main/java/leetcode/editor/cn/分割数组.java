/**
 * @Title: 915.分割数组
 * @TitleSlug: PartitionArrayIntoDisjointIntervals
 * @Author: Neo
 * @Date: 2022-10-24 12:35:07
 */
package leetcode.editor.cn;

public class 分割数组 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 分割数组().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //public int partitionDisjoint(int[] nums) {
        //    int n = nums.length;
        //    int[] minRight = new int[n];
        //    minRight[n - 1] = nums[n - 1];
        //    for (int i = n - 2; i >= 0; i--) {
        //        minRight[i] = Math.min(nums[i], minRight[i + 1]);
        //    }
        //    int mx = nums[0];
        //    for (int i = 0; i < n - 1; i++) {
        //        mx = Math.max(mx, nums[i]);
        //        if (mx <= minRight[i + 1]) {
        //            return i + 1;
        //        }
        //    }
        //    return 0;
        //}

        public int partitionDisjoint(int[] nums) {
            int n = nums.length;
            int leftMax = nums[0], leftPos = 0, curMax = leftMax;
            for (int i = 1; i < n; i++) {
                curMax = Math.max(curMax, nums[i]);
                if (nums[i] < leftMax) {
                    leftMax = curMax;
                    leftPos = i;
                }
            }
            return leftPos + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
