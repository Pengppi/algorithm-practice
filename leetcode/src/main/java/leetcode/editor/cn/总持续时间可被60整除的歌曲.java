/**
 * @Title: 1010.总持续时间可被 60 整除的歌曲
 * @TitleSlug: pairsOfSongsWithTotalDurationsDivisibleBy60
 * @Author: Neo
 * @Date: 2023-05-07 10:56:43
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

public class 总持续时间可被60整除的歌曲 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 总持续时间可被60整除的歌曲().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numPairsDivisibleBy60(int[] time) {
            int n = time.length;
            int ans = 0;
            int[] cnt = new int[60];
            for (int i = 0; i < n; i++) {
                int t = time[i] % 60;
                if (t == 0) {
                    ans += cnt[0];
                    cnt[0]++;
                } else {
                    ans += cnt[60 - t];
                    cnt[t]++;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       