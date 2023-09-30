/**
 * @Title: 2136.全部开花的最早一天
 * @TitleSlug: earliestPossibleDayOfFullBloom
 * @Author: Neo
 * @Date: 2023-09-30 23:22:19
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 全部开花的最早一天 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 全部开花的最早一天().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int earliestFullBloom(int[] plantTime, int[] growTime) {
            int n = plantTime.length;
            Integer[] l = new Integer[n];
            for (int i = 0; i < n; i++) {
                l[i] = i;
            }
            Arrays.sort(l, (a, b) -> (growTime[b] - growTime[a]));
            int cur = 0, mx = 0;
            for (int i = 0; i < n; i++) {
                int pos=l[i];
                cur += plantTime[pos];
                mx=Math.max(mx,cur+growTime[pos]);
            }
            return mx;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       