/**
 * @Title: 42.接雨水
 * @TitleSlug: trappingRainWater
 * @Author: Neo
 * @Date: 2023-07-23 20:19:52
 */
package leetcode.editor.cn;

public class 接雨水 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 接雨水().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            int[] l = new int[n], r = new int[n];

            for (int i = 0; i < n - 1; i++) {
                l[i + 1] = Math.max(l[i], height[i]);
            }
            for (int i = n - 1; i > 0; i--) {
                r[i - 1] = Math.max(r[i], height[i]);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int c = Math.min(l[i], r[i]) - height[i];
                if (c > 0) {
                    ans += c;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       