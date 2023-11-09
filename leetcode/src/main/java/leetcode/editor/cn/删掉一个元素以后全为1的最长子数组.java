/**
 * @Title: 1493.删掉一个元素以后全为 1 的最长子数组
 * @TitleSlug: longestSubarrayOf1sAfterDeletingOneElement
 * @Author: Neo
 * @Date: 2023-11-09 20:58:02
 */
package leetcode.editor.cn;

public class 删掉一个元素以后全为1的最长子数组 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 删掉一个元素以后全为1的最长子数组().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubarray(int[] nums) {
            int len = 0, cnt = 0, n = nums.length, pos = -1;
            while (cnt < 1 && len < n) {
                if (nums[len] == 0) {
                    cnt++;
                    pos = len;
                }
                len++;
            }
            int ans = len;
            for (int i = len; i < n; i++) {
                if (nums[i] == 0) {
                    len = i - pos;
                    pos = i;
                } else {
                    len++;
                }
                ans = Math.max(ans, len);
            }
            return (ans - 1) > 0 ? ans - 1 : 0;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       