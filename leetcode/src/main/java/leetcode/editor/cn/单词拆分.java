/**
 * @Title: 139.单词拆分
 * @TitleSlug: wordBreak
 * @Author: Neo
 * @Date: 2024-01-28 14:51:17
 */
package leetcode.editor.cn;

import java.util.List;

public class 单词拆分 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 单词拆分().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            boolean[] f = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (wordDict.contains(s.substring(0, i + 1))) {
                    f[i] = true;
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    if (f[j] && wordDict.contains(s.substring(j + 1, i + 1))) {
                        f[i] = true;
                        break;
                    }
                }
            }
            return f[n - 1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       