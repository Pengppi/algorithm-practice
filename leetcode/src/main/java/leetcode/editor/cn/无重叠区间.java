/**
 * @Title: 435.无重叠区间
 * @TitleSlug: nonOverlappingIntervals
 * @Author: Neo
 * @Date: 2023-11-19 10:52:46
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 无重叠区间 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 无重叠区间().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> (a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]));
            int ans = 0, last = 0;
            for (int i = 1; i < intervals.length; i++) {
                while (i < intervals.length &&intervals[i][0] <intervals[last][1]){
                    i++;
                    ans++;
                }
                last = i;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       