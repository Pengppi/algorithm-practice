/**
 * @Title: 1637.两点之间不包含任何点的最宽垂直区域
 * @TitleSlug: widestVerticalAreaBetweenTwoPointsContainingNoPoints
 * @Author: Neo
 * @Date: 2023-03-30 13:55:39
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 两点之间不包含任何点的最宽垂直区域 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 两点之间不包含任何点的最宽垂直区域().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxWidthOfVerticalArea(int[][] points) {
            Arrays.sort(points, (a, b) -> (a[0] - b[0]));
            int ans = 0;
            for (int i = 1; i < points.length; i++) {
                ans = Math.max(ans, points[i][0] - points[i - 1][0]);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}


