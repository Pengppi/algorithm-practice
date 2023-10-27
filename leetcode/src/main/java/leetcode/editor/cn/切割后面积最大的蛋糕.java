/**
 * @Title: 1465.切割后面积最大的蛋糕
 * @TitleSlug: maximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts
 * @Author: Neo
 * @Date: 2023-10-27 14:45:20
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 切割后面积最大的蛋糕 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 切割后面积最大的蛋糕().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
            int mod = (int) (1e9 + 7);
            long ans = 0;
            Arrays.sort(horizontalCuts);
            Arrays.sort(verticalCuts);
            int n = horizontalCuts.length;
            int hGap = Math.max(horizontalCuts[0], h - horizontalCuts[n - 1]);
            for (int i = 1; i < n; i++) {
                hGap = Math.max(hGap, horizontalCuts[i] - horizontalCuts[i - 1]);
            }
            n = verticalCuts.length;
            int vGap = Math.max(verticalCuts[0], w - verticalCuts[n - 1]);
            for (int i = 1; i < n; i++) {
                vGap = Math.max(vGap, verticalCuts[i] - verticalCuts[i - 1]);
            }
            ans = (long)hGap * vGap % mod;
            return (int) ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       