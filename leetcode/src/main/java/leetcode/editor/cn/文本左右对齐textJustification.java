/**
 * @Title: 68.文本左右对齐
 * @TitleSlug: textJustification
 * @Author: Neo
 * @Date: 2024-03-17 15:52:09
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 文本左右对齐textJustification {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 文本左右对齐textJustification().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < words.length; ) {
                int len = words[i].length(), j = i + 1;
                while (j < words.length && len + words[j].length() + j - i <= maxWidth) {
                    len += words[j++].length();
                }
                ans.add(justify(words, i, j, len, maxWidth));
                i = j;
            }
            return ans;
        }
        
        private String justify(String[] words, int i, int j, int len, int maxWidth) {
            int count = j - i;
            if (count == 1) {
                return words[i] + " ".repeat(maxWidth - len);
            }
            StringBuilder sb = new StringBuilder();
            if (j == words.length) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        sb.append(" ");
                    }
                }
                sb.append(" ".repeat(maxWidth - sb.length()));
            } else {
                int space = maxWidth - len;
                int avg = space / (count - 1);
                int extra = space % (count - 1);
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        sb.append(" ".repeat(avg + (extra-- > 0 ? 1 : 0)));
                    }
                }
            }
            return sb.toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       