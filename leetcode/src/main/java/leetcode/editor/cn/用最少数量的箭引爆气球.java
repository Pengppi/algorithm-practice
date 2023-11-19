/**
 * @Title: 452.用最少数量的箭引爆气球
 * @TitleSlug: minimumNumberOfArrowsToBurstBalloons
 * @Author: Neo
 * @Date: 2023-11-20 00:21:29
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 用最少数量的箭引爆气球 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 用最少数量的箭引爆气球().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinArrowShots(int[][] points) {
            int n = points.length;
            Arrays.sort(points, (a, b) -> ( Integer.compare(a[1], b[1])));
            int ans = 1, r = points[0][1];
            for (int i = 1; i < n; i++) {
                if (points[i][0] > r) {
                    ans++;
                    r = points[i][1];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       