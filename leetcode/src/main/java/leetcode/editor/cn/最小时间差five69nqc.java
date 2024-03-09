/**
 * @Title: LCR 035.最小时间差
 * @TitleSlug: five69nqc
 * @Author: Neo
 * @Date: 2024-03-10 00:36:03
 */
package leetcode.editor.cn;

import java.util.Collections;
import java.util.List;

public class 最小时间差five69nqc {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 最小时间差five69nqc().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            Collections.sort(timePoints);
            int ans = 24 * 60;
            int t0 = getMinutes(timePoints.get(0));
            int pre = t0;
            for (int i = 1; i < timePoints.size(); i++) {
                int cur = getMinutes(timePoints.get(i));
                ans = Math.min(ans, cur - pre);
                pre = cur;
            }
            ans = Math.min(ans, t0 + 24 * 60 - pre);
            return ans;
        }
        
        private int getMinutes(String time) {
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3));
            return hour * 60 + minute;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       