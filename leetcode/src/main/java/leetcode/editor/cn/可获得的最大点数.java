/**
 * @Title: 1423.可获得的最大点数
 * @TitleSlug: maximumPointsYouCanObtainFromCards
 * @Author: Neo
 * @Date: 2023-12-03 12:28:03
 */
package leetcode.editor.cn;

public class 可获得的最大点数 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 可获得的最大点数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int n = cardPoints.length;
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + cardPoints[i];
            }
            int ans = 0;
            for (int l = 0; l <= k; l++) {
                int r = n - (k - l);
                int cur = sum[l] + sum[n] - sum[r];
                ans = Math.max(cur, ans);
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       