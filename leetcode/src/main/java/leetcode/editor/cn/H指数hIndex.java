/**
 * @Title: 274.H 指数
 * @TitleSlug: hIndex
 * @Author: Neo
 * @Date: 2024-03-16 19:07:03
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class H指数hIndex {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new H指数hIndex().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int n = citations.length;
            int ans = 0;
            for (int i = n - 1; i >= 0; i--) {
                int k = n - i;
                if (citations[i] >= k) {
                    ans = k;
                } else {
                    break;
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       