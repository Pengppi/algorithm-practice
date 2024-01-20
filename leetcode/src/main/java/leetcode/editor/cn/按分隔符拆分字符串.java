/**
 * @Title: 2788.按分隔符拆分字符串
 * @TitleSlug: splitStringsBySeparator
 * @Author: Neo
 * @Date: 2024-01-20 23:46:27
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 按分隔符拆分字符串 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 按分隔符拆分字符串().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> splitWordsBySeparator(List<String> words, char separator) {
            List<String> ans = new ArrayList<>();
            words.forEach(word -> {
                int i = 0;
                StringBuilder sb = new StringBuilder();
                while (i <= word.length()) {
                    if (i == word.length()||word.charAt(i) == separator  ) {
                        if (sb.length() != 0) {
                            ans.add(sb.toString());
                            sb.delete(0, sb.length());
                        }
                    } else {
                        sb.append(word.charAt(i));
                    }
                    i++;
                }
            });
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       