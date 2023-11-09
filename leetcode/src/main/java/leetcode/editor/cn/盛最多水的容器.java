/**
 * @Title: 11.盛最多水的容器
 * @TitleSlug: containerWithMostWater
 * @Author: Neo
 * @Date: 2023-11-09 20:50:03
 */
package leetcode.editor.cn;

public class 盛最多水的容器 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 盛最多水的容器().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1;
            int ans = 0;
            while (l < r) {
                if (height[l] <= height[r]) {
                    ans = Math.max(ans, (r - l) * height[l]);
                    l++;
                } else {
                    ans = Math.max(ans, (r - l) * height[r]);
                    r--;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       