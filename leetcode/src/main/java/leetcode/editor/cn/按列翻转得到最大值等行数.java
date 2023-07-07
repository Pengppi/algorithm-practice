/**
 * @Title: 1072.按列翻转得到最大值等行数
 * @TitleSlug: flipColumnsForMaximumNumberOfEqualRows
 * @Author: Neo
 * @Date: 2023-05-15 00:09:56
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

public class 按列翻转得到最大值等行数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 按列翻转得到最大值等行数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxEqualRowsAfterFlips(int[][] matrix) {
            int ans = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int[] row : matrix) {
                char[] cs = new char[row.length];
                for (int i = 0; i < row.length; i++) {
                    cs[i] = (char) (row[i] ^ row[0]);
                }
                String key = new String(cs);
                map.put(key, map.getOrDefault(key, 0) + 1);
                ans = Math.max(ans, map.get(key));
            }
            return ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       